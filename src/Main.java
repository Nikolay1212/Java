import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String[] subString = second.split("\\*");

        if (
                asteriskParse(first, second, subString) &&
                        directElementParse(first, second, subString) &&
                        reverseElementParse(first, second, subString)) {
            System.out.println("OK");

        } else {
            System.out.println("KO");
        }
    }
    public static boolean directElementParse(String rememberFirst, String second, String[] subString) {
        if (second.lastIndexOf("*") != second.length() - 1) {
            return subString[subString.length - 1].
                    equals(rememberFirst.substring(
                            rememberFirst.length() - subString[subString.length - 1].length()));
        } else if (subString.length > 0) {
            return rememberFirst.contains(subString[subString.length - 1]);
        } else return true;
    }
    public static boolean asteriskParse(String first, String second, String[] array) {
        if (array.length == 0) {
            return true;
        }
        String[] subString = removeNullStrings(array);
        int counter = 1;
        if (second.indexOf("*") == 0){
            second = second.substring(1);
        }
        int asteriskIndex = second.indexOf("*");
        for (int i = 0; i < subString.length - 1; i++) {
            String c = subString[i];
            if (!first.contains(subString[i])) {
                return false;
            } else {
                first = first.replaceFirst(c, "");
                second = second.substring(asteriskIndex + 1);
                asteriskIndex = second.indexOf("*");
                counter++;
            }
        }
        return counter == subString.length;
    }
    public static boolean reverseElementParse(String rememberFirst, String second, String[] work) {

        String[] subString = removeNullStrings(work);
        String[] newSub = new String[subString.length];
        int k = 0;
        for (int i = subString.length - 1; i >= 0; i--) {
            String reverseElement = "";
            char[] temp = subString[i].toCharArray();
            for (int j = temp.length - 1; j >=0 ; j--) {
                reverseElement += temp[j];
            }
            newSub[k] = reverseElement;
            k++;
        }
        char[] array = rememberFirst.toCharArray();
        String result = "";
        for (int i = rememberFirst.length() - 1; i >= 0; i--) {
            result += array[i];
        }
        if (second.indexOf("*") != 0) {
            return newSub[newSub.length - 1].
                    equals(result.substring(
                            result.length() - newSub[newSub.length - 1].length()));

        } else if (newSub.length > 0) {
            return result.contains(newSub[newSub.length - 1]);
        } else return true;
    }

    private static String[] removeNullStrings(String[] work) {
        int s = 0;
        for (String value : work) {
            if (value.equals("")) {
                s++;
            }
        }
        String[] subString = new String[work.length - s];
        int o = 0;
        for (String value : work) {
            if (!value.equals("")) {
                subString[o] = value;
                o++;
            }
        }
        return subString;
    }
}
