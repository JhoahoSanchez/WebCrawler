
package com.wc.webcrawler;

import java.util.List;

/**
 *
 * @author Jhoaho
 */
public class Main {

    public static void main(String[] args) {
        String url = "https://news.ycombinator.com";

        WebCrawler wc = new WebCrawler();
        //List<Entry> entries = wc.getEntries(url);

        List<Entry> l = wc.getEntries(url);
        
//        for (Entry entry : l) {
//            System.out.println("entry = " + entry);
//        }
        
        System.out.println("Filtered");
        
        List<Entry> fs = wc.filterAndSort(l, 0);
        
        System.out.println("Filtered 2");
        
        List<Entry> fs2 = wc.filterAndSort(l, 1);

    }
}
