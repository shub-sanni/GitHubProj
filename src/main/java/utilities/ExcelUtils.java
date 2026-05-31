//package utilities;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileInputStream;
//import java.util.*;
//
//public class ExcelUtils {
//
//    private static Map<String, String> loginData = new HashMap<>();
//
//    public static void loadLoginData(String path) {
//        try (FileInputStream fis = new FileInputStream(path);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet("Login");
//            Row row = sheet.getRow(1); // First data row (skip header)
//
//            loginData.put("user", row.getCell(0).getStringCellValue());
//            loginData.put("pwd", row.getCell(1).getStringCellValue());
//
//        } catch (Exception e) {
//            throw new RuntimeException("Error loading Excel login data: " + e.getMessage());
//        }
//    }
//
//    public static String get(String key) {
//        return loginData.get(key);
//    }
//}
