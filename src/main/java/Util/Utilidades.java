package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilidades {
	public static WebDriver driver;
	
	public static void openUrl() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://coltefinancierabanks.qa3.todo1.com/");
		driver.manage().window().maximize();
	}
	
	//Función para identificar si el elemento está presente
	public static boolean isElementPresent(WebElement webElement){
        try{
            driver.findElement((By) webElement);
            return true;
        }
        catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
	
	public static WebElement el(By by) {
		return driver.findElement((By) by);
	}
	
	public static List<WebElement> els(By by) {
		return driver.findElements((By) by);
	}
	
	//Función de espera fija
	public static void wt(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Función para esperar un elemento
	public static void waitForElement(By by, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(by),
				ExpectedConditions.elementToBeSelected(by), 
					ExpectedConditions.presenceOfNestedElementLocatedBy(by, null)));
	}
	
	//Función para esperar un elemento visible
	public static void waitIfElementVisible(By by , long timeOutInSeconds) throws InterruptedException {
		long i = 1;
		long iTime = 1;

		while (els(by).size() >= 1) {
			
			if(el(by).isDisplayed()){
				wt(i * 1000);
				iTime++;
				
				if (iTime > timeOutInSeconds) {
					throw new InterruptedException("Time Exception");
				}
			}			
		}
	}
		
	public static void cerrarExplorador() {
		driver.close();
	}
	
	public static void cerrarProceso() {
		driver.quit();
	}
	
	public static void type(By by, String str) {
		el(by).sendKeys(str);
	}
	
	public static void click(By by) {
		el(by).click();
	}
	
	public static void clearElement(By by) {
		el(by).clear();
	}
	
	public static String getText(By by) {
		return el(by).getText();
	}

	public static void select(By by, String str) {
		Select objSelect = new Select(el(by));
		objSelect.selectByVisibleText(str);
	}	
	
	public static void selectByValue(By by, String str) {
		Select objSelect = new Select(el(by));
		objSelect.selectByValue(str);
	}
	
	public static void pageDown() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
	}
	
	public static void enter() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}
	
	//Función para retornar la fecha en el formato YYYYMMDD hhmmss
	public static String getDateYYYYMMDDHHMMSS() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	

}
