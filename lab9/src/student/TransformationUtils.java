package student;

import static student.RGBImageUtil.load;
import static student.RGBImageUtil.saveImage;

public class TransformationUtils {

    /**
     * transforms entire image based on a list of transformations.
     * @param transformations list of transformations.
     * @param inptfle name of the input file to be changed.
     * @param otpFle name of output file with changes made.
     */
    public static void transformMany(Transformation[] transformations, String inptfle, String otpFle) {
        RGBImage inputImage = load(inptfle);
        for (int i = 0; i < inputImage.getHeight(); i++) { //y vals
            for (int j = 0; j < inputImage.getWidth(); j++) { //x vals
                for (Transformation transformation : transformations) {

                    inputImage.setColor(j, i, (transformation.do_transform(j, i,
                            inputImage.getColor(j, i), inputImage)));
                }
            }
        }

        RGBImage outputImg = new RGBImage(inputImage);
        saveImage(outputImg, otpFle);
    }

}
