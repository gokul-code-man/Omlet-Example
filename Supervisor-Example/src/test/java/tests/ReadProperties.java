/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author srivathg
 */
public class ReadProperties
{
    public final Properties configProp = new Properties();

    public ReadProperties()
    {
          try 
          {
          //Private constructor to restrict new instances
                    FileInputStream in = new FileInputStream("src/test/resources/Environment.properties");
                    configProp.load(in);
          }
         catch(Exception ee)
         {
                    System.out.println("Error in loading properties" + ee.getMessage());
          }
}
        public String getProperty(String key) 
        {
          return configProp.getProperty(key);
         }
}
