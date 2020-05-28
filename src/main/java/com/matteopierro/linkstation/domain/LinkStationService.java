package com.matteopierro.linkstation.domain;

import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.LinkStation;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LinkStationService {

    private final LinkStationRepository repository;
    private final Display display;

    public LinkStationService(LinkStationRepository repository, Display display) {
        this.repository = repository;
        this.display = display;
    }

    public void bestLinkStationFor(Device device) {
        linkStations()
                .max(byPowerFor(device))
                .filter(byCharging(device))
                .ifPresentOrElse(
                        displayBestLinkStationFor(device),
                        orDisplayNoLinkStationFor(device)
                );
    }

    private Stream<LinkStation> linkStations() {
        return repository.findAll();
    }

    private Comparator<LinkStation> byPowerFor(Device device) {
        return Comparator.comparing(linkStation -> linkStation.powerFor(device));
    }

    private Predicate<LinkStation> byCharging(Device device) {
        return linkStation -> linkStation.powerFor(device).isNotZero();
    }

    private Consumer<LinkStation> displayBestLinkStationFor(Device device) {
        return (station) -> display.bestLinkStationFor(device, station);
    }

    private Runnable orDisplayNoLinkStationFor(Device device) {
        return () -> display.noLinkStationFor(device);
    }
}
