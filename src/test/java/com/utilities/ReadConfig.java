package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadConfig {
	static Properties prop;
	String path = "C:\\Users\\Moreshwar\\eclipse-workspace1\\MS1\\Configuration\\config.properties";

	    private Properties properties;

	    public ReadConfig() {
	        try {
	            FileInputStream file = new FileInputStream("C:\\Users\\Moreshwar\\eclipse-workspace1\\MS1\\Configuration\\config.properties");
	            properties = new Properties();
	            properties.load(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public String getBrowser() {
	        return properties.getProperty("browser");
	    }

	    public String getUrl() {
	        return properties.getProperty("url");
	    }

	  	}


