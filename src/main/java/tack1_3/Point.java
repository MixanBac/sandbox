package tack1_3;
public final class Point {
    private double x = 0, y = 0, z = 0;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

}

class Task1_3 {
    public static void main(String[] args) {
        Point onePoint = new Point(6, 17, 13);
        Point secondPoint = new Point(76, 0, 90);
        Point thirdPoint = new Point(64, -49, 3);

        System.out.println(onePoint);
        System.out.println(secondPoint);
        System.out.println(thirdPoint);
    }
}
