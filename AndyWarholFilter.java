import java.awt.Color;
/**
 * Write a description of class AndyWarholFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AndyWarholFilter extends Filter
{
   public AndyWarholFilter(String name)
    {
        super(name);
    }

    /**
     * Constructor for objects of class RemoveBlueFilter
     */
    public void apply(OFImage image){
        
        int height = image.getHeight();
        int width = image.getWidth();
        
        // change all colors in the image
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int r = pix.getRed();
                
                image.setPixel(x, y, new Color(r, r, r));
            }
        }
    }
    
    private OFImage smallerImage(OFImage image)
    { 
            // create new image with double size
            int width = image.getWidth() / 2;
            int height = image.getHeight() / 2;
            OFImage newImage = new OFImage(width, height);

            // copy pixel data into new image
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    newImage.setPixel(x, y, image.getPixel(x * 2, y * 2));
                }
            }
            
            return newImage;
        
    }
}
