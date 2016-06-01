package com.example.testing.testingexample;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

/**
 * author: baiiu
 * date: on 16/4/27 15:35
 * description: uiautomator测试,请将屏幕滑到包含该app的页面
 */
@RunWith(AndroidJUnit4.class) @SdkSuppress(minSdkVersion = 18)
public class UiautomatorTestJunitStyle {
  private UiDevice device;

  @Before public void setUp() throws Exception {
    device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    device.wait(Until.hasObject(By.text("TestingExample")), 3000);
    UiObject2 TestingExampleApp = device.findObject(By.text("TestingExample"));
    TestingExampleApp.click();
  }

  @Test public void testSayHello() throws Exception {
    device.wait(Until.hasObject(By.text("hello_world")), 3000);

    device.wait(Until.hasObject(By.text("Enter your name here")), 3000);
    UiObject2 editText = device.findObject(By.text("Enter your name here"));
    editText.setText("Peter");

    device.wait(Until.hasObject(By.text("Say hello!")), 3000);
    UiObject2 button = device.findObject(By.text("Say hello!"));
    button.click();

    device.waitForIdle(3000);

    UiObject targetTextView = device.findObject(new UiSelector().textContains("Hello"));
    assertEquals("Hello, " + "Peter" + "!", targetTextView.getText());
  }
}
