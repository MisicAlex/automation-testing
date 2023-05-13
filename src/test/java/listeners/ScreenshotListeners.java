package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.File;
import java.util.Date;

public class ScreenshotListeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult testResult){
        try{
            Object currentClass = testResult.getInstance();
            WebDriver driver = ((BaseTest) currentClass).getDriver();
            takeScreenshot(driver, testResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void takeScreenshot(WebDriver driver, ITestResult testResult){
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        String screenshotName = testResult.getName()+"_"+date.toString()
                .replace(":","_").replace(" ","_");
        try{
            FileUtils.copyFile(tempFile, new File("./Screenshots/"+screenshotName+".png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
