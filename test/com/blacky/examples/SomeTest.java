package com.blacky.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;


public class SomeTest {

    public static List<Artist> ARTISTS = addArtists();
    public static long NUMBER_LONDON_ARTISTS = 4;
    public static String FROM = "London";

    public static List<Artist> addArtists() {
        ARTISTS = new ArrayList<>();

        ARTISTS.add(new Artist("John Lennon", "London"));
        ARTISTS.add(new Artist("Paul McCartney", "London"));
        ARTISTS.add(new Artist("George Harrisonn", "London"));
        ARTISTS.add(new Artist("Ringo Starr", "London"));

        return ARTISTS;
    }


    @Test
    public void allArtistsFromEngland_viaFor() {
        long count = 0 ;

        for (Artist artist : ARTISTS) {
            if (artist.isFrom(FROM)) count++;
        }

        assertEquals(NUMBER_LONDON_ARTISTS, count);
    }

    @Test
    public void allArtistsFromEngland_viaForEach() {
        long count = 0 ;

        count = ARTISTS.stream()
                .filter(artist -> artist.isFrom(FROM))
                .count();

        assertEquals(NUMBER_LONDON_ARTISTS, count);
    }

    @Test
    public void collecting() {
        List<String> collected = Stream.of("a", "b", "c").collect(toList());

        assertEquals(asList("a", "b", "c"), collected);
    }

    @Test
    public void toUpperCase_viaFor() {
        List<String> collected = new ArrayList<>();

        for (String string : asList("a", "b", "hello")) {
            collected.add(string.toUpperCase());
        }

        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void toUpperCase_viaForEach() {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(String::toUpperCase)
                .collect(toList());

        assertEquals(asList("A", "B", "HELLO"), collected);
    }
}