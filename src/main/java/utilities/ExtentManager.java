//package utilities;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentManager {
//
//private static ExtentReports extent;
//public static ExtentReports getExtent() {
//	if (extent == null) {
//		String reportPath= "target/ExtentReports.html";
//		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
//        spark.config().setReportName("UI Automation Report");
//        spark.config().setDocumentTitle("Automation Execution");
//		extent = new ExtentReports();
//		// You can add more configuration to the ExtentReports instance here
//	}
//	return extent;
//}
//}