package com.matteopierro.linkstation.domain;

public class LinkStationService {

    private final LinkStationRepository repository;
    private final Display display;

    public LinkStationService(LinkStationRepository repository, Display display) {
        this.repository = repository;
        this.display = display;
    }

    public void linkStationFor(Device device) {
        repository.findAll();
        display.noLinkStationFor(device);
    }
}
