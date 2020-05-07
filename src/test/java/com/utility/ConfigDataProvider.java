package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
    Properties prop;
    public ConfigDataProvider() {
        File src=new File("C:\\Users\\Admin\\git\\Mbvans\\Config\\config.properties");
try {
    FileInputStream fis = new FileInputStream(src);
    prop = new Properties();
    prop.load(fis);
}
catch (Exception e)
{
    System.out.println("Not able to load config file:" + e.getMessage());
}
}

    public String Getbrowser()
    {
       return prop.getProperty("Browser");
    }

    public String Geturl()
    {
        return prop.getProperty("Url");
    }
}
