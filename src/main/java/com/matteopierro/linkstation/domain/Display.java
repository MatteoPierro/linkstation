package com.matteopierro.linkstation.domain;

import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.LinkStation;

public interface Display {
    void noLinkStationFor(Device device);

    void linkStationFor(Device device, LinkStation station);
}
