package student;

public class AddBorder extends Transformation {

    /**
     * width of the border.
     */
    private int width;

    /**
     * color of the border.
     */
    private RGBColor borderColor;


    /**
     * constructor.
     * @param widthX width of the border
     * @param borderColorX color
     */
    public AddBorder(int widthX, RGBColor borderColorX) {
        width = widthX;
        borderColor = borderColorX;
    }

    /**
     * adds a border to the image.
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return color of either the border or the original image color.
     */
    @Override
    public RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        if (x < width || y < width || y >= image.getHeight() - width || x >= image.getWidth() - width) {
            return borderColor;
        }

        return originalColor;
    }



}
