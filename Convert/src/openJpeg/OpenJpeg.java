package openJpeg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created with IntelliJ IDEA.
 * User: jas
 * Date: 29.09.13
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */



public class OpenJpeg {
	
	private static final String IMAGE_FILENAME = "img.jpg";
	
	private static final String PIXEL_INFO_FILENAME = "pixelInfo.txt";

	/**
	 * 
	 * @param pixel argb type int
	 * @return
	 */
    public static int[] getARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        int mass[]= {red,blue,green,alpha};
        return mass;
        }
    
    private static String stringMassARGB(int mass[]){    		
    	return ("Red="+mass[0]+" Blue="+mass[1]+" Green="+mass[2]+" Alpha="+mass[3]);
    }

    public static void main(String[] args) throws IOException {
        BufferedImage img = ImageIO.read(new File(IMAGE_FILENAME));
        int w = img.getWidth();
        int h = img.getHeight();
        File pixelInfo=new File(PIXEL_INFO_FILENAME);
        PrintWriter pw=new PrintWriter(pixelInfo);
        for(int i=0 ; i<w ; i++)
        {
            for(int j=0 ; j < h ; j++)
            {
               int pixel=img.getRGB(i,j);         
               int[] rgbMass = getARGB(pixel);
               pw.printf("pixel[%d,%d] %s\n",i,j,stringMassARGB(rgbMass));
            }
        }
        pw.close();
//        int [][] mas = new int[5][5];
//        int k=0;
//        for(int i=0 ; i<mas.length ; i++)
//        {
//            for(int j=0 ; j<mas.length; j++)
//            {
//                mas[i][j]=k;
//                k++;
//            }
//        }
//        File f-new file
//        for(int i=0 ; i<mas.length; i++)
//        {
//            for(int j=0 ; j<mas.length; j++) {
//                System.out.print(mas[i][j] + " ");
//            }
//            System.out.println();
//        }




    }
}