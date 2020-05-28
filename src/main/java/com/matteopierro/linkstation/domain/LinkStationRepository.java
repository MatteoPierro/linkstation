package com.matteopierro.linkstation.domain;

import com.matteopierro.linkstation.domain.model.LinkStation;

import java.util.stream.Stream;

public interface LinkStationRepository {
    Stream<LinkStation> findAll();
}
