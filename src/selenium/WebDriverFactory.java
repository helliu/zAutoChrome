package selenium;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
	
	private WebDriverFactory(){
		
	}
	public static ChromeDriver criarChromeWebDriver(){
		final String PROP_CHROME_DRIVER = "webdriver.chrome.driver";
		String pathChromeDriver = System.getProperty(PROP_CHROME_DRIVER);
		
		if(pathChromeDriver == null || !Files.exists(Paths.get(pathChromeDriver)) || Files.isDirectory(Paths.get(pathChromeDriver))){
			//seta caminho para desenvolvimento
			final String PATH_DRIVER_DESENV = getDriverPath();
			System.setProperty(PROP_CHROME_DRIVER, PATH_DRIVER_DESENV);
		}
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		return new ChromeDriver(options);
	}
	
	private static String getDriverPath() {
		ClassLoader loader = WebDriverFactory.class.getClassLoader();
		
		//get project folder
        URL url = loader.getResource("chromedriver.exe");
        
		try {
	        Path path = Paths.get(url.toURI());
	        
	        return path.toAbsolutePath().toString();
		} catch (URISyntaxException e) {
			throw new UnsupportedOperationException("chromedriver.exe not found.");
		}
	}
}
