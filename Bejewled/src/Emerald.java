import java.awt.Color;
import java.awt.Image;

public class Emerald extends Jewel {
    static Image emeraldImage;// shared by all Emeralds

    // I found the locations below by a little bit of guess and
    // check to find a rectangle that bounded the image of the
    // Emerald.
    static final int X = 0, Y = 624, W = 52, H = 52;

    public Emerald() {
        super(Color.GREEN, getImages());
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
    // if (emeraldImage == null)// haven't opened the emerald image yet
    // emeraldImage = openImageFromSpriteSheet(X, Y, W, H);
    // return emeraldImage;
    // }

}
