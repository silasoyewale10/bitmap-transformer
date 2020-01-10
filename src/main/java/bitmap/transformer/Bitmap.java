package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Bitmap {

    Path outputPath;
    BufferedImage image;

    public Bitmap(String inputPath, String outputPath) {
        try {
        Path realinputPath = Paths.get(inputPath);
        this.outputPath = Paths.get(outputPath);
        this.image = ImageIO.read(realinputPath.toFile());  //image variable has height and width;
            System.out.println(image);
        } catch (IOException ex) {
            System.out.println("now we cooking");
        }
    }

    public void negativeRGB(){

        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();

        System.out.println("imageHeight = " + imageHeight);
        System.out.println("imageWidth = " + imageWidth);

        for(int i = 0; i < imageHeight; i++){
            for(int j = 0; j < imageWidth; j++){
                int rgba = image.getRGB(i, j);
                Color inputColor = new Color(rgba, true);
                Color outputColor = new Color(255 - inputColor.getRed(),
                        255 - inputColor.getGreen(),
                        255 - inputColor.getBlue());
                image.setRGB(i, j, outputColor.getRGB());
            }
        }
        try {
            ImageIO.write(image, "bmp", outputPath.toFile());
            System.out.println("printed to " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
