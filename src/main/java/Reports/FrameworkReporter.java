package Reports;


import Enums.TestCategoryEnum;
import Utils.ConstantFilePath;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public final class FrameworkReporter {
    private static ExtentReports extent;
    public static ExtentTest test;
    private FrameworkReporter() {
    }

    public static void initReport() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(ConstantFilePath.getReportpath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Swag Labs Report");
            spark.config().setReportName("Swag Labs UI Automation Report");
        }
    }

    public static void createTest(String testCaseName)
    {
      if(Objects.nonNull(extent)) {
         test= extent.createTest(testCaseName);
         FrameworkReportManager.setExtentTest(test);
      }
    }

    public static void flushReports()
    {
        try {
            extent.flush();
            Desktop.getDesktop().browse(new File(ConstantFilePath.getReportpath()).toURI());
            FrameworkReportManager.unload();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void addAuthors(String [] authors)
    {
        for(String author:authors)
        {
            FrameworkReportManager.getExtentTest().assignAuthor(author);
        }
    }
    public static void addTestCategory(TestCategoryEnum[] testCategoryEnums)
    {
        for(TestCategoryEnum testType:testCategoryEnums)
        {
            FrameworkReportManager.getExtentTest().assignCategory(testType.toString());
        }
    }

}
