export default class LinkedStation {
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