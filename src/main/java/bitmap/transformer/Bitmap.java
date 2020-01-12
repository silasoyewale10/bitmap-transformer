package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Bitmap {

    String transformation;
    Path outputPath;
    BufferedImage image;

    public Bitmap(String inputPath, String outputPath) {
        try {
        Path realinputPath = Paths.get(inputPath);
        this.outputPath = Paths.get(outputPath);
        this.image = ImageIO.read(realinputPath.toFile());  //image variable has height and width;
        } catch (IOException ex) {
            System.out.println("now we cooking");
        }
    }

    public void negativeRGBTransformation(){

    int imageHeight = image.getHeight();
    int imageWidth = image.getWidth();


    for(int i = 0; i < imageHeight; i++){
        for(int j = 0; j < imageWidth; j++){
            int rgb = image.getRGB(i, j);
            Color inputColor = new Color(rgb);
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
    public void grayscaleTransformation(){

        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();

        //https://www.dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-grayscale-image-in-java
        for(int i = 0; i < imageHeight; i++){
            for(int j = 0; j < imageWidth; j++){
                int rgb = image.getRGB(i, j);
                Color inputColor = new Color(rgb);
                int grayscale = (inputColor.getRed() + inputColor.getGreen() + inputColor.getBlue()) / 3;
                Color outputColor = new Color(grayscale, grayscale, grayscale);
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

    public void mirroredTransformation(){

        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();

        //https://www.dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-grayscale-image-in-java
        for(int i = 0; i < imageHeight; i++){
            for(int j = 0; j < imageWidth; j++){
                int rgb = image.getRGB(i, j);
                image.setRGB(j, i , rgb);
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

