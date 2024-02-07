package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private static final String IP_RUSSIA = "172.420.69.77";
    private static final String IP_USA = "96.96.024.999";

    private final GeoServiceImpl geoService = new GeoServiceImpl();
    private Location expected;
    private Location actual;

    @Test
    void russianIP() {
        expected = new Location("Moscow", Country.RUSSIA, null, 0);

        actual = geoService.byIp(IP_RUSSIA);
        assertSame(expected.getCountry(), actual.getCountry());
    }

    @Test
    void usIP() {
        expected = new Location("New York", Country.USA, null, 0);

        actual = geoService.byIp(IP_USA);
        assertSame(expected.getCountry(), actual.getCountry());
    }
}