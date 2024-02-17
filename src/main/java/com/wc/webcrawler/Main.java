
package com.wc.webcrawler;

import java.util.Comparator;
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
        
        for (Entry entry : l) {
            System.out.println("entry = " + entry);
        }
        

    }
}
