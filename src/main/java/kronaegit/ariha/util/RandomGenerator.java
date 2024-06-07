package kronaegit.ariha.util;

import java.util.Random;

public class RandomGenerator {
    private final String ucs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char[] uca = ucs.toCharArray();
    private final char[] lca = ucs.toLowerCase().toCharArray();
    private final Random r;

    public RandomGenerator(long seed) {
        r = new Random(seed);
    }
    public RandomGenerator() {
        r = new Random(System.currentTimeMillis());
    }

    public char getRandomUppercaseChar() {
        return uca[r.nextInt(uca.length)];
    }

    public char getRandomLowercaseChar() {
        return lca[r.nextInt(lca.length)];
    }

    public int getRandomIntegerBetween(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        return r.nextInt(max - min + 1) + min;
    }

    public String getRandomString(int l) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++)
            sb.append(getRandomUppercaseChar());
        return sb.toString();
    }
}
