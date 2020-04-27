package com.testing.automation.wrapper;

import com.testing.automation.testbase.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

public class SeleniumWrapper extends TestBase {
    WebDriver driver;

    public SeleniumWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public long currentTimeInMilliseconds() {
        Date date = new Date();
        long time = date.getTime();
        return time;
    }

    public void takeScreenshot() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("screenshots//" + currentTimeInMilliseconds() + ".png");
            FileHandler.copy(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshotWithUrl() {
        try {
            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rectangle = new Rectangle(screenSize);
            BufferedImage sourceFile = robot.createScreenCapture(rectangle);
            File destinationFile = new File("screenshots//" + currentTimeInMilliseconds() + ".png");
            ImageIO.write(sourceFile,"png",destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
