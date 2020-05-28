package com.matteopierro.linkstation;

import com.matteopierro.linkstation.domain.DeviceService;
import com.matteopierro.linkstation.domain.LinkStationService;
import com.matteopierro.linkstation.infrastructure.InMemoryDeviceRepository;
import com.matteopierro.linkstation.infrastructure.InMemoryLinkStationRepository;

import static com.matteopierro.linkstation.infrastructure.PrintStreamDisplay.consoleDisplay;

public class App {

    public static void main(String[] args) {
        var deviceRepository = new InMemoryDeviceRepository();
        var linkStationRepository = new InMemoryLinkStationRepository();
        var display = consoleDisplay();
        var linkStationService = new LinkStationService(linkStationRepository, display);
        var deviceService = new DeviceService(deviceRepository, linkStationService);
        deviceService.findLinkStations();
    }
}