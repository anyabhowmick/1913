package student;

import static student.RGBColor.distance;

public class ColorPallet extends Transformation {


    /**
     * colors to choose from.
     */
    private RGBColor[] pallet = null;

    /**
     * constructor.
     * @param palletX color pallet.
     */
    public ColorPallet(RGBColor[] palletX) {
        pallet = palletX;
    }

    /**
     * changes color of the pixels based off the color pallet, choosing the closest color in the pallet.
     * @param x -- the x position of this color
     * @param y -- the y position of the color
     * @param originalColor -- the original color.
     * @param image -- the image being converted. Most transformation should not need to access this at all,
     *                  but some transformations will (maybe they need the width/height of the image...)
     *                  so we make it available here, and encourage most implementations to ignore it.
     * @return color that's averaged with the closest color in pallet.
     */
    @Override
    public RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        RGBColor smallest = pallet[0];
        for (int i = 1; i < pallet.length; i++) {
            if (distance(originalColor, pallet[i]) < distance(originalColor, smallest)) {
                smallest = pallet[i];
            }
        }

        return smallest;
    }
}
