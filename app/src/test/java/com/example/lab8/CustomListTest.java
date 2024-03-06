package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    /**
     * Create mock list for my citylist
     */
    private CustomList list;

    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void getCountTest() {
        list = MockCityList();
        assertEquals(0, list.getCount());
        City city = new City("Regina", "SK");
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.deleteCity(city);
        assertEquals(0, list.getCount());
    }

    /**
     * Get size of list
     * Increase list by adding new city
     * Check if current size matches initial size plus 1
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    /**
     * Check if blank list has city
     * Add city
     * Check that list has city now
     */
    @Test
    public void hasCity() {
        list = MockCityList();
        City city = new City("Toronto", "ON");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * Add city to list and check size is 1
     * Delete city and check size is 0
     */
    @Test
    public void deleteCity() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.deleteCity(city);
        assertEquals(0, list.getCount());
    }
}
