class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    distanceFrom(anotherPoint) {
        return Math.abs(this.x - anotherPoint.x);
    }
}

export default Point;