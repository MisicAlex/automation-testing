package dataGenerator;

import org.testng.annotations.DataProvider;
import utilities.PropertyManager;

public class DataProviders {
    @DataProvider(name = "failedLogin")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]
                {
                        {"", PropertyManager.getInstance().getInvalidPassword(), "Epic sadface: Username is required"},
                        {PropertyManager.getInstance().getValidUsername(), "", "Epic sadface: Password is required"},
                       {PropertyManager.getInstance().getInvalidUsername(), PropertyManager.getInstance().getInvalidPassword(), "Epic sadface: Username and password do not match any user in this service"}

                };
    }
}
