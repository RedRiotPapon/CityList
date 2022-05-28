package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * testDelete() checks if deletion of a city is done perfectly or not
     */
    @Test
    public void testDelete() {
        CityList cityList =new CityList();
        City city1 = new City("Magura", "Khulna");
        cityList.add(city1);
        City city2= new City("Faridpur", "Dhaka");
        cityList.add(city2);
        cityList.delete(city1);
        assertTrue(!cityList.getCities(1).contains(city1));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * testDeleteException() throws exception when we try to delete an already deleted city
     */
    @Test
    public void testDeleteException() {
        CityList cityList =new CityList();
        City city1 = new City("Magura", "Khulna");
        cityList.add(city1);
        City city2= new City("Faridpur", "Dhaka");
        cityList.add(city2);
        assertEquals(2,cityList.count());
        cityList.delete(city1);
        assertEquals(1,cityList.count());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    /**
     * testGetCitiesSort() checks if the sorting techniques are working or not
     */
    @Test
    public void testGetCitiesSort() {
        CityList cityList = new CityList();
        City city1 = new City("Magura", "Khulna");
        cityList.add(city1);
        City city2= new City("Faridpur", "Dhaka");
        cityList.add(city2);
        assertEquals(0, city2.compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(2)));

    }
}
