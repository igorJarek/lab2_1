package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void sequenceHasOneLengthAndContainsItem() {
        int key = 10;
        int[] array = {key};
        SearchResult result = BinarySearch.search(key, array);

        assertEquals(1, array.length);
        assertTrue(result.isFound());
    }

    @Test
    public void sequenceHasOneLengthAndNotContainsItem() {
        int searchKey = 10;
        int insideKey = 8;
        int[] array = {insideKey};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertEquals(1, array.length);
        assertFalse(result.isFound());
    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtFirstPos() {
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertTrue(array.length > 1);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtLastPos() {

    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtMiddlePos() {

    }

    @Test public void sequenceHasMoreThanOneLengthAndNotContainsItem() {

    }
}
