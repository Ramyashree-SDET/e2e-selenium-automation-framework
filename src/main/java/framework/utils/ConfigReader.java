package framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private static Properties loadPropertyFile()
    {
        String env = System.getProperty("env");
        if(env==null || env.isEmpty())
        {
            env="qa";
        }
        String configFileName = "config-"+env+".properties";
        if(properties==null)
        {
            try (InputStream fis =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream(configFileName)) {

            if (fis == null) {
                throw new RuntimeException("configfile.properties not found in classpath");
            }
                properties = new Properties();
                properties.load(fis);

            } catch (IOException e) {
                throw  new RuntimeException("Failed to load Config properties file"+e.getMessage());
            }

        }
        return properties;
    }

    public static String getProperty(String key)
    {
        // 1. Check system property (CI / command line)
        String systemValue = System.getProperty(key);
        if(systemValue!=null && !systemValue.isEmpty())
        {
            return systemValue;
        }

        //2.read from Config file
        return loadPropertyFile().getProperty(key);
    }
}
