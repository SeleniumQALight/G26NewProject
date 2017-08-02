package libs;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 *  That class provides static methods for getting values from Config and UI mapping files
 */
public class ConfigData {
    private static String cfgFile="src/config.properties";
    private static String uiMappingFile="./src/main/java/UIMapping.properties";

    /*
     *  Return value from .properties file
     */
    private static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        // Create stream for reading from file
        FileInputStream cfg = new FileInputStream(fileName);
        // Load Properties from input stream
        p.load(cfg);
        cfg.close();

        // Return value for the property
        return(p.getProperty(key));
    }


    /*
     *  Return value from UI mapping file.
     *  Note, please, that returned value is String.
     *  We should take care of value's type by himself when will use config data value in the test.
     */
    public static String getUiMappingValue(String key) throws IOException {
    	
        return(getValueFromFile(key, uiMappingFile));
    }


    /*
    *  Return value from config file.
    *  Note, please, that returned value is String.
    *  We should take care of value's type by himself when will use config data value in the test.
    */
    public static String getCfgValue(String key) throws IOException {

        return(getValueFromFile(key, cfgFile));
    }





}
