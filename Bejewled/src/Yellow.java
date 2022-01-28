import java.awt.Color;
import java.awt.Image;

public class Yellow extends Jewel {
    static Image yellowImage;// shared by all Yellow

    // I found the locations below by a little bit of guess and
    // check to find a rectangle that bounded the image of the
    // Emerald.
    // Y_X left corner, Y_Y top corner
    static final int X = 0, Y = 0, W = 52, H = 52;

    public Yellow() {
        super(Color.YELLOW, getImages());
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
    // if (yellowImage == null)// haven't opened the emerald image yet
    // yellowImage = openImageFromSpriteSheet(X, Y, W, H);
    // return yellowImage;
    // }
}
