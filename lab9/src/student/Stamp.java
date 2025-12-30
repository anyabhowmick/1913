package student;

public class Stamp extends Transformation {

    /**
     * stamp image.
     */
    private RGBImage toStamp;

    /**
     * constructor.
     * @param toStampX the stamp.
     */
    public Stamp(RGBImage toStampX) {
        toStamp = toStampX;
    }

    /**
     * puts stamp onto top left of the image image.
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return a new color so the stamp shows up.
     */
    @Override
    public RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        if (x < toStamp.getWidth() && y < toStamp.getHeight()) {
            RGBColor stampPxl = toStamp.getColor(x, y);
            if (stampPxl == null) {
                System.out.println(x + " " + y);
            }
            int newRed = (originalColor.getRed() + stampPxl.getRed()) / 2;
            int newGreen = (originalColor.getGreen() + stampPxl.getGreen()) / 2;
            int newBlue = (originalColor.getBlue() + stampPxl.getBlue()) / 2;
            return new RGBColor(newRed, newGreen, newBlue);
        }

        return originalColor;
    }


}
