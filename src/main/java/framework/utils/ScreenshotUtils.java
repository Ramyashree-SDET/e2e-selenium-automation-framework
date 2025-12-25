package framework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver,String testName)
    {
        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + "/reports/screenshots/"
                + testName + ".png";
        try{
            new File(path).getParentFile().mkdirs();
            FileUtils.copyFile(src, new File(path));
        }catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
        return path;
    }
}
