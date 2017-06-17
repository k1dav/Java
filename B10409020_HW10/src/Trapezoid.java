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

    // 取得矩形面積
    public double getArea() {
        return (getTop() + getBottom()) * getHeight() / 2;
    }

    // 取得 Rectangle 物件的 string 格式
    public String toString() {
        return String.format("梯形\n%s\n上底: %s\n下底: %s\n高: %s\n面積: %s\n",
                getCoordinatesAsString(), getTop(), getBottom(), getHeight(), getArea());
    }

}
