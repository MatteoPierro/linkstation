export function findBestStations(points, stations, display) {
    points.forEach( 
        (point) => pointBestStation(point, stations, display)
    );
}

export default function pointBestStation(point, stations, display) {
    const bestStation = stationWithMaximumPower(stations, point);
    if (bestStation) {
        display.bestLinkStationFor(point, bestStation);
    } else {
        display.noLinkStationFor(point);
    }
}

function stationWithMaximumPower(stations, point) {
    let bestStation = undefined;
    let power = 0;

    stations.forEach((station) => {
        if (station.powerFor(point) > power) {
            bestStation = station;
            power = station.powerFor(point);
        }
    });

    return bestStation;
}