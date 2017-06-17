public class Quadrilateral {
    private Point point1; // first endpoint
    private Point point2; // second endpoint
    private Point point3; // third endpoint
    private Point point4; // fourth endpoint

    // �غc�l (x1, y1, x2, y2, x3, y3, x4, y4)
    public Quadrilateral(double x1, double y1, double x2, double y2, 
            double x3, double y3, double x4, double y4) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        point4 = new Point(x4, y4);
    }

    // ���o point1
    public Point getPoint1() {
        return point1;
    }

    // ���o point2
    public Point getPoint2() {
        return point2;
    }

    // ���o point3
    public Point getPoint3() {
        return point3;
    }

    // ���o point4
    public Point getPoint4() {
        return point4;
    }

    // ���o Quadrilateral ���� string �榡�A��ܥ|��Ϊ��|�I�y��
    public String toString() {
        return String.format("Coordinates of Quadrilateral are:\n%s", getCoordinatesAsString());
    }

    // ���o�|��Ϊ��|�I�y��
    public String getCoordinatesAsString() {
        return String.format("%s, %s, %s, %s", point1, point2, point3, point4);
    }

}
