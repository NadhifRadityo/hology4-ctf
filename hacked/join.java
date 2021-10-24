package hacked;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class join {
    public static void main(String[] args) throws Exception {
        int w = 290;
        int h = 30;
        int s = 8;
        int t = 9;

        int wf = w;
        int hf = h * t;
        for(int j = 0; j < s; j++) {
            BufferedImage result = new BufferedImage(wf, hf, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gr = (Graphics2D) result.getGraphics();
            for(int i = 0; i < t; i++) {
                System.out.println("2/" + (i == 0 ? "" : i) + (j + 1) + ".png");
                BufferedImage im = ImageIO.read(new File("2/" + (i == 0 ? "" : i) + (j + 1) + ".png"));
                gr.drawImage(im, 0, i * h, null);
            }
            ImageIO.write(result, "PNG", new File(j + ".png"));
        }
    }
}
