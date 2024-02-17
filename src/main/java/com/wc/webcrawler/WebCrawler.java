package com.wc.webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Jhoaho
 */
public class WebCrawler {

    public List<Entry> getEntries(String url) {
        List<Entry> entries = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements entryElements = document.select("center table tbody tr:eq(2) td table tbody tr");
            String title = "";
            String c = "";
            String p = "";
            int numOrder = 0;
            int points = 0;
            int numComments = 0;

            for (int i = 0; i < entryElements.size() - 1; i++) {
                if (entryElements.get(i).select("tr").first().className().equals("athing")) {
                    title = entryElements.get(i).select("span.titleline").text().split("\\(")[0].trim();
                    numOrder = Integer.parseInt(entryElements.get(i).select("span.rank").text().split("\\.")[0]);
                    i++;
                }
                if (entryElements.get(i).select("tr").first().className().equals("")) {
                    p = entryElements.get(i).select("span.score").text().split("\\s+")[0];
                    points = (p.equals("")) ? 0 : Integer.parseInt(p);
                    c = (entryElements.get(i).select("span.subline a:eq(5)").text());
                    numComments = (c.equals("") || c.equals("discuss")) ? 0 : Integer.parseInt(c.split("\\s")[0]);
                    i++;
                }
                /*
                if (entryElements.get(i).select("tr").first().className().equals("spacer")) {
                    //i++;
                    //System.out.println("i: " + i);
                }*/
                entries.add(new Entry(title, numOrder, numComments, points));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return entries.subList(0, Math.min(entries.size(), 30));
    }

    public List<Entry> filterAndSort(List<Entry> entries, int condition) {
        
        List<Entry> filteredEntries = new ArrayList<>();
        
        if (condition == 0) {
            
            //Filter all previous entries with more than five words in the title ordered by the number of comments first.
            
            //Filter list
            entries.stream().filter(p -> (p.getTitle().split("\\s")).length > 5).forEach(p -> filteredEntries.add(p));
            
            //sort list
            Collections.sort(filteredEntries, Comparator.comparing(Entry::getComments));
        }
        if (condition == 1) {
            
            //Filter all previous entries with less than or equal to five words in the title ordered by points.
            
            //filter by number of words in title (less or equal to 5)
            entries.stream().filter(p -> (p.getTitle().split("\\s")).length <= 5).forEach(p -> filteredEntries.add(p));
            
            //sort list
            Collections.sort(filteredEntries, Comparator.comparing(Entry::getPoints));
        }
        filteredEntries.forEach(System.out::println);
        return filteredEntries;
    }

}
