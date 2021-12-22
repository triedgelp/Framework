package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

    private static ExtentReports extent;
    public static  ExtentTest test;


    public static void buildReport() throws IOException {
        if(Objects.isNull(extent)) {
            //ExtentSparkReporter spark = new ExtentSparkReporter("target/spark/spark.html");


            ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
            extent = new ExtentReports();
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("MyReport");
            spark.config().setReportName("Demo");

            extent.attachReporter(spark);

        }
    }

    public static void finishReport() throws IOException {
        if(Objects.nonNull(extent)){
            extent.flush();
        }
    }

    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }


}
