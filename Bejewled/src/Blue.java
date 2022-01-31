import java.awt.Color;
import java.awt.Image;

public class Blue extends Jewel {
    static Image blueImage;

    static final int X = 0, Y = 208, W = 52, H = 52;

    public Blue() {
        super(Color.BLUE, getImages());
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
