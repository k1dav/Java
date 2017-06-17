
public class Point {

    private double x; // x �y��
    private double y; // y �y��

    // �غc�l (x, y)
    public Point(double x, double y) {
        this.x = x; // set x
        this.y = y; // set y
    }

    // ���o x �y��
    public double getX() {
        return x;
    }

    // ���o y �y��
    public double getY() {
        return y;
    }

    // ���o Point �� string �榡
    public String toString() {
        return String.format("(%.1f, %.1f)", getX(), getY());
    }
}
