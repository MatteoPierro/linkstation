package com.matteopierro.linkstation.infrastructure;

import com.matteopierro.linkstation.domain.LinkStationRepository;
import com.matteopierro.linkstation.domain.model.LinkStation;
import com.matteopierro.linkstation.domain.model.Point;
import com.matteopierro.linkstation.domain.model.Reach;

import java.util.stream.Stream;

public class InMemoryLinkStationRepository implements LinkStationRepository {

    @Override
    public Stream<LinkStation> findAll() {
        return Stream.of(
                station(0, 0, 10),
                station(20, 20, 5),
                station(10, 0, 12)
        );
    }

    private LinkStation station(int x, int y, double reach) {
        Point point = new Point(x, y);
        return new LinkStation(point, new Reach(reach));
    }
}
