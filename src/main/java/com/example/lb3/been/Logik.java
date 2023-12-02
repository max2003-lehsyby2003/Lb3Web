package com.example.lb3.been;

import jakarta.ejb.Stateless;

@Stateless
public class Logik {
    public double function(double x, double a, double b){
        double eps = 1e-7;

        if ((0.7<x) && (x<=1.4+eps))
            return a*x*x*Math.log(x);
        else
        if (x<=0.7+eps)
            return 1;
        else
            return Math.exp(x*a)*Math.cos(b*x);

    }

    public int point (double b, double d, double h){
        //Math.round
        return(int) ((d-b)/h+1);
    }

    public double[] masivX (double b, double d, double h ){
        double [] masivX= new double[point(b, d, h)];
        for (int i = 0; i < masivX.length; i++){
            masivX[i]= b+i*h;

        }

        return masivX;
    }
    public double[] masivY (double a, double b, double[] masivX){
        double[] masivY= new double[masivX.length];
        for (int i = 0; i < masivY.length; i++) {
            masivY[i]= function(masivX[i],a,b);
        }
        return masivY;
    }

    public int indexMinY(double[] y){
        int min = 0;
        for (int i = 0; i < y.length; i++)
            if (y[min] > y[i])
                min = i;
        return min;
    }
    public int indexMaxY(double[] y){
        int max = 0;
        for (int i = 0; i < y.length; i++)
            if (y[max] < y[i])
                max = i;
        return max;
    }
    public double sumY(double[] y){
        double sum = 0;
        for (int i = 0; i < y.length; i++)
            sum = sum + y[i];
        return sum;
    }

    public double seredArefmY(double[] y) {
        return  sumY(y)/y.length;
    }

    public void print(){
        double []x= masivX(0, 3, 0.004);
        double[] y = masivY(-0.5, 2, x);
        int imin = indexMinY(y);
        int imax = indexMaxY(y);
        System.out.println("min index y("+indexMinY(y)+")="+y[imin]);
        System.out.println("max index y("+indexMaxY(y)+")="+y[imax]);
    }
}
