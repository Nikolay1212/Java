import java.util.Arrays;

public class BaseParser {

    private String input;

    public int parseBase(String input) {
        //0 - 1 : 48 - 57
        //a - z : 97 - 122
        char[] baseArray = input.toLowerCase().toCharArray();
        int[] inspectionArray = new int[baseArray.length];
        for (int i = 0; i < baseArray.length; i++) {
            if (i < 10) {
                int c = baseArray[i] - (47 + i);
                inspectionArray[i] = c;
            } else {
                int c = 'z' - (baseArray[i] - 'a') + i - 131;
                inspectionArray[i] = c;
            }
        }
        if(Arrays.stream(inspectionArray).sum() == baseArray.length) {
            return baseArray.length;
        } else {
            System.err.println("usage");
            System.exit(-1);
            return -1;
        }

    }
}
