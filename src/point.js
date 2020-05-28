class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    distanceFrom(anotherPoint) {
        return Number(
            Math.sqrt(
                Math.pow(this.x - anotherPoint.x, 2) +
                Math.pow(this.y - anotherPoint.y, 2)
            ).toFixed(2)
        );
    }
}

export function point(x, y) {
    return new Point(x, y);
}

export default Point;