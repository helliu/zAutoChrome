package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ut {

	public static void waitUntil(WebDriver driver, String expressaoJS) throws InterruptedException{
		ChromeDriver chromeDriver = (ChromeDriver)driver;
		expressaoJS = verificaReturnExpressaoJS(expressaoJS);
		
		boolean ok = false;
		
		while(!ok){
			Thread.sleep(500);
			
			ok = (boolean)chromeDriver.executeScript(expressaoJS);
		}
	}
	
	public static void waitAjax(WebDriver driver){
		try {
			Thread.sleep(500);
			waitUntil(driver, "jQuery.active == 0");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static String verificaReturnExpressaoJS(String expressaoJS) {
		if(!expressaoJS.startsWith("return "))
			expressaoJS =  "return " + expressaoJS;
		
		if(!expressaoJS.trim().endsWith(";"))
			expressaoJS += ";";
		
		return expressaoJS;
	}
}
