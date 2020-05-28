import Point from '../src/point';
import LinkStation from '../src/link-station';

describe('Link Station power', () => {
    it('returns reach squared as power when the station and device are at the same point', () => {
        const stationPoint = new Point(0, 0);
        const reach = 10;
        const station = new LinkStation(stationPoint, reach);

        const power = station.powerFor(new Point(0, 0));

        expect(power).toBe(100);
    });

    it('calculates the power as the difference of reach and distance squared', () => {
        const stationPoint = new Point(0, 0);
        const reach = 10;
        const station = new LinkStation(stationPoint, reach);

        const power = station.powerFor(new Point(1, 1));

        expect(power).toBe(73.79);
    });

    it('returns power zero when distance is larger than reach', () => {
        const stationPoint = new Point(0, 0);
        const reach = 10;
        const station = new LinkStation(stationPoint, reach);

        const power = station.powerFor(new Point(15, 0));

        expect(power).toBe(0);
    });
});