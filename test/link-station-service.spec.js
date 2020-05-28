import Point from '../src/point';
import LinkStation from '../src/link-station';
import findBestStationFor from '../src/link-station-service';

describe('find best station for a point', () => {
    let display;

    beforeEach(() => {
        display = { 
            noLinkStationFor: jest.fn(),
            bestLinkStationFor: jest.fn()
        };
    });

    it('displays no link station for a point when only one station is available and the power is zero', () => {
        const zeroPowerStation = new LinkStation(new Point(0, 0), 10);
        const stations = [zeroPowerStation];
    
        const point = new Point(15, 0);
        findBestStationFor(point, stations, display);
    
        expect(display.noLinkStationFor).toHaveBeenCalledWith(point);
    });

    it('displays as best link station the one with the largest power', () => {
        const maximumPowerStation = new LinkStation(new Point(0, 2), 8);
        const minimumPowerStation = new LinkStation(new Point(0, 1), 4);
        const zeroPowerStation = new LinkStation(new Point(0, 0), 1);
        const stations = [maximumPowerStation, minimumPowerStation, zeroPowerStation];
    
        const point = new Point(0, -1);
        findBestStationFor(point, stations, display);
    
        expect(display.bestLinkStationFor).toHaveBeenCalledWith(point, maximumPowerStation);
    });
});
