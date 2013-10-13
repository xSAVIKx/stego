package conert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class ConvertToJpeg {
	public static File imgFile;

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		imgFile = new File("img.jpg");

		BufferedImage bi = ImageIO.read(new FileImageInputStream(imgFile));
		int height = bi.getHeight();
		int wight = bi.getWidth();
		int mas[][] = new int[200][200];
		for (int j = 0; j < wight; j++) {
			for (int i = 0; i < height; i++) {
				//
				int aRGB = bi.getRGB(j, i);
				if (((aRGB & 0b0000_0000_1111_1111_1111_1111_1111_1111) != 16777215)
						&& (aRGB & 0b0000_0000_1111_1111_1111_1111_1111_1111) != 0)
					System.out.println("i=" + i + "j=" + j + " argb " + aRGB);
				// mas[j][i] = bi.getRGB(j, i);
				// int blue = aRGB&255;
				// int green = (aRGB>>8)&255;
				// int red = (aRGB>>16)&255;
				// if (red == 255 && green==255 && blue==255)
				// bi.setRGB(i, j, 1|(1<<8)|(1<<16));
				if ((aRGB & 0b0000_0000_1111_1111_1111_1111_1111_1111) == 16777215)
					bi.setRGB(j, i, -16711423);
				if ((aRGB & 0b0000_0000_1111_1111_1111_1111_1111_1111) == 0)
					bi.setRGB(j, i, -1);
				// System.out.println("mas:" + mas[j][i]);
			}
		}

		File outputfile = new File("img1.png");
		ImageIO.write(bi, "JPG", outputfile);

	}
}
