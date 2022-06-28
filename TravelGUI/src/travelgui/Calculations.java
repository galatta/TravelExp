package travelgui;

public class Calculations {
    public double getResult(double mtod, double mpg, double gp, double p, double t )
    {
       return ((mtod/mpg)*gp)+p+t;
    }
}