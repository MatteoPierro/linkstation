export default function (point, stations, display) {
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