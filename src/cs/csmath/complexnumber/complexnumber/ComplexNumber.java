package cs.csmath.complexnumber.complexnumber;

import cs.csmath.complexnumber.exceptions.ComplexZeroDivisionException;

public class ComplexNumber {
    private double imagPart = 0;
    private double realPart = 0;

    public ComplexNumber(double realP, double imagP){
        this.realPart = realP;
        this.imagPart = imagP;

    }
    public ComplexNumber(){
        this.realPart = 0;
        this.imagPart = 0;

    }
    public void add(ComplexNumber otherCN){
        this.realPart = this.realPart + otherCN.realPart;
        this.imagPart = this.imagPart + otherCN.imagPart;

    }
    public void subtract(ComplexNumber otherCN){
        this.realPart = this.realPart - otherCN.realPart;
        this.imagPart = this.imagPart - otherCN.imagPart;
    }
    public void mult(ComplexNumber otherCN){
        this.realPart = this.realPart*otherCN.realPart - this.imagPart*otherCN.imagPart;
        this.imagPart = this.imagPart*otherCN.realPart - this.realPart*otherCN.imagPart;

    }
    public void div(ComplexNumber otherCN){
        double tempRealPart = this.realPart;
        double dividend = otherCN.realPart*otherCN.realPart + otherCN.imagPart*otherCN.imagPart;
        // if dividend = 0
        if(dividend == 0){
            throw new ComplexZeroDivisionException();
        }
        this.realPart = (this.realPart*otherCN.realPart + this.imagPart*otherCN.imagPart)/ dividend;
        this.imagPart = (this.imagPart*otherCN.realPart - tempRealPart*otherCN.imagPart)/dividend;
        // if dividend = 0
        if(dividend == 0){
            throw new ComplexZeroDivisionException();
        }
    }
    public ComplexNumber conj(){
        return new ComplexNumber(this.getRealPart(), this.getImagePart()*-1);

    }
    public double abs(){
        return Math.sqrt(this.realPart*this.realPart + this.imagPart*this.imagPart);
    }
    public double getRealPart(){
        return this.realPart;

    }
    public void setRealPart(double realP){
        this.realPart = realP;
    }
    public double getImagePart(){
        return this.imagPart;

    }
    public void setImagPart(double imagP){
        this.imagPart = imagP;
    }
    public String toString(){
        return this.realPart + " + " + this.imagPart + "i";
    }

    public static ComplexNumber add(ComplexNumber firstCN, ComplexNumber secondCN){

        return new ComplexNumber(firstCN.getRealPart() + secondCN.getRealPart(), firstCN.getImagePart() + secondCN.getImagePart());

    }
    public static ComplexNumber sub(ComplexNumber firstCN, ComplexNumber secondCN){
        return new ComplexNumber(firstCN.getRealPart() - secondCN.getRealPart(), firstCN.getImagePart() - secondCN.getImagePart());

    }
    public static ComplexNumber mult(ComplexNumber firstCN, ComplexNumber secondCN){
        firstCN.mult(secondCN);
        return firstCN;


    }
    public static ComplexNumber div(ComplexNumber firstCN, ComplexNumber secondCN){
        firstCN.div(secondCN);
        return firstCN;

    }

    public static void main (String [] args ){
        ComplexNumber c1 = new ComplexNumber(1, 3.0);
        ComplexNumber c2 = new ComplexNumber(2, 1.5);

        System.out.println("Testing the add method");
        System.out.print(add(c1,c2));



    }
}
