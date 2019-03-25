package cs.csmath.complexnumber.exceptions;

public class ComplexZeroDivisionException extends RuntimeException {
    public ComplexZeroDivisionException(){
        super("division by 0");
    };
}
