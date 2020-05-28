export default {
    noLinkStationFor: (point) => {
        console.log(`No link station within reach for point ${point.x},${point.y}`)
    },
    bestLinkStationFor: (point, station) => {
        console.log(
            `Best link station for point ${point.x},${point.y} is` + 
            ` ${station.point.x},${station.point.y} with power ${station.powerFor(point)}`
        );
    }
}