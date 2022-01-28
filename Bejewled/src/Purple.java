import java.awt.Color;
import java.awt.Image;

public class Purple extends Jewel {
    static Image purpleImage;// shared by all Emeralds

    // I found the locations below by a little bit of guess and
    // check to find a rectangle that bounded the image of the
    // Emerald.
    static final int X = 0, Y = 416, W = 52, H = 52;

    public Purple() {
        super(Color.MAGENTA, getImages());
    }

    public static Image[] getImages() {
        Image[] imgs = new Image[ANIMATION_FRAMES];
        for (int i = 0; i < ANIMATION_FRAMES; i++) {
            Image frame = openImageFromSpriteSheet(52 * i, Y, W, H);
            imgs[i] = frame;
        }
        return imgs;
    }

    // private static Image getImage() {
    // if (purpleImage == null)// haven't opened the emerald image yet
    // purpleImage = openImageFromSpriteSheet(X, Y, W, H);
    // return purpleImage;
    // }

}
