package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Class is final so that other classes cannot extend
 * this class
 */
public final class ReadPropertyFile
{

    public static Properties properties;
    /**
     * Constructor is private so that other classes
     * cannot make object of this class
     */
    private ReadPropertyFile() {}


    /**
     * This will read the property file
     * @param Key
     * @return
     * @throws IOException
     */
    public static String readPropertyFile(String Key) throws IOException
    {
        if(Objects.isNull(Key)) throw new NullPointerException("** Properties file not found. **");

        properties = new Properties();
        FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
        properties.load(fis);
        return properties.getProperty(Key);
    }



}
