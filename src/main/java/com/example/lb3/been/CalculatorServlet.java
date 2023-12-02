package com.example.lb3.been;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.annotation.WebServlet;
import lombok.Data;


import java.io.Serializable;



@WebServlet(name = "calculatorServlet", value = "/calculator")
@Named
@SessionScoped
@Data
public class CalculatorServlet implements Serializable {

    private double start;
    private double end;
    private double step;
    private double a;
    private double b;


    private int  indexMinY;
    private int indexMaxY;
    private double sumY;
    private double seredArefmY;
    private double[] masivX;
    private double[] masivY;
    private double min;
    private double max;
    private double sum;

    @EJB
    private Logik logik;

    public String calculate() {

        masivX = logik.masivX(start, end, step);
         masivY = logik.masivY(a, b, masivX);
         indexMinY = logik.indexMinY(masivY);
         min = masivY[indexMinY];
         indexMaxY = logik.indexMaxY(masivY);
         max = masivY[indexMaxY];
         sum = logik.sumY(masivY);
         seredArefmY = logik.seredArefmY(masivY);




        return "result";
    }
}