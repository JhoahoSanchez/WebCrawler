package com.wc.webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Jhoaho
 */
public class WebCrawler {

    private final String url = "https://news.ycombinator.com";

    public List<Entry> getEntries() {
        List<Entry> entries = new ArrayList<>();

        try {
            Document document = Jsoup.connect(this.url).get();
            Elements entryElements = document.select("center table tbody tr:eq(2) td table tbody tr");
            Element elm;
            String title = "";
            String c = "";
            String p = "";
            int numOrder = 0;
            int points = 0;
            int numComments = 0;

            for (int i = 0; i < entryElements.size() - 1; i++) {

                elm = entryElements.get(i);
                //getting title and the number of order from entry
                if (hasClass(elm, "tr", "athing")) {
                    title = getTextFromTag(elm, "span.titleline", "\\(");
                    numOrder = Integer.parseInt(getTextFromTag(elm, "span.rank", "\\."));
                    i++;
                    elm = entryElements.get(i);
                }
                //getting points and the number of comments from entry
                if (hasClass(elm, "tr", "")) {
                    p = getTextFromTag(elm, "span.score", "\\s+");
                    points = (p.equals("")) ? 0 : Integer.parseInt(p);
                    c = getTextFromTag(elm, "span.subline a:eq(5)", "\\s");
                    numComments = (c.equals("") || c.equals("discuss")) ? 0 : Integer.parseInt(c);
                    i++;
                }
                entries.add(new Entry(title, numOrder, numComments, points));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return entries.subList(0, Math.min(entries.size(), 30));
    }

    private boolean hasClass(Element element, String tag, String tagClass) { //works!
        return element.select(tag).first().className().equals(tagClass);
    }

    private String getTextFromTag(Element element, String query, String regex) {
        return element.select(query).text().split(regex)[0].trim();
    }

    public List<Entry> filterAndSort(List<Entry> entries, int option) {

        List<Entry> filteredEntries = new ArrayList<>();

        try {

            switch (option) {
                case 0:
                    //Filter all previous entries with more than five words in the title ordered by the number of comments first.
                    //Filter list
                    entries.stream().filter(p -> (p.getTitle().split("\\s")).length > 5).forEach(p -> filteredEntries.add(p));

                    //sort list
                    Collections.sort(filteredEntries, Comparator.comparing(Entry::getComments));
                    //Collections.reverse(filteredEntries); //In case if the array in descending order is needed
                    break;
                case 1:
                    //Filter all previous entries with less than or equal to five words in the title ordered by points.
                    //filter by number of words in title (less or equal to 5)
                    entries.stream().filter(p -> (p.getTitle().split("\\s")).length <= 5).forEach(p -> filteredEntries.add(p));

                    //sort list
                    Collections.sort(filteredEntries, Comparator.comparing(Entry::getPoints));
                    break;
                default:
                    throw new Exception("Unsupported option.");
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
        }

        return filteredEntries;
    }

}
