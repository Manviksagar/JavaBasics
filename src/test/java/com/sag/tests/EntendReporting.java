package com.sag.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EntendReporting {

    ExtentHtmlReporter htmlreport;
    ExtentReports reports;
    ExtentTest extest;

    @BeforeTest
    public void setup(){
        htmlreport =new ExtentHtmlReporter("./reports/htmlReport.html");
        htmlreport.config().setEncoding("utf-8");
        htmlreport.config().setDocumentTitle("DocHeader sag");
        htmlreport.config().setReportName("Sag Report");
        htmlreport.config().setTheme(Theme.STANDARD);
        reports = new ExtentReports();
        reports.setSystemInfo("Linux", "PC-885");
        reports.setSystemInfo("Broser", "chrome");
        reports.attachReporter(htmlreport);

    }

    @AfterTest
    public void tearDown(){

        reports.flush();
    }
@Test
    public void tc1(){
        extest=reports.createTest("Positive Test case");
        extest.log(Status.PASS, "Test case Passed in Level 1");

    }
    @Test
    public void tc2(){
        extest=reports.createTest("Negative Test case");
        extest.log(Status.FAIL, "Test case Negative in Level 1");
        Assert.fail("Test failied due to ENV variables");

    }
    @Test
    public void tc3(){
        extest=reports.createTest(" Skipped Test case");
        extest.log(Status.SKIP, "Test case Skipped in Level 1");
        throw new SkipException("Skipped due to downtime");

    }

}
