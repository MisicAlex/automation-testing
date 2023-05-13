package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {

    private static String url, validUsername, validPassword, invalidUsername, invalidPassword;
    private static PropertyManager instance;
    public static PropertyManager getInstance(){
        if (instance == null){
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }
    public void loadData(){
        Properties properties = new Properties();
        try {
            FileInputStream fi = new FileInputStream("src/main/resources/configuration.properties");
            properties.load(fi);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        url = properties.getProperty("url");
        validPassword = properties.getProperty("validPassword");
        validUsername = properties.getProperty("validUsername");
        invalidPassword = properties.getProperty("invalidPassword");
        invalidUsername = properties.getProperty("invalidUsername");

    }
    public String getUrl(){
        return url;
    }

    public String getValidUsername() {
        return validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }
}
