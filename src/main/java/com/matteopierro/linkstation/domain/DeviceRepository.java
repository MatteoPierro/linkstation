package com.matteopierro.linkstation.domain;

import com.matteopierro.linkstation.domain.model.Device;

import java.util.stream.Stream;

public interface DeviceRepository {
    Stream<Device> findAll();
}
