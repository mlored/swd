package com.sd.isp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurator {
    private final static String URL = "url";
    private final static String CACHE_NAME = "cache.name";

    private static String _url = "";
    private static String _cache_name = "";

    static {
        try {
            final Properties config = new Properties();

            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("isp-client-web-config.properties");
            config.load(input);

            for (Object o : config.keySet()) {
                final String key = o.toString();
                final String value = config.getProperty(key);

                if (key.equalsIgnoreCase(URL)) {
                    _url = value;
                } else if (key.equalsIgnoreCase(CACHE_NAME)) {
                    _cache_name = value;
                }
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static final String getUrl() {
        return _url;
    }

    public static final String getCacheName() {
        return _cache_name;
    }
}