import Point from '../src/point';

describe("distance between points", () => {
    it('returns distance zero for the same point', () => {
        expect(new Point(1,1).distanceFrom(new Point(1,1))).toBe(0);
    });

    it('returns 1 as distance between the origin and the point (1,0)', () => {
        expect(new Point(0,0).distanceFrom(new Point(1,0))).toBe(1);
    });

    it('returns 1.41 as distance between the origin and the point (1,1)', () => {
        expect(new Point(0,0).distanceFrom(new Point(1,1))).toBe(1.41);
    });
});

