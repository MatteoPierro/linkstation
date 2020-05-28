import bestStationService from './link-station-service';

export default function(points, stations, display) {
    points.forEach( 
        (point) => bestStationService(point, stations, display)
    );
}