package student;

public class Brighten extends Transformation {

    /**
     * amount by which the pixel will brighten or dim.
     */
    private int amount;

    /**
     * constructor.
     * @param amountX amount of change.
     */
    public Brighten(int amountX) {
        amount = amountX;
    }

    /**
     * changes the pixel by amount, ensures the new value doesn't go below 0 or above 255.
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return color that's either brighter or dimmer than before.
     */
    @Override
    public RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        int[] colorList = {originalColor.getRed() + amount, originalColor.getGreen()
                + amount, originalColor.getBlue() + amount};
        for (int i = 0; i < 3; i++) {
            if (colorList[i] > 255) {
                colorList[i] = 255;
            } else if (colorList[i] < 0) {
                colorList[i] = 0;
            }
        }


        return new RGBColor(colorList[0], colorList[1], colorList[2]);
    }

}
