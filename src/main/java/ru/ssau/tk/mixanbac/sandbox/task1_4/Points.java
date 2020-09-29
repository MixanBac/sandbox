package ru.ssau.tk.mixanbac.sandbox.task1_4;

import ru.ssau.tk.mixanbac.sandbox.tack1_3.Point;

public class Points {
    private Points() {

    }

    public static Point sum(Point obj1, Point obj2) {
        return new Point(obj1.getX()+obj2.getX(),obj1.getY()+obj2.getY(),obj1.getZ()+obj2.getZ());
    }

    public static Point subtract(Point obj1, Point obj2) {
        return new Point(obj1.getX()-obj2.getX(),obj1.getY()-obj2.getY(),obj1.getZ()-obj2.getZ());
    }

    public static Point multiply(Point obj1, Point obj2) {
        return new Point(obj1.getX()*obj2.getX(),obj1.getY()*obj2.getY(),obj1.getZ()*obj2.getZ());
    }

    public static Point divide(Point obj1, Point obj2) {
        return new Point(obj1.getX()/obj2.getX(),obj1.getY()/obj2.getY(),obj1.getZ()/obj2.getZ());
    }

    public static Point enlarge(Point obj,double a){
        return new Point(obj.getX()*a,obj.getY()*a,obj.getZ()*a);
    }

    public static double length(Point obj){
        return obj.length();
    }

}
