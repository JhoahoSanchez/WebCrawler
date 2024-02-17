package com.wc.webcrawler;

/**
 *
 * @author Jhoaho
 */
public class Entry {
    
    private final String title;
    private final int numOrder;
    private final int numComments;
    private final int points;

    public Entry(String title, int numOrder, int comments, int points) {
        this.title = title;
        this.numOrder = numOrder;
        this.numComments = comments;
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public int getComments() {
        return numComments;
    }

    public int getPoints() {
        return points;
    }

    
    
    @Override
    public String toString() {
        return "Entry{" + "title=" + title + ", numOrder=" + numOrder + ", comments=" + numComments + ", points=" + points + '}';
    }
    
    
    
}
