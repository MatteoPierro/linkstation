export default class LinkedStation {
    constructor(point, reach) {
        this.point = point;
        this.reach = reach;
    }

    powerFor(anotherPoint) {
        return 100;
    }
}