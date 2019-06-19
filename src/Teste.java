import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.WebDriverFactory;

public class Teste {

	@Test
	public void go() {		
		ChromeDriver driver = WebDriverFactory.criarChromeWebDriver();
		
		driver.get("http://www.google.com.br");
		
		try {
			Thread.sleep(10000);
			driver.close();
		} catch (InterruptedException e) {
			driver.close();
			e.printStackTrace();
		}
	}
}
