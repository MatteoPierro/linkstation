package com.matteopierro.linkstation.infrastructure;

import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PrintStreamDisplayTest {

    @Mock
    private PrintStream stream;

    @InjectMocks
    private PrintStreamDisplay display;

    @Test
    void display_no_link_station_for_device() {
        var device = new Device(new Point(4, 19));
        display.noLinkStationFor(device);

        verify(stream).println("No link station within reach for point 4,19");
    }
}