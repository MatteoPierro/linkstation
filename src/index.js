import { point } from './point';
import { linkStation } from './link-station';
import display from './display';
import { findBestStations } from './best-link-station';

const points = [
    point(0, 0),
    point(100, 100),
    point(15, 10),
    point(18, 18)
];

const stations = [
    linkStation(0, 0, 10),
    linkStation(20, 20, 5),
    linkStation(10, 0, 12)
];

findBestStations(points, stations, display);