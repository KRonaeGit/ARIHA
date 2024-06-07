package kronaegit.ariha.distorter;

import java.awt.image.BufferedImage;
import java.util.Random;

public class PixelMoving implements ARIHADistorter {
    private long s;
    private final int e;

    public PixelMoving(int e) {
        this.s = System.currentTimeMillis();
        this.e = e;
    }
    public void setSeed(long s) {
        this.s = s;
    }
    public BufferedImage distort(BufferedImage input) {
        int w = input.getWidth();
        int h = input.getHeight();

        BufferedImage output = new BufferedImage(w, h, input.getType());

        Random random = new Random(s);
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int color = input.getRGB(x, y);

                int newX = x + random.nextInt(e)-(e/2);
                int newY = y + random.nextInt(e)-(e/2);

                try {
                    int moveTo = input.getRGB(newX, newY);
                    output.setRGB(newX, newY, color);
                    output.setRGB(x, y, moveTo);
                } catch(ArrayIndexOutOfBoundsException e) {
                    output.setRGB(x, y, color);
                }
            }
        }
        return output;
    }
}
