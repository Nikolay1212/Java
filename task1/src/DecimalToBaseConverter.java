public class DecimalToBaseConverter implements Converter {
    @Override
    public void convert(int value, int base) {
        int divide = value / base;
        int quotient = value % base;
        String result = "";
        if (quotient <= 9) {
            result += quotient;
        } else {
            char с = (char)(quotient + 39 + '0');
            result += с;
        }

        while (divide != 0) {
            quotient = divide % base;
            divide = divide / base;
            if (quotient <= 9) {
                result += quotient;
            } else {
                char с = (char)(quotient + 39 + '0');
                result += с;
            }
        }
        System.out.println(reverseString(result));
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }
        return result;
    }
}
