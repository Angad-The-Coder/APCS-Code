import java.awt.Color;
import java.util.ArrayList;

/**
 * This class contains class (static) methods that will help you test the Picture class methods.
 * Uncomment the methods and the code in the main to test. This is a great lesson for learning about
 * 2D arrays and the Color class.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {

    private static final double MAX_WID = 1200;

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        /*
         * [X] - implemented
         * 
         * [ ] - not required, may implement later
         */

        // testKeepOnlyBlue(); // [X]
        // testKeepOnlyRed(); // [X]
        // testKeepOnlyGreen(); // [X]
        // testNegate(); // [X]
        // testGrayscale(); // [X]
        // testEdgeDetection(); // [X]
        // testFixUnderwater(); // [X]
        // testChromakey(); // [X]
        // testEncodeAndDecode(); [X]
        // testGetCountRedOverValue(250); // [X]
        // testSetRedToHalfValueInTopHalf(); // [X]
        // testClearBlueOverValue(200); // [X]
        // Color avgColor = testGetAverageForColumn(new Picture("images/seagull.jpg"), 100); // [X]

        // testFaceDetect(); // [ ]
        // testMirrorVertical(); // [ ]
        // testMirrorTemple(); // [ ]
        // testMirrorArms(); // [ ]
        // testMirrorGull(); // [ ]
        // testMirrorDiagonal(); // [ ]
        // testCollage(); // [ ]
        // testCopy(); // [ ]
        // testDiagonal(); // [ ]
        // testQuads(); // [ ]
        // testPixelate(); // [ ]
    }

    private static void testPixelate() {
        // opens the image so that it can be manipulated
        Picture mrH = new Picture("images/beach.jpg");

        // shows the current version of the pic in a new window
        mrH.explore();
    }

    private static void testQuads() {

        // opens the image so that it can be manipulated
        Picture mrH = new Picture("images/beach.jpg");
        double sclF = MAX_WID / mrH.getWidth();
        mrH = mrH.scale(sclF, sclF);
        mrH.explore();// shows the picture in a window before


        // shows the current version of the pic in a new window
        // mrH.explore();
    }

    private static void testDiagonal() {
        // opens the image so that it can be manipulated
        Picture mrH = new Picture("images/beach.jpg");
        // Pictures taken on a phone tend to be very large
        // sometimes too large for the Picture class
        // so I have scaled the one's that are too big
        if (mrH.getWidth() > MAX_WID) {
            double sclF = MAX_WID / mrH.getWidth();
            mrH = mrH.scale(sclF, sclF);
        }

        mrH.explore();// shows the picture in a window before


        // shows the current version of the pic in a new window
        // mrH.explore();
    }

    /** Method to test zeroBlue */
    public static void testZeroBlue() {
        // opens the image so that it can be manipulated
        Picture beach = new Picture("images/beach.jpg");
        beach.explore();// shows the picture in a window before

        Pixel[][] pixels = beach.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel p : row) {
                p.setBlue(0);
            }
        }

        // shows the current version of the pic in a new window
        beach.explore();
    }

    /**
     * Isolates the blue color channel of the image and displays it in a window
     */
    private static void testKeepOnlyBlue() {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore(); // shows the picture in a window

        Pixel[][] pixels = beach.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel p : rowArray) {
                // set the other color channels to 0, isolating the blue channel:
                p.setRed(0);
                p.setGreen(0);
            }
        }

        // shows the modified version of the pic in a new window
        beach.explore();
    }

    /**
     * Isolates the green color channel of the image and displays it in a window
     */
    private static void testKeepOnlyGreen() {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore(); // shows the picture in a window

        Pixel[][] pixels = beach.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel p : rowArray) {
                // set the other color channels to 0, isolating the green channel:
                p.setRed(0);
                p.setBlue(0);
            }
        }

        // shows the modified version of the pic in a new window
        beach.explore();
    }

    /**
     * Isolates the red color channel of the image and displays it in a window
     */
    private static void testKeepOnlyRed() {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore(); // shows the picture in a window

        Pixel[][] pixels = beach.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel p : rowArray) {
                // set the other color channels to 0, isolating the red channel:
                p.setGreen(0);
                p.setBlue(0);
            }
        }

        // shows the modified version of the pic in a new window
        beach.explore();
    }

    /**
     * Because this is a task commonly invoked on a Picture, it makes sense to add this method to
     * the Picture class. If we are doing things that won't likely be used often, we can write these
     * algorithms in this class.
     */
    private static void testNegate() {
        Picture swan = new Picture("images/swan.jpg");
        // write this in Picture class
        swan.negate();
        swan.explore();

    }

    /**
     * Again, like the method above, this is pretty common, so let's add this method to the Picture
     * class.
     */
    private static void testGrayscale() {
        Picture swan = new Picture("images/swan.jpg");
        // write this method in Picture class
        swan.grayScale();
        swan.explore();

    }

    /** Method to test edgeDetection */
    public static void testEdgeDetection() {

        Picture swan = new Picture("images/swan.jpg");

        // written in Picture class
        swan.edgeDetection(10);// bigger number means fewer edges
        swan.explore();
        swan.write("images/swanOutline.jpg");// writes the new picture to a new file
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        // this should take the left-hand half of the picture and reflect it across
        // the vertical midline.
        caterpillar.mirrorVertical();// need to write this method in the picture class
        caterpillar.explore();
    }

    /** Method to test mirrorTemple */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        // This method makes a mirror image of a section of this picture
        // If this picture is of the temple, it mirror images the top.
        // what if this picture is of a different image?
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        // this method creates a mirror image for a section of its
        // pixels. What would happen if we used a different starting
        // image? Is mirrorTemple a useful method in the long run? How
        // could you change it so that it would be more useful?
        Pixel[][] pixels = temple.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {

                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }

        temple.explore();
    }

    /** Method to test the collage method */
    public static void testCollage() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();// this method has been written in the Picture class
        // how can it be changed so that we could pass in
        // pictures that could be added to a collage?
        canvas.explore();
    }

    // So, you can create a Picture Object and find the average value of
    // the component in that column
    private static Color testGetAverageForColumn(Picture pic, int col) {
        pic.explore();
        Pixel[][] pixels = pic.getPixels2D();

        // find the averages for each component of all the pixels in the image:
        int avgRed = 0, avgGreen = 0, avgBlue = 0;
        for (Pixel[] pixRow : pixels) {
            Pixel pix = pixRow[col];
            avgRed += pix.getRed();
            avgGreen += pix.getGreen();
            avgBlue += pix.getBlue();
        }
        avgRed /= pixels.length;
        avgGreen /= pixels.length;
        avgBlue /= pixels.length;

        // create an average color which contains all of the average component values:
        Color avgColor = new Color(avgRed, avgGreen, avgBlue);

        return avgColor;
    }

    // so for this one, any pixels that have blue over a certain value are set
    // to no blue at all. Or for a different effect, have those pixels set to black.
    private static void testClearBlueOverValue(int i) {
        Picture blueMoto = new Picture("images/blueMotorcycle.jpg");
        blueMoto.explore();

        // iterate through each pixel in blueMoto, setting its blue component to 0 if it's
        // greater than i:
        Pixel[][] pixels = blueMoto.getPixels2D();
        for (Pixel[] pixRow : pixels) {
            for (Pixel pix : pixRow) {
                if (pix.getBlue() > i) {
                    pix.setBlue(0);
                }
            }
        }

        blueMoto.explore();
    }

    // goes to each pixel in the top half and cuts the red component in half
    // So, bottom half of pic should look normal
    private static void testSetRedToHalfValueInTopHalf() {
        Picture lionHall = new Picture("images/femaleLionAndHall.jpg");
        lionHall.explore();

        Pixel[][] pixels = lionHall.getPixels2D();
        // traverse the first half of rows:
        for (int pixRow = 0; pixRow < lionHall.getHeight() / 2; pixRow++) {
            for (int pixCol = 0; pixCol < pixels[pixRow].length; pixCol++) {
                Pixel pix = pixels[pixRow][pixCol];
                // divide the red component in half:
                pix.setRed(pix.getRed() / 2);
            }
        }

        lionHall.explore(); // show the modified image
    }

    // displays the number of pixels in the pic that have a red component
    // greater than the specifies int.
    private static void testGetCountRedOverValue(int i) {
        Picture redMoto = new Picture("images/redMotorcycle.jpg");
        redMoto.explore();
        int redCount = 0;

        // iterate through each pixel in redMoto, incrementing redCount if the pixel's red component
        // is greater than i:
        Pixel[][] pixels = redMoto.getPixels2D();
        for (Pixel[] pixRow : pixels) {
            for (Pixel pix : pixRow) {
                if (pix.getRed() > i) {
                    redCount++;
                }
            }
        }

        System.out.println(redCount + " pixels with a red component above " + i + ".");
    }

    /**
     * The method below is really cool!! Use the following approach: go through the entire Picture
     * (the one to carry the message), and make the red component of every pixel an even number. To
     * do this, mod by 2 and see if remainder>0. If so, add or subtract one (subtracting is safer.
     * Why?) Then, using a Picture of a message (one color on white background), any pixel from
     * Picture of message that is not white causes you to add one to the corresponding pixel's red
     * component of the encoded picture (the one with all even red components).
     * 
     * Then you can send along the encoded picture to someone else and they should be able to decode
     * it by looking for Pixels with odd red components.
     */
    private static void testEncodeAndDecode() {
        Picture moto = new Picture("images/blueMotorcycle.jpg"),
                message = new Picture("images/msg3.PNG");
        moto.explore();
        message.explore();

        normalize(moto);// set all red components to even vals

        // superimpose message onto moto by changing all pixels
        // that are part of the message to have odd red component
        hide(moto, message);

        moto.explore();// moto should look pretty much the same

        // traverse each pixel. If it has a red component that is
        // odd, set color of the pixel to BLACK, otherwise WHITE
        decode(moto).explore();
    }

    private static SimplePicture decode(Picture moto) {
        Picture pic = new Picture(moto);// makes a clone of moto
        Pixel[][] pixels = pic.getPixels2D();
        for (Pixel[] pixRow : pixels) {
            for (Pixel pix : pixRow) {
                if (pix.getRed() % 2 != 0) {
                    pix.setColor(Color.BLACK);
                } else {
                    pix.setColor(Color.WHITE);
                }
            }
        }
        return pic;
    }

    private static void hide(Picture pic, Picture msg) {
        // first, to avoid IndexOutOfBoundsExceptions, scale msg such that its dimensions match
        // those of pic (worst case it will be slightly smaller due to truncation upon casting):
        msg = msg.scale((double) pic.getWidth() / msg.getWidth(),
                (double) pic.getHeight() / msg.getHeight());

        Pixel[][] img = pic.getPixels2D(), msgp = msg.getPixels2D();
        for (int pixRow = 0; pixRow < img.length; pixRow++) {
            for (int pixCol = 0; pixCol < img[pixRow].length; pixCol++) {
                Pixel msgPix = msgp[pixRow][pixCol], imgPix = img[pixRow][pixCol];
                if (Pixel.colorDistance(msgPix.getColor(), Color.BLACK) < 220) {
                    // if the pixel's color is relatively close to absolute black, it is part of the
                    // message; modify imgPix accordingly:
                    imgPix.setRed(imgPix.getRed() + 1); // this operation is safe since we assume
                                                        // pic has already been normalized
                }
            }
        }

    }

    /**
     * Sets the red component of every pixel to an even number by subtracting by 1 if it is odd.
     * 
     * @param moto
     */
    private static void normalize(Picture moto) {
        Pixel[][] pixels = moto.getPixels2D();
        for (Pixel[] pixRow : pixels) {
            for (Pixel pix : pixRow) {
                if (pix.getRed() % 2 != 0) {
                    pix.setRed(pix.getRed() - 1);
                }
            }
        }
    }

    /**
     * chroma key means to superimpose one image over another. The image to be drawn over the other
     * one, only draws the pixels that aren't the chroma key The common name for this is green
     * screen
     */
    private static void testChromakey() {
        Picture background = new Picture("images/butterfly1.jpg"),
                foreground = new Picture("images/spidey.jpg").scale(.3, .3);

        background.explore();
        foreground.explore();
        Pixel[][] img = background.getPixels2D(), fgd = foreground.getPixels2D();
        int row = 245, col = 360, offsetR = 0, offsetC = 100;
        for (int r = 0; r < fgd.length - offsetR - 1; r++) {
            for (int c = 0; c < fgd[0].length - offsetC - 1; c++) {
                Pixel p = fgd[r + offsetR][c + offsetC];
                if (p.colorDistance(Color.green) > 60) {
                    img[row + r][col + c].setColor(p.getColor());
                }
            }
        }
        background.explore();
    }

    /**
     * use edge detection and search for an oval... HARD!!!
     */
    private static void testFaceDetect() {

    }

    // copies a picture onto another
    private static void testCopy() {

    }

    // Creates a new Picture that creates a mirror image along one diagonal
    private static void testMirrorDiagonal() {

    }

    private static void testMirrorGull() {
        // creates a mirror image of a bird making image look like bird is over water

    }

    private static void testMirrorArms() {}

    /**
     * This method is an effort to make a Picture taken underwater look more like it would be if the
     * water were drained
     */
    private static void testFixUnderwater() {
        Picture pic = new Picture("images/water.jpg");
        // display the original picture:
        pic.explore();

        // water is blue and green... solution: reduce the value of the blue and green channels!
        Pixel[][] pixels = pic.getPixels2D();
        for (Pixel[] pixRow : pixels) {
            for (Pixel pix : pixRow) {
                // reduce the blue and green components by 115 and increase the red component by 20,
                // making sure the result remains in the range 0 - 255:
                int newBlue = Math.max(pix.getBlue() - 115, 0);
                int newGreen = Math.max(pix.getGreen() - 115, 0);
                int newRed = Math.min(pix.getRed() + 20, 255);

                // upate the pixel with the new RGB components:
                pix.setBlue(newBlue);
                pix.setGreen(newGreen);
                pix.setRed(newRed);
            }
        }
        // display the modified image in a new window:
        pic.explore();
    }

    /**
     * Checks to see if row and col are within the Picture pic
     * 
     * @param pic Picture we are checking
     * @param row Row in pic
     * @param col Col in pic
     * @return true if row and col are valid for pic, false otherwise
     */
    public boolean inbounds(Picture pic, int row, int col) {
        return false;
    }

    /**
     * Uses Chromakey to "paste" front onto back, excluding Colors that are closer to rem than
     * threshold.
     * 
     * @param back The Picture onto which front is pasted
     * @param front The Picture to be pasted onto back
     * @param rowStart Row where the top of front is pasted onto back
     * @param colStart Col where the left side of front is pasted onto back
     * @param rem Color to use as transparency. Colors closer than threshold to rem are not copied
     *        onto back
     * @param threshold Color distance beyond which the colors of front will be copied onto back.
     */
    public void chromakey(Picture back, Picture front, int rowStart, int colStart, Color rem,
            double threshold) {

    }
}
