import java.awt.Color;
import java.awt.Image;

public class Yellow extends Jewel {
    static Image yellowImage;

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

}
