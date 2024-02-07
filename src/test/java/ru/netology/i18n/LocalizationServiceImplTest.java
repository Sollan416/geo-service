package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;


class LocalizationServiceImplTest {
    private final LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
    private String expected;

    @Test
    void localeRussia() {
        expected = "Добро пожаловать";

        String actual = localizationService.locale(Country.RUSSIA);
        assertEquals(expected, actual);
    }

    @Test
    void localeNotRussia() {
        expected = "Welcome";
        Country[] countries = Country.values();

        for (Country country : countries) {
            if (country != Country.RUSSIA) {
                assertEquals(expected, localizationService.locale(country));
            }
        }
    }
}