package com.matteopierro.linkstation.domain;

import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {

    @Mock
    private DeviceRepository deviceRepository;
    @Mock
    private LinkStationService linkStationService;

    @InjectMocks
    private DeviceService deviceService;

    @Test
    void find_link_station_for_each_device() {
        Device firstDevice = new Device(new Point(4, 5));
        Device secondDevice = new Device(new Point(88, 56));
        when(deviceRepository.findAll()).thenReturn(
                Stream.of(firstDevice, secondDevice)
        );

        deviceService.findLinkStations();

        verify(linkStationService).linkStationFor(firstDevice);
        verify(linkStationService).linkStationFor(secondDevice);
    }
}