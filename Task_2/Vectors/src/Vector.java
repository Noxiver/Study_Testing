import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Vector2d {
    private  double x,y;

    public  Vector2d(double x, double y ) {
        this.x = x ;
        this.y = y ;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public  Vector2d add(Vector2d a) {
        return new Vector2d(this.getX() + a.getX(),
                            this.getY() + a.getY());
    }
    public Vector2d subtract(Vector2d a) {
        return new Vector2d( this.getX() - a.getX(),
                this.getY() - a.getY());
    }

    public double scalarMultiply(Vector2d a) {
        return this.getX() * a.getX() + this.getY()  * a.getY();
    }

    public Vector2d vectorMultiply(Vector2d a) {
        double newX , newY, newZ;
        newX = this.getY() * a.getX() - this.getX() * a.getY();
        newZ = this.getX() * a.getY() - this.getY() * a.getX();
        return new Vector2d(newX,newZ);
    }

    public void print(){
        System.out.println("(" + this.getX() + ", " + this.getY() + ")");
    }
}


class Vector3d {
    private  double x,y,z;

    public  Vector3d(double x, double y , double z) {
        this.x = x ;
        this.y = y ;
        this.z = z ;
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

    public  Vector3d add(Vector3d c) {
        return new Vector3d(this.getX() + c.getX(),
                this.getY() + c.getY(),
                this.getZ() + c.getZ());
    }
    public Vector3d subtract(Vector3d c) {
        return new Vector3d( this.getX() - c.getX(),
                this.getY() - c.getY(),
                this.getZ() - c.getZ());
    }

    public double scalarMultiply(Vector3d c) {
        return this.getX() * c.getX() + this.getY()  * c.getY() + this.getZ() * c.getZ();
    }

    public Vector3d vectorMultiply(Vector3d c) {
        double newX , newY, newZ;
        newX = this.getY() * c.getZ() - this.getZ() * c.getY();
        newY = this.getZ() * c.getX() - this.getX() * c.getZ();
        newZ = this.getX() * c.getY() - this.getY() * c.getX();
        return new Vector3d(newX, newY ,newZ);
    }

    public void print(){
        System.out.println("( " + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
}