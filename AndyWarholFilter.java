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
        // create new image with double size
            int width = image.getWidth() / 2;
            int height = image.getHeight() / 2;
            // create a canvas of equal size
            OFImage newImage = new OFImage(image.getWidth(), image.getHeight());
            
            OFImage originalImage = new OFImage(image);

            
            // set first quadrant
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x, y, originalImage.getPixel(x * 2, y * 2));
                }
            }
            
            
            
            
            // set second quadrant
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x + width, y, originalImage.getPixel(x * 2, y * 2));
                }
            }
            
            // set 4th quadrant
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x + width, y + height, originalImage.getPixel(x * 2, y * 2));
                }
            }
            
            // set 3rd quadrant
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x, y + height, originalImage.getPixel(x * 2, y * 2));
                }
            }
            
            
            
            
            
            // set second quadrant Red Channel
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int r = pix.getRed();
                
                image.setPixel(x + width, y, new Color(r, r, r));
            }
            }
            
            // set third Quadrant Green
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int g = pix.getGreen();
                
                image.setPixel(x, y + height, new Color(g, g, g));
            }
            }
            
            // set fourth Quadrant blue
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int b = pix.getBlue();
                
                image.setPixel(x + width, y + height, new Color(b, b, b));
            }
            }
            
            image = image;

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
