package tp1;

public class Exo5 {
    public static String toRoman(int n) {
        if (n < 1 || n > 3999) {
            throw new IllegalArgumentException("n must be between 1 and 3999");
        }
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
                1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= symbols.length; i++) {
            while (n > values[i]) {
                sb.append(symbols[i]);
                n -= values[i];
            }
        }
        return sb.toString();
    }
}
