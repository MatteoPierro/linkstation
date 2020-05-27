package com.matteopierro.linkstation.domain;

import java.util.stream.Stream;

public interface LinkStationRepository {
    Stream<LinkStation> findAll();
}
