import kronaegit.ariha.ARIHA;
import kronaegit.ariha.creator.TextCreator;
import kronaegit.ariha.distorter.*;
import kronaegit.ariha.util.Hash;
import kronaegit.ariha.util.RandomGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Gen {
    public static void main(String[] args) throws IOException, InterruptedException {
        Color colorA = new Color(64, 64, 64);
        Color colorB = new Color(76, 76, 76);

        TextCreator creator = new TextCreator(10);
        creator.backgroundColor(colorA);
        creator.fontColor(colorB);
        creator.font(new Font("Cascadia Code SemiBold", Font.ITALIC, 100));

        RandomGenerator random = new RandomGenerator();
        String key = random.getRandomString(5) + '-' + random.getRandomString(5);
        ARIHA image = creator.create(key);
        key = Hash.SHA256(p(key));

        BufferedImage raw = image.getRawImage();
        int width = raw.getWidth();
        int height = raw.getHeight();

        PixelMoving distorter2 = new PixelMoving(10);
        ColorChanging distorter3 = new ColorChanging(512);

        int t = 5;
        for (int i = 0; i < random.getRandomIntegerBetween(5, 15); i++) {
            int ax = random.getRandomIntegerBetween(0, width);
            int ay = random.getRandomIntegerBetween(0, height);
            int bx = random.getRandomIntegerBetween(0, width);
            int by = random.getRandomIntegerBetween(0, height);

            CustomLinePutting distorter;
            if(random.getRandomIntegerBetween(0, 1) == 0) {
                distorter = new HorizontalLinePutting(ay, by, t, colorB);
            } else {
                distorter = new VerticalLinePutting(ax, bx, t, colorB);
            }

            image.distort(distorter);
        }

        image.distort(distorter2);
        image.distort(distorter3);
        image.saveImageToFile("test.png");

        System.out.println("Are you a ROBOT? If not, write the verification code.");
        Thread.sleep(1500);
        Runtime.getRuntime().exec("cmd /c start test.png");

        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String ans = p(scanner.nextLine());
        if(Hash.SHA256(ans).equals(key)) {
            System.out.println("Verification: Successful.");
            System.out.println("Your account is SAFE now.");
            System.out.println("Thank you for cooperation.");
            return;
        }
        System.err.println("YOU WRONG. Try again.");
        main(args);
    }

    private static String p(String s) {
        return s.replace("-","").replaceAll("[\\s\\n\\t\\r]*","").toUpperCase();
    }
}
