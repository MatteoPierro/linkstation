package com.matteopierro.linkstation.infrastructure;

import com.matteopierro.linkstation.domain.DeviceRepository;
import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.Point;

import java.util.stream.Stream;

public class InMemoryDeviceRepository implements DeviceRepository {
    @Override
    public Stream<Device> findAll() {
        return Stream.of(
                device(0,0),
                device(100, 100),
                device(15,10),
                device(18, 18)
        );
    }

    private Device device(int x, int y) {
        var point = new Point(x, y);
        return new Device(point);
    }
}
