package vn.edu.csc.math4computingapp;
import java.util.Arrays;

public class DecimalObject {
    int number;
    String[] groupsOf4;
    int[] groupsToDecimal;
    int[] mutiplier;

    //Constructor
    public DecimalObject(int number, String[] groupsOf4, int[] groupsToDecimal, int[] mutiplier) {
        this.number = number;
        this.groupsOf4 = groupsOf4;
        this.groupsToDecimal = groupsToDecimal;
        this.mutiplier = mutiplier;
    }

    //Binary to Decimal
    public static DecimalObject convertBinary(String binary){
        int result = Integer.parseInt(binary,2);
        int noOfElements = binary.length()/4 + (binary.length()%4 == 0 ? 0: 1);
        String[] chunkOf4 = new String[noOfElements];
        int[] chunkToDecimal = new int[noOfElements];
        int end = binary.length() - 4*(noOfElements-1);

        chunkOf4[0] = binary.substring(0, end);
        chunkToDecimal[0] = Integer.parseInt(chunkOf4[0],2);

        for (int i = 1; i < noOfElements; i++) {
            chunkOf4[i] = binary.substring(end, end+=4);
            chunkToDecimal[i] = Integer.parseInt(chunkOf4[i],2);
        }

        int[] chunkMutiplier = new int[noOfElements];
        for (int i = 0; i < noOfElements; i++) {
            chunkMutiplier[i] = (int) Math.pow(16,noOfElements-1-i);
        }

        return new DecimalObject(result,chunkOf4,chunkToDecimal,chunkMutiplier);
    }

    //toString
    @Override
    public String toString() {
        return "Groups of four: " + Arrays.toString(groupsOf4) + "\n\n"
                + "Group to decimal: " + Arrays.toString(groupsToDecimal) + "\n\n"
                + "Group multiplier: " + Arrays.toString(mutiplier) + "\n\n"
                + "Result: " + number;
    }
}
