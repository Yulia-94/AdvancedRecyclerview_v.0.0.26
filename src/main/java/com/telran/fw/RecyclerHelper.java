package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;

import java.time.Duration;
import java.util.List;

public class RecyclerHelper extends HelperBase{
    public RecyclerHelper(AppiumDriver driver) {
        super(driver);
    }
    public void selectItemSwipe() {
        MobileElement swipe = (MobileElement) driver.findElementByAccessibilityId("Swipe");
        //printDimensions(swipe);
        swipe.click();
    }

    public void selectDraggableBase() {
        MobileElement dragg= (MobileElement) driver
                .findElements(By.xpath("//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button']")).get(1);
        dragg.click();
    }

    public void swipeFormeRightToTeft() {
        List<MobileElement> list = driver.findElements(By.xpath("//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container']"));
        MobileElement el = list.get(1);
        Rectangle rect = el.getRect();
        int xfrom = rect.getX() + rect.getWidth() - 20;
        int yfrom = rect.getY() + rect.getHeight() / 2;
        int xto = rect.getX() + 20;
        int yto = yfrom;

        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xfrom, yfrom))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(7)))
                .moveTo(PointOption.point(xto, yto)).release().perform();



    }
    public void swipeFormeRightToRight() {
        List<MobileElement> list = driver.findElements(By.xpath("//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container']"));
        MobileElement el = list.get(1);
        Rectangle rect = el.getRect();
        int xto = rect.getX() + rect.getWidth() - 20;
        int yfrom = rect.getY() + rect.getHeight() / 2;
        int xfrom = rect.getX() + 20;
        int yto = yfrom;

        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xfrom, yfrom)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(7)))
                .moveTo(PointOption.point(xto, yto)).release().perform();



    }

    public void dragDown() {
        List<MobileElement> list = driver.findElements(By.xpath("//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']"));
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xfrom = rect.getX() + rect.getWidth()/2;
        int yfrom = rect.getY() + rect.getHeight()/2;
        int xto=xfrom;

        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xfrom, yfrom))
                .moveTo(PointOption.point(xto, yfrom + rect.getHeight())).release().perform();



    }

    public void dragDownCount(int count) {
        List<MobileElement> list = driver.findElements(By.xpath("//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']"));
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xfrom = rect.getX() + rect.getWidth()/2;
        int yfrom = rect.getY() + rect.getHeight()/2;
        int xto=xfrom;

        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xfrom, yfrom))
                .moveTo(PointOption.point(xto, yfrom + rect.getHeight()* count)).release().perform();



    }

    public void dragDownWin() {
        List<MobileElement> list = driver.findElements(By.xpath("//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']"));
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xfrom = rect.getX() + rect.getWidth()/2;
        int yfrom = rect.getY() + rect.getHeight()/2;
        int xto=xfrom;
        Dimension size = driver.manage().window().getSize();
        int heightWin = size.getHeight();

        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xfrom, yfrom))
                .moveTo(PointOption.point(xto, heightWin + rect.getHeight()/2)).release().perform();



    }
}
