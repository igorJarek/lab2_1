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

    @Test public void sequenceHasOneLengthAndNotContainsItem() {

    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtFirstPos() {

    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtLastPos() {

    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtMiddlePos() {

    }

    @Test public void sequenceHasMoreThanOneLengthAndNotContainsItem() {

    }
}
