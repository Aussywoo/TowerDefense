package game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Allows for efficient retrieval of files from the resources folder. Once a file has been retrieved once, it will
 * stay in cache.
 */
public class ResourceLoader {
    private static BufferedImage image;
    private static HashMap imageMap;
    private static HashMap pathMap;
    static private ResourceLoader instance;

    private ResourceLoader() {
        imageMap = new HashMap();
        pathMap = new HashMap();

    }

    /**
     * Loads up an image and stores it in a list. Checks to see if image has already been loaded -- if so, it just
     * returns it from the list.
     * @param fileName The image filename to be retrieved.
     * @return
     */
    public BufferedImage getImage(String fileName) {
        // Load the backdrop image and path from the resources folder.  Feel free to alter this,
        // but be careful to make sure your resources folder is a java package in the src
        // portion of your project.

        try
        {
            //Check to see if image has been previously loaded
            if(imageMap.containsKey(fileName)) {
                return (BufferedImage) imageMap.get(fileName);
            }

            //Load the image
            ClassLoader loader = this.getClass().getClassLoader();
            InputStream is = loader.getResourceAsStream("resources/" + fileName);
            image = javax.imageio.ImageIO.read(is);

            //Store the image in the map
            imageMap.put(fileName, image);
        }
        catch (IOException e)
        {
            System.out.println("Could not load the image.");
            System.exit(0);
        }
        return image;
    }

    /**
     * Loads up a path and stores it in a list. Checks to see if ipathmage has already been loaded -- if so, it just
     * returns it from the list.
     * @param fileName The path filename to be retrieved.
     * @return
     */
    public Path getPath(String fileName) {

        //Check to see if image has been previously loaded
        if(pathMap.containsKey(fileName)) {
            return (Path) pathMap.get(fileName);
        }

        //Load the path
        ClassLoader loader = this.getClass().getClassLoader();
        Scanner pathScanner = new Scanner(loader.getResourceAsStream("resources/" + fileName));

        Path path = new Path(pathScanner);

        //Store the path in the map
        pathMap.put(fileName, path);

        return path;
    }

    static public ResourceLoader getLoader()
    {
        if (instance == null)
            instance = new ResourceLoader ();

        return instance;
    }
}
