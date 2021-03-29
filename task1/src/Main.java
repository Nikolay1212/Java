public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        BaseParser baseParser = new BaseParser();

        System.out.println("Input a decimal number: ");
        int nb = input.getNum();
        System.out.println("Input a calculation system: ");
        String calcSystem = input.getBase();

        int base = baseParser.parseBase(calcSystem);

        Converter converter = new DecimalToBaseConverter();

        converter.convert(nb, base);

    }
}
