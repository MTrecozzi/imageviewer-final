import java.awt.Color;
/**
 * Write a description of class GreenChannelFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreenChannelFilter extends Filter
{
   public GreenChannelFilter(String name)
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
                int g = pix.getGreen();
                
                image.setPixel(x, y, new Color(g, g, g));
            }
        }
    }
}
