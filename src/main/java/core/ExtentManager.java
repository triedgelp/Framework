package core;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private static ThreadLocal <ExtentTest> exTest = new ThreadLocal<>();

    static ExtentTest getExtendTest() {
        return exTest.get();
    }
    static void setExtentTest(ExtentTest test) {
        exTest.set(test);
    }

    static void unload() {
        exTest.remove();
    }


}
