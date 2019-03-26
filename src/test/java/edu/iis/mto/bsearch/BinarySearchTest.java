package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    @Test
    public void sequenceReverse() {
        int key = 10;
        int[] array = {key, key - 1, key - 2, key - 3};
        SearchResult result = BinarySearch.search(key, array);
        assertThat(result.isFound(), is(equalTo(false)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sequenceNull() {
        int key = 10;
        SearchResult result = BinarySearch.search(key, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sequenceHasZeroLength() {
        int key = 10;
        int[] array = {};
        SearchResult result = BinarySearch.search(key, array);
    }

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
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3};
        SearchResult result = BinarySearch.search(searchKey + 3, array);

        assertTrue(array.length > 1);
        assertTrue(result.isFound());
        assertEquals(array.length - 1, result.getPosition());
    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtMiddlePos() {
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3, searchKey + 4};
        SearchResult result = BinarySearch.search(searchKey + 2, array);

        assertTrue(array.length > 1);
        assertTrue(result.isFound());
        assertEquals(array.length / 2, result.getPosition());
    }

    @Test public void sequenceHasMoreThanOneLengthAndNotContainsItem() {
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3};
        SearchResult result = BinarySearch.search(searchKey + 4, array);

        assertTrue(array.length > 1);
        assertFalse(result.isFound());
    }
}
