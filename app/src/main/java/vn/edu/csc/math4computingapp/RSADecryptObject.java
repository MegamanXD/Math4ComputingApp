package vn.edu.csc.math4computingapp;
import java.math.BigInteger;
import java.util.Arrays;

public class RSADecryptObject {
    int finalmod;
    int[] exponentBreakdown;
    int[] stepByStepMod;
    char decryptedLetter;

    //Constructor
    public RSADecryptObject(int finalmod, int[] exponentBreakdown, int[] stepByStepMod, char result) {
        this.finalmod = finalmod;
        this.exponentBreakdown = exponentBreakdown;
        this.stepByStepMod = stepByStepMod;
        this.decryptedLetter = result;
    }

    //Decrypt RSA
    public static RSADecryptObject decryptRSA(int textElement, int n, int d){
        //Convert d to binary
        String binary = "";
        int dd = d;
        while(dd>0){
            binary = dd%2 + binary;
            dd /= 2;
        }

        //Breakdown exponents into sums of 2^n
        int[] exponentBreakdown = new int[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1')
                exponentBreakdown[i] = (int) Math.pow(2,binary.length()-1-i);
        }

        //Step-by-step mod results
        int length = exponentBreakdown.length;

        int exponent = 1;
        int remainder = textElement % n;
        int[] stepByStepMod = new int[length];
        stepByStepMod[length-1] =  remainder;

        for (int i = 1; i < length; i++) {
            remainder = BigInteger.valueOf(textElement)
                    .modPow(BigInteger.valueOf(exponent *= 2), BigInteger.valueOf(n))
                    .intValue();
            stepByStepMod[length-i-1] =  remainder;
        }

        //Calculate final mod
        int finalMod = BigInteger.valueOf(textElement)
                .modPow(BigInteger.valueOf(d), BigInteger.valueOf(n))
                .intValue();

        //Find the decrypted letter using the final mod
        char decryptedLetter = (char)(finalMod + 96);

        return new RSADecryptObject(finalMod, exponentBreakdown, stepByStepMod, decryptedLetter);
    }

    //toString
    @Override
    public String toString() {
        return "d breakdown: " + Arrays.toString(exponentBreakdown) + "\n\n"
                + "text^(d breakdown) mod n: " + Arrays.toString(stepByStepMod) + "\n\n"
                + "text^d mod n: " + finalmod + "\n\n"
                + "Letter: " + decryptedLetter;
    }
}
