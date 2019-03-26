package edu.iis.mto.bsearch;

import org.junit.Test;

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

        assertThat(array.length, is(equalTo(1)));
        assertThat(result.isFound(), is(equalTo(true)));
    }

    @Test
    public void sequenceHasOneLengthAndNotContainsItem() {
        int searchKey = 10;
        int insideKey = 8;
        int[] array = {insideKey};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertThat(array.length, is(equalTo(1)));
        assertThat(result.isFound(), is(equalTo(false)));
    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtFirstPos() {
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(true)));
        assertThat(result.getPosition(), is(equalTo(0)));
    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtLastPos() {
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3};
        SearchResult result = BinarySearch.search(searchKey + 3, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(true)));
        assertThat(result.getPosition(), is(equalTo(array.length - 1)));
    }

    @Test public void sequenceHasMoreThanOneLengthAndContainsItemAtMiddlePos() {
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3, searchKey + 4};
        SearchResult result = BinarySearch.search(searchKey + 2, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(true)));
        assertThat(result.getPosition(), is(equalTo(array.length / 2)));
    }

    @Test public void sequenceHasMoreThanOneLengthAndNotContainsItem() {
        int searchKey = 10;
        int[] array = {searchKey, searchKey + 1, searchKey + 2, searchKey + 3};
        SearchResult result = BinarySearch.search(searchKey + 4, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(false)));
    }
}
