import java.awt.Color;
import java.awt.Image;

public class Red extends Jewel {
    static Image redImage;

    static final int X = 0, Y = 312, W = 52, H = 52;

    public Red() {
        super(Color.RED, getImages());
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
