import point from '../src/point';

describe("distance between points", () => {
    it('returns distance zero for the same point', () => {
        expect(point(1,1).distanceFrom(point(1,1))).toBe(0);
    });
});

