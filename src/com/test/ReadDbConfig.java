package com.test;
import java.util.ResourceBundle;

public class ReadDbConfig
{

    public ReadDbConfig()
    {
    }

    public String getProp(String key)
    {
        String SystemPropertyFile = "dbconfig";
        ResourceBundle bundle = ResourceBundle.getBundle(SystemPropertyFile);
        String val = bundle.getString(key);
        return val;
    }
}