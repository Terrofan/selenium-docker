package com.tests;

import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class CustomAssert extends SoftAssert {



    @Override
    protected void doAssert(IAssert<?> a) {
        super.doAssert(a);
        System.out.println("TakesScreenshot");
    }
}
