import java.awt.Color;
import java.awt.Image;

public class Orange extends Jewel {
    static Image orangeImage;// shared by all Emeralds

    // I found the locations below by a little bit of guess and
    // check to find a rectangle that bounded the image of the
    // Emerald.
    static final int X = 0, Y = 520, W = 52, H = 52;

    public Orange() {
        super(Color.ORANGE, getImages());
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
    // if (orangeImage == null)// haven't opened the emerald image yet
    // orangeImage = openImageFromSpriteSheet(X, Y, W, H);
    // return orangeImage;
    // }

}
