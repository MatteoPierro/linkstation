package com.matteopierro.linkstation.domain;

public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final LinkStationService linkStationService;

    public DeviceService(DeviceRepository deviceRepository, LinkStationService linkStationService) {
        this.deviceRepository = deviceRepository;
        this.linkStationService = linkStationService;
    }

    public void findLinkStations() {
        deviceRepository.findAll().forEach(linkStationService::bestLinkStationFor);
    }
}
