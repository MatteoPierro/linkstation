import Point from "./point";

export default class LinkStation {
    constructor(point, reach) {
        this.point = point;
        this.reach = reach;
    }

    powerFor(anotherPoint) {
        const distance = anotherPoint.distanceFrom(this.point);
        if (distance > this.reach) {
            return 0;
        } else {
            return Number(
                Math.pow(this.reach - distance, 2).toFixed(2)
            );
        }
    }
}

export const linkStation = (x, y, reach) => new LinkStation(new Point(x, y), reach);