package kronaegit.ariha;

import kronaegit.ariha.distorter.ARIHADistorter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ARIHA {
    public BufferedImage img;

    public ARIHA(BufferedImage image) {
        this.img = image;
    }
    public void distort(ARIHADistorter distorter) {
        img = distorter.distort(img);
    }
    public void saveImageToFile(File file) throws IOException {
        ImageIO.write(img, "png", file);
    }
    public void saveImageToFile(String path) throws IOException {
        saveImageToFile(new File(path));
    }
    public BufferedImage getRawImage() {
        return img;
    }
}
