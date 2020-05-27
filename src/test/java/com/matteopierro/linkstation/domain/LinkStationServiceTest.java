package com.matteopierro.linkstation.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LinkStationServiceTest {

    @Mock
    private LinkStationRepository repository;
    @Mock
    private Display display;

    @InjectMocks
    private LinkStationService service;

    @Test
    void display_no_link_station_when_only_one_station_is_available_and_the_power_is_zero() {
        var station = new LinkStation(new Point(0, 0), new Reach(1));
        when(repository.findAll()).thenReturn(
                Stream.of(station)
        );

        var device = new Device(new Point(0, -1));
        service.linkStationFor(device);

        verify(display).noLinkStationFor(device);
    }
}
