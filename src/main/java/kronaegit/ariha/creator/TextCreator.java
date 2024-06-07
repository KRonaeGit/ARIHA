package kronaegit.ariha.creator;

import kronaegit.ariha.ARIHA;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextCreator implements ARIHACreator {
    private final boolean auto;
    private int w, h;
    private int p;
    private Font f = new Font("Arial", Font.ITALIC, 30);
    private Color bc = Color.BLACK;
    private Color fc = Color.DARK_GRAY;

    public TextCreator(int width, int height) {
        this.w = width;
        this.h = height;
        auto = false;
    }
    public TextCreator(int padding) {
        this.p = padding;
        auto = true;
    }
    public Font font() {
        return f;
    }
    public void font(Font f) {
        this.f = f;
    }
    public Color backgroundColor() {
        return bc;
    }
    public void backgroundColor(Color c) {
        this.bc=c;
    }
    public Color fontColor() {
        return fc;
    }
    public void fontColor(Color c) {
        this.fc=c;
    }
    @Override
    public ARIHA create(String pw) {
        Graphics2D g = newGraphics();
        g.setFont(f);
        FontMetrics metrics = g.getFontMetrics();
        int tw = metrics.stringWidth(pw);
        int th = metrics.getHeight();

        if(auto) {
            w = tw+2*p;
            h = th+2*p;
            g.dispose();
        }

        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        g = image.createGraphics();

        g.setColor(bc);
        g.fillRect(0, 0, w, h);

        g.setColor(fc);
        g.setFont(f);

        int x = (w - tw) / 2;
        int y = (h - th) / 2 + f.getSize() - 1;

        g.drawString(pw, x, y);

        g.dispose();
        return new ARIHA(image);
    }

    private Graphics2D newGraphics() {
        return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).createGraphics();
    }
}
