package silinder;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.WritableRaster;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class solve {
    public static void main(String[] args) throws Exception {
        File f = new File("raw");
        FileInputStream fis = new FileInputStream(f);
        long l = f.length();
        int w = 1280;
        int h = 640;
        int p = (int) (l / 4); // BGRA
        System.out.println("width: " + w);
        System.out.println("height: " + h);
        System.out.println("all: " + w*h);
        System.out.println("p: " + p);

        byte[] pixels = new byte[w*h*4];
        fis.skip(pixels.length);
        fis.skip(pixels.length);
        fis.skip(pixels.length);
        fis.skip(pixels.length);
        fis.skip(pixels.length);
        // fis.skip(pixels.length);
        // fis.read(pixels);
        for(int i = 0; i < h; i++) {
            fis.read(pixels, i * w * 4, w * 4);
            fis.skip(w * 4);
            // fis.skip(w * 3 * 4);
        }

        int[] bands = new int[] { 3, 2, 1, 0 };
		SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, w, h, bands.length, w * bands.length, bands);
		WritableRaster raster = Raster.createWritableRaster(sampleModel, new DataBufferByte(pixels, w * h * bands.length), null);
		ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), true, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE);
		BufferedImage result = new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);
        
        ImageIO.write(result, "PNG", new File("out.png"));
    }
}