/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class Trapezoid extends Quadrilateral {

    public Trapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public double getTop() {
        if (getPoint1().getY() == getPoint2().getY()) {
            return Math.abs(getPoint1().getX() - getPoint2().getX());
        } else if (getPoint1().getY() == getPoint3().getY()) {
            return Math.abs(getPoint1().getX() - getPoint3().getX());
        } else {
            return Math.abs(getPoint1().getX() - getPoint4().getX());
        }
    }

    public double getBottom() {
        if (getPoint2().getY() == getPoint3().getY()) {
            return Math.abs(getPoint2().getX() - getPoint3().getX());
        } else if (getPoint2().getY() == getPoint4().getY()) {
            return Math.abs(getPoint2().getX() - getPoint4().getX());
        } else {
            return Math.abs(getPoint3().getX() - getPoint4().getX());
        }
    }

    public double getHeight() {
        if (getPoint1().getX() == getPoint3().getX()) {
            return Math.abs(getPoint2().getY() - getPoint3().getY());
        } else {
            return Math.abs(getPoint1().getY() - getPoint3().getY());
        }
    }

    // ���o�x�έ��n
    public double getArea() {
        return (getTop() + getBottom()) * getHeight() / 2;
    }

    // ���o Rectangle ���� string �榡
    public String toString() {
        return String.format("���\n%s\n�W��: %s\n�U��: %s\n��: %s\n���n: %s\n",
                getCoordinatesAsString(), getTop(), getBottom(), getHeight(), getArea());
    }

}
