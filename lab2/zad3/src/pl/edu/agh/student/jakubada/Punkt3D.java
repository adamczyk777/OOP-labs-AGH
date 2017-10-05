package pl.edu.agh.student.jakubada;

public class Punkt3D extends Punkt2D {
    private double z;

    public Punkt3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Punkt3D other) {
        return Math.sqrt(Math.pow(super.distance(other), 2) + Math.pow(this.getZ() - other.getZ(), 2));
    }

    @Override
    public String toString() {
        return "X: " + super.getX() + "Y: " + super.getY() + "Z: " + this.getZ();
    }
}
