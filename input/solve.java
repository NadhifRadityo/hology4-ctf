package input;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import java.awt.image.ComponentColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;

public class solve {
    public static void main(String[] args) throws Exception {
        File f = new File("Chall");
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);

        int lineL = 24;
        byte[] line = new byte[lineL];
        int row = (int) (f.length() / lineL);
        for(int i = 0; i < row; i++) {
            fis.read(line);
            
        }

        // int w = 24;
        // int h = 137;

        // byte[] pixels = new byte[w*h*4];
        // for(int i = 0; i < pixels.length; i+=4) {
        //     byte b = dis.readByte();
        //     pixels[i + 2] = b;
        //     pixels[i + 1] = b;
        //     pixels[i + 0] = b;
        //     pixels[i + 3] = (byte) 255;
        // }
        
        // int[] bands = new int[] { 0, 1, 2, 3 };
		// SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, w, h, bands.length, w * bands.length, bands);
		// WritableRaster raster = Raster.createWritableRaster(sampleModel, new DataBufferByte(pixels, w * h * bands.length), null);
		// ColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), true, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE);
		// BufferedImage result = new BufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);
		// ImageIO.write(result, "PNG", new File("out.png"));
    }
}
