import java.awt.Color;
import java.awt.Image;

public class Emerald extends Jewel {
    static Image emeraldImage;// shared by all Emeralds

    // I found the locations below by a little bit of guess and 
    // check to find a rectangle that bounded the image of the 
    // Emerald.
    static final int EM_X=0, EM_Y=676, EM_W = 52, EM_H=52;
    
    public Emerald() {
        super(Color.GREEN, getImage());
    }

    private static  Image getImage() {
        if(emeraldImage == null)// haven't opened the emerald image yet
            emeraldImage= openImageFromSpriteSheet(EM_X, EM_Y, EM_W, EM_H);
        return emeraldImage;
    }

}
