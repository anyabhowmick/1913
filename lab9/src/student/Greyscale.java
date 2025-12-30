package student;

public class Greyscale extends Transformation {

    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        // Scramble the color values up -- it's always a fun transformation!
        int avg = originalColor.getBlue() + originalColor.getGreen() + originalColor.getRed();
        avg /= 3;
        return new RGBColor(avg, avg, avg);
    }
}

