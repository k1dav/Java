public class Rectangle extends Parallelogram {

    // �غc�l (x1, y1, x2, y2, x3, y3, x4, y4)
    public Rectangle(double x1, double y1, double x2, double y2, 
            double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4); // �ϥ� Quadrilateral �غc�l
    }

    // ���o�x�μe
    public double getWidth() {
        if (getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint1().getX() - getPoint2().getX());
        else
            return Math.abs(getPoint2().getX() - getPoint3().getX());
    }

    // ���o�x�έ��n
    public double getArea() {
        return getWidth() * getHeight();
    }

    // ���o Rectangle ���� string �榡
    public String toString() {
        return String.format("�x��\n%s\n�e: %s\n��: %s\n���n: %s\n",
                getCoordinatesAsString(), getWidth(), getHeight(), getArea());
    }

}
     