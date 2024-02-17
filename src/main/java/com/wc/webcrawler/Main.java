package com.wc.webcrawler;

import java.util.List;

/**
 *
 * @author Jhoaho
 */
public class Main {

    public static void main(String[] args) {

        WebCrawler wc = new WebCrawler();

        List<Entry> entries = wc.getEntries();

        System.out.println("\t*****\tEntries\t*****\n");
        entries.forEach(System.out::println);

        System.out.println("\n\t*****\tEntries with more than 5 words in the title\t*****\n");

        List<Entry> fs = wc.filterAndSort(entries, 0);
        fs.forEach(System.out::println);

        System.out.println("\n\t*****\tEntries with less than 5 words in the title\t*****\n");

        List<Entry> fs2 = wc.filterAndSort(entries, 1);
        fs2.forEach(System.out::println);
    }
}
