/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.wc.webcrawler;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jhoaho
 */
public class WebCrawlerTest {

    public WebCrawlerTest() {
    }

    @Test
    public void testFilterAndSortWithMoreThanFiveWords() {
        // Arrange
        List<Entry> entries = Arrays.asList(
                new Entry("Title with more than five words in the title", 1, 10, 20),
                new Entry("Short title", 2, 15, 25)
        // Add more entries as needed
        );

        WebCrawler instance = new WebCrawler();

        // Act
        List<Entry> result = instance.filterAndSort(entries, 0);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Title with more than five words in the title", result.get(0).getTitle());
    }

    @Test
    public void testFilterAndSortWithLessThanOrEqualFiveWords() {
        // Arrange
        List<Entry> entries = Arrays.asList(
                new Entry("Title with more than five words in the title", 1, 10, 20),
                new Entry("Short title", 2, 15, 25));

        WebCrawler instance = new WebCrawler();

        // Act
        List<Entry> result = instance.filterAndSort(entries, 1);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Short title", result.get(0).getTitle());
    }

    @Test
    public void testFilterAndSortWithEmptyList() {
        // Arrange
        List<Entry> entries = Arrays.asList();

        WebCrawler instance = new WebCrawler();

        // Act
        List<Entry> result = instance.filterAndSort(entries, 0);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilterAndSortWithNullList() {
        // Arrange
        List<Entry> entries = null;

        WebCrawler instance = new WebCrawler();

        // Act
        List<Entry> result = instance.filterAndSort(entries, 0);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilterAndSortWithInvalidOption() {
        // Arrange
        List<Entry> entries = null;

        WebCrawler instance = new WebCrawler();

        // Act
        List<Entry> result = instance.filterAndSort(entries, 5);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilterAndSortWithEqualNumberOfComments() {
        // Arrange
        List<Entry> entries = Arrays.asList(
                new Entry("Title 1 using more than 5 words", 1, 10, 20),
                new Entry("Title 2 using more than 5 words", 2, 10, 25),
                new Entry("Title 3 using more than 5 words", 3, 10, 30)
        );

        WebCrawler instance = new WebCrawler();

        // Act
        List<Entry> result = instance.filterAndSort(entries, 0);

        // Assert
        assertEquals(3, result.size());
        assertEquals("Title 1 using more than 5 words", result.get(0).getTitle());
        assertEquals("Title 2 using more than 5 words", result.get(1).getTitle());
        assertEquals("Title 3 using more than 5 words", result.get(2).getTitle());
    }

    @Test
    public void testFilterAndSortWithEqualNumberOfPoints() {
        // Arrange
        List<Entry> entries = Arrays.asList(
                new Entry("Title 1", 1, 10, 20),
                new Entry("Title 2", 2, 15, 20),
                new Entry("Title 3", 3, 20, 20)
        );

        WebCrawler instance = new WebCrawler();

        // Act
        List<Entry> result = instance.filterAndSort(entries, 1);

        // Assert
        assertEquals(3, result.size());
        assertEquals("Title 1", result.get(0).getTitle());
        assertEquals("Title 2", result.get(1).getTitle());
        assertEquals("Title 3", result.get(2).getTitle());
    }

}
