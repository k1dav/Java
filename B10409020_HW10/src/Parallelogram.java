/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class Parallelogram extends Trapezoid{
    
    public Parallelogram(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }
    
    public String toString() {
        return String.format("平行四邊形\n%s\n底: %s\n高: %s\n面積: %s\n",
                getCoordinatesAsString(), getBottom(), getHeight(), getArea());
    }
    
}
