package kronaegit.ariha.distorter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CustomLinePutting implements ARIHADistorter {
    private final int ax;
    private final int ay;
    private final int bx;
    private final int by;
    private final int t;
    private final Color c;

    public CustomLinePutting(int ax, int ay, int bx, int by, int thickness, Color color) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        this.t = thickness;
        this.c = color;
    }
    @Override
    public BufferedImage distort(BufferedImage input) {
        int w = input.getWidth();
        int h = input.getHeight();
        Graphics2D g = input.createGraphics();
        g.setColor(c);
        g.setStroke(new BasicStroke(t));
        g.drawLine(ax == -1 ? w : ax, ay == -1 ? h : ay, bx == -1 ? w : bx, by == -1 ? h : by);
        g.dispose();
        return input;
    }
}
