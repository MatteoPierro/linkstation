package com.matteopierro.linkstation.domain;

import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.LinkStation;

public interface Display {
    void noLinkStationFor(Device device);

    void bestLinkStationFor(Device device, LinkStation station);
}
