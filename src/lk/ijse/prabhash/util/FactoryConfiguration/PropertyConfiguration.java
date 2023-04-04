package lk.ijse.prabhash.util.FactoryConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfiguration {
    public  static  void injectProperties(){
        Properties properties=new Properties();
        try{
            FileInputStream fileInputStream=new FileInputStream("hibernate.properties");
            properties.load(fileInputStream);
        }catch (IOException e){
            System.out.println("An error occured in Propetyconfiguration"+e.getLocalizedMessage());
        }
    }
}
