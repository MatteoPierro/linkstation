package com.matteopierro.linkstation.domain;

import java.util.Comparator;
import java.util.function.Predicate;

public class LinkStationService {

    private final LinkStationRepository repository;
    private final Display display;

    public LinkStationService(LinkStationRepository repository, Display display) {
        this.repository = repository;
        this.display = display;
    }

    public void linkStationFor(Device device) {
        repository.findAll()
                .max(byPowerFor(device))
                .filter(byCharging(device))
                .ifPresentOrElse(
                        (station) -> {
                            throw new RuntimeException("Not Implemented yet");
                        },
                        () -> display.noLinkStationFor(device)
                );
    }

    private Comparator<LinkStation> byPowerFor(Device device) {
        return Comparator.comparing(linkStation -> linkStation.powerFor(device));
    }

    private Predicate<LinkStation> byCharging(Device device) {
        return linkStation -> linkStation.powerFor(device).isNotZero();
    }
}
