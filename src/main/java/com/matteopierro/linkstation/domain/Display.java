package com.matteopierro.linkstation.domain;

public interface Display {
    void noLinkStationFor(Device device);

    void linkStationFor(Device device, LinkStation station);
}
