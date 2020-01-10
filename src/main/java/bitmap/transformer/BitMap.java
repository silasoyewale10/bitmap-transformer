package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BitMap {
    String inputPath;
    String outputPath;
    private BufferedImage image;
    private BufferedImage imageOutput;

    public BitMap(String inputPath, String outputPath) {
        try {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        File bmpFile = new File(inputPath);
        this.image = ImageIO.read(bmpFile);  //image variable has height and width;
        } catch (IOException ex) {
            System.out.println("now we cooking");
        }
    }
    public void negativeRGB(){

        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();

        for(int i = 0; i < imageHeight; i++){
            for(int j = 0; j < imageWidth; j++){
                int rgba = image.getRGB(i, j);
                Color inputColor = new Color(rgba, true);
                Color outputColor = new Color(255 - inputColor.getRed(),
                        255 - inputColor.getGreen(),
                        255 - inputColor.getBlue());
                imageOutput.setRGB(i, j, outputColor.getRGB());
            }
        }
        try {
            ImageIO.write(imageOutput, "bmp", new File(outputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
