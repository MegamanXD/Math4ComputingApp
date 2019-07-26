package vn.edu.csc.math4computingapp;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class RSAEncryptObject {
    int[] textToNumber;
    int[] encryptedMessage;
    int[] exponentBreakdown;

    ArrayList<int[]> conversion;

    //Constructor
    public RSAEncryptObject(int[] textToNumber, int[] encryptedMessage, int[] exponentBreakdown, ArrayList conversion) {
        this.textToNumber = textToNumber;
        this.encryptedMessage = encryptedMessage;
        this.exponentBreakdown = exponentBreakdown;
        this.conversion = conversion;
    }

    //Decrypt RSA
    public static RSAEncryptObject encryptRSA(String message, int n, int e){
        char[] letters = message.toLowerCase().toCharArray();
        int[] textToNumber = new int[message.length()];
        int[] encryptedMessage = new int[letters.length];
        ArrayList conversion = new ArrayList<>();
        int temporary;

        for (int i = 0; i < letters.length; i++) {
            //Convert letter to number (its alphabetical position)
            textToNumber[i] = (int) letters[i] - 96;

            //Calculate final mod
            temporary = BigInteger.valueOf(textToNumber[i])
                    .modPow(BigInteger.valueOf(e), BigInteger.valueOf(n))
                    .intValue();
            encryptedMessage[i] = temporary;
        }
        System.out.println(Arrays.toString(textToNumber));

        //Convert e to binary
        String binary = "";
        int ee = e;
        while(ee>0){
            binary = ee%2 + binary;
            ee /= 2;
        }

        //Breakdown exponents into sums of 2^n
        int[] exponentBreakdown = new int[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1')
                exponentBreakdown[i] = (int) Math.pow(2,binary.length()-1-i);
        }

        for (int i = 0; i < textToNumber.length; i++) {
            conversion.add(stepByStepMod(textToNumber[i], n, exponentBreakdown));
        }
        return new RSAEncryptObject(textToNumber,encryptedMessage,exponentBreakdown,conversion);
    }

    //Step-by-step mod
    public static int[] stepByStepMod(int textElement, int n, int[] exponentBreakdown){
        //Step-by-step mod results
        int length = exponentBreakdown.length;

        int exponent = 1;
        int remainder = textElement % n;
        int[] stepByStepMod = new int[length];
        stepByStepMod[0] = remainder;

        for (int i = 1; i < length; i++) {
            remainder = BigInteger.valueOf(textElement)
                    .modPow(BigInteger.valueOf(exponent *= 2), BigInteger.valueOf(n))
                    .intValue();;
            stepByStepMod[i] =  remainder;
        }
        return stepByStepMod;
    }

    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Alphabetical position: " + Arrays.toString(textToNumber) + "\n\n" +
                "e breakdown: " + Arrays.toString(exponentBreakdown) + "\n\n" +
                "Conversion:\n");

        for (int i = 0; i < conversion.size(); i++) {
            sb.append("Element " + (i+1) + ": " + Arrays.toString(conversion.get(i)) + "\n");
        }

        sb.append("\nEncrypted message: " + Arrays.toString(encryptedMessage) + "\n");

        return sb.toString();
    }
}
