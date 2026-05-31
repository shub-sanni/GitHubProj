package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	private ConfigReader() {}		// private constructor to prevent object creation

	public static void initProperties() {
		try (FileInputStream fis = new FileInputStream("./src/test/resources/config.properties")) {
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load config file: " + e.getMessage());
		}
	}

	public static String getProperty(String key) {
		if (prop == null) {
			throw new IllegalStateException("Properties not initialized. Call initProperties() first.");
		}
		return prop.getProperty(key);
	}
}