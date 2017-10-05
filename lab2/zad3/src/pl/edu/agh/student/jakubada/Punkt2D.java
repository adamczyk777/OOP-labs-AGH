package pl.edu.agh.student.jakubada;

public class Punkt2D {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Punkt2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //    Metoda zwraca odległość aktualnego puntku od innego punktu
    public double distance(Punkt2D other) {
        return Math.sqrt(Math.pow(this.getX() - other.getX(), 2) + Math.pow(this.getY() - other.getY(), 2));
    }
}
