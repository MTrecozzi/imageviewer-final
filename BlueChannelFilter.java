import java.awt.Color;
/**
 * Write a description of class BlueChannelFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueChannelFilter extends Filter
{
   public BlueChannelFilter(String name)
    {
        super(name);
    }

    /**
     * Constructor for objects of class RemoveBlueFilter
     */
    public void apply(OFImage image){
        
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int b = pix.getBlue();
                
                image.setPixel(x, y, new Color(b, b, b));
            }
        }
    }
}
