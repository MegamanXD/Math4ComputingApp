package vn.edu.csc.math4computingapp;
import java.util.ArrayList;

public class BinaryObject {
    private String number;
    private ArrayList divisionLine;
    private ArrayList conversionLine;

    //Constructor
    public BinaryObject(String number, ArrayList upperLine, ArrayList lowerLine) {
        this.number = number;
        this.divisionLine = upperLine;
        this.conversionLine = lowerLine;
    }

    //Decimal to Binary
    public static BinaryObject convertDecimal(int decimal){
        String result = "";
        ArrayList divisionLine = new ArrayList<>();
        ArrayList conversionLine = new ArrayList<>();
        int remainder;

        while (decimal > 0) {
            divisionLine.add(0,decimal);

            remainder = decimal % 2;
            result = remainder + result;
            conversionLine.add(0, remainder);

            decimal /= 2;
        }

        return new BinaryObject(result,divisionLine,conversionLine);
    }

    //toString
    @Override
    public String toString() {
        return "Division: " + divisionLine + "\n\n"
                + "Conversion: " + conversionLine + "\n\n"
                + "Result: " + number;
    }
}