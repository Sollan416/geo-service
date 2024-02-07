package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {

    private static final String IP_RUSSIA = "172.420.69.77";
    private static final String IP_USA = "96.96.024.999";
    private final Map<String, String> headers = new HashMap<>();

    @Mock
    GeoService geoService;
    @Mock
    LocalizationService localizationService;

    @InjectMocks
    MessageSenderImpl messageSender;

    @Test
    void sendRussianIp() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, IP_RUSSIA);

        Mockito.when(geoService.byIp(IP_RUSSIA)).thenReturn(
                new Location(null, Country.RUSSIA, null, 0));

        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        String actual = messageSender.send(headers);
        String expected = "Добро пожаловать";

        assertEquals(expected, actual);
    }

    @Test
    void sendAmericanIp() {
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, IP_USA);

        Mockito.when(geoService.byIp(IP_USA)).thenReturn(
                new Location(null, Country.USA, null, 0));

        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        String actual = messageSender.send(headers);
        String expected = "Welcome";

        assertEquals(expected, actual);
    }
}