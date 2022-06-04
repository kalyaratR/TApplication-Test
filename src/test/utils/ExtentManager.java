package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

        protected ExtentReports extentReports;

        protected ExtentTest extentTest;

        // Used to create a .html file with given configurations
        public void createReports() {
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("TLA");
            spark.config().setReportName("TLA AppTest report");
            extentReports.attachReporter(spark);
        }

        // to close the report
        public void closeReport() {
            extentReports.flush();
        }
        // to create a test Report for each Test case
        public void createTestReport() {
            extentTest = extentReports.createTest("PHP Travels test");
            extentTest.assignAuthor("Kalyarat");
            extentTest.assignDevice("Windows11");
        }

        // to log a report message
        public void logMsg(String msg) {
            extentTest.info(msg);

        }

    }

