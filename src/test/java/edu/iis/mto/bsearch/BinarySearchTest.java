package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    /*
        test_v3
        implementacja przechowuje lewy oraz prawy indeks w zmiennych typu int o dodatnim zakresie 0x7FFFFFFF każdy
        jeżeli tabelica wejściowa będzia miała maksymalną długość 0x7FFFFFFF, to w instrukcji dla "prawej połówki"
        center = (start + end) / 2; nastąpi przekręcenie licznika a w konsekwencji błędne działanie programu.

        EDIT :
        Kompilator rzuca wyjątkiem OutOfMemoryError.
        Tablica int'ów o rozmiarze 0x7FFFFFFF wymaga 8GB RAM'u, więc ten błąd działa tylko teoretycznie.
     */

    @Test
    public void sequenceReverse() {
        int key = 1000000000;
        int[] array = {Integer.MAX_VALUE, key, 0, -1000000000, Integer.MIN_VALUE};
        SearchResult result = BinarySearch.search(key, array);
        assertThat(result.isFound(), is(equalTo(false)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sequenceNull() {
        int key = 10;
        BinarySearch.search(key, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sequenceHasZeroLength() {
        int key = 10;
        int[] array = {};
        BinarySearch.search(key, array);
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

    @Test
    public void sequenceHasMoreThanOneLengthAndContainsItemAtFirstPos() {
        int searchKey = Integer.MIN_VALUE;
        int[] array = {searchKey, -1000000000, 0, 1000000000, Integer.MAX_VALUE};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(true)));
        assertThat(result.getPosition(), is(equalTo(0)));
    }

    @Test
    public void sequenceHasMoreThanOneLengthAndContainsItemAtLastPos() {
        int searchKey = Integer.MAX_VALUE;
        int[] array = {Integer.MIN_VALUE, -1000000000, 0, 1000000000, searchKey};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(true)));
        assertThat(result.getPosition(), is(equalTo(array.length - 1)));
    }

    @Test
    public void sequenceHasMoreThanOneLengthAndContainsItemAtMiddlePos() {
        int searchKey = 0;
        int[] array = {Integer.MIN_VALUE, -1000000000, searchKey, 1000000000, Integer.MAX_VALUE};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(true)));
        assertThat(result.getPosition(), is(equalTo(array.length / 2)));
    }

    @Test
    public void sequenceHasMoreThanOneLengthAndNotContainsItem() {
        int searchKey = 12345678;
        int[] array = {Integer.MIN_VALUE, -1000000000, 0, 1000000000, Integer.MAX_VALUE};
        SearchResult result = BinarySearch.search(searchKey, array);

        assertThat(array.length > 1, is(equalTo(true)));
        assertThat(result.isFound(), is(equalTo(false)));
    }
}
