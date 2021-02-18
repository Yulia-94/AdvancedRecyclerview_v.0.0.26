package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

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
                .findElementsById("com.h6ah4i.android.example.advrecyclerview:id/button").get(1);
        dragg.click();
    }
}
