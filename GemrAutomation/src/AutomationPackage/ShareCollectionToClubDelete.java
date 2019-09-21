package AutomationPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShareCollectionToClubDelete {			
		
		public void StartAutomation() {
				
		long currentTime;
		long timePassed;
		long startTime;
		int seconds;
		int minutes;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZUser\\Desktop\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		WebDriverWait wait10 = new WebDriverWait(driver, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
		System.out.println("Starting Iteration.\n");
		startTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());	
		
		currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());						
		LogIn(driver);
		timePassed = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		seconds = (int)Math.round(timePassed - currentTime);		
		System.out.println("Log in completed in " + seconds + " seconds.\n");
		
		currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		CreateCollection(driver, wait10, js);
		timePassed = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		seconds = (int)Math.round(timePassed - currentTime);
		System.out.println("Create collection completed in " + seconds + " seconds.\n");
		
		currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		AddItemToCollection(driver, wait10, js);	
		timePassed = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		seconds = (int)Math.round(timePassed - currentTime);
		System.out.println("Adding item to collection completed in " + seconds + " seconds.\n");
		
		currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		NavigateToClubDeleteCollection(driver, wait10, js);
		timePassed = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		seconds = (int)Math.round(timePassed - currentTime);
		System.out.println("Navigating to club and deleting collection completed in " + seconds + " seconds.\n");
		
		currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		LogOutQuit(driver);
		timePassed = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		seconds = (int)Math.round(timePassed - currentTime);
		System.out.println("Log out completed in " + seconds + " seconds.\n");
		
		timePassed = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());	
		seconds = (int)Math.round(timePassed - startTime);
		
		if(seconds > 60) {
			
			minutes = seconds / 60;
			seconds = seconds % 60;
			
			System.out.printf("Iteration completed in %d:%d.\n", minutes, seconds);
			
		}else {
		
			System.out.println("Iteration completed in " + seconds + " seconds.\n");
		
		}	
		
}
		
	
	public static void LogIn(WebDriver driver) {
					
		driver.get("https://stage.qa.gemr.com");
		driver.manage().window().maximize();		
		driver.findElement(By.cssSelector("#landingNavBarContainer > div > div > ul > div > li.pointed.inline.landingLogIn")).click();		
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/div/div/div[2]/form/div/div[4]/div[1]/div[2]/input")).sendKeys("coreyzdude");
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/div/div/div[2]/form/div/div[4]/div[2]/div[2]/input")).sendKeys("Wormtown#722");
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/div/div/div[2]/form/div/div[4]/div[3]/button")).click();	
		
	}
	
	public static void CreateCollection(WebDriver driver, WebDriverWait wait10, JavascriptExecutor js) {
		
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user-status\"]/form/div[1]/div[3]/span")));
		
		driver.findElement(By.xpath("//*[@id=\"user-status\"]/form/div[1]/div[3]/span")).click();		
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/form/div/div[1]/input")).sendKeys("AutomatedTestCollection");
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/form/div/div[2]/textarea")).sendKeys("AutomatedDescription!!!!!");
		
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.className("x2ClubCheck-text")));
		
		WebElement clubCell = driver.findElement(By.className("x2ClubCheck-text"));
		js.executeScript("arguments[0].click()", clubCell);
				
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/form/div/div[5]/button")).click();
		
	}
	
	public static void AddItemToCollection(WebDriver driver, WebDriverWait wait10, JavascriptExecutor js){
		
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"grid-container\"]/div[1]/div[1]/div[2]/div[2]/a[2]")));	
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		
		driver.findElement(By.xpath("//*[@id=\"grid-container\"]/div[1]/div[1]/div[2]/div[2]/a[2]")).click();		
		
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#x2ProfileBody > div > div:nth-child(2) > div.flexStart.gridColumnContainer > div:nth-child(1) > div:nth-child(1) > div > div > div.margB15.posRel > h2")));		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		
		driver.findElement(By.cssSelector("#x2ProfileBody > div > div:nth-child(2) > div.flexStart.gridColumnContainer > div:nth-child(1) > div:nth-child(1) > div > div > div.margB15.posRel > h2")).click();		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");

		driver.findElement(By.className("ownerActionCog")).click();
		driver.findElement(By.xpath("//*[@id=\"base-detail-container\"]/div[2]/div[4]/ul/li[1]")).click();
		
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.className("wizDropdown")));
		
		Select addToCollection = new Select(driver.findElement(By.className("wizDropdown")));
		addToCollection.selectByVisibleText("AutomatedTestCollection");
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div[2]/div/div[2]/div/div[2]/div/div[2]/button[3]")).click();
		
		wait10.until(ExpectedConditions.elementToBeClickable(By.className("close-item")));
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");
		
		driver.findElement(By.className("close-item")).click();
			
	}
	
	public static void NavigateToClubDeleteCollection(WebDriver driver, WebDriverWait wait10, JavascriptExecutor js) {
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		
		driver.findElement(By.xpath("//*[@id=\"navbar-clubs\"]/a/li")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-clubs\"]/div/div[2]/div[1]/div[2]/a[1]/div[2]")).click();
		
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"club-tabs\"]/ul/li[2]/a")));
		
		driver.findElement(By.xpath("//*[@id=\"club-tabs\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"profileRightNew\"]/div/div[2]/ul/li[1]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			
		String ownedCollectionXpath = "//*[@id=\"profileRightNew\"]/div/div[4]/div[1]/div[1]/div[1]/div/div[2]";
		String ownedCollectionText = "//*[text()='AutomatedTestCollection']";
		elementExists(driver, ownedCollectionText, ownedCollectionXpath, js);
			
		driver.findElement(By.xpath("//*[@id=\"profileRightNew\"]/div/div[4]/div[1]/div[1]/div[1]/div/div/div[1]/h2")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		driver.findElement(By.className("ownerActionCog")).click();
		
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		
		driver.findElement(By.xpath("//*[@id=\"base-detail-container\"]/div[2]/div/ul/li[4]")).click();
		
		wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modals-container\"]/div[2]/div/div[2]/div/form/div/div[2]/div/select")));
		
		Select deleteCollection = new Select(driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div[2]/div/div[2]/div/form/div/div[2]/div/select")));
		deleteCollection.selectByVisibleText("default");
		driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div[2]/div/div[2]/div/form/div/div[5]/button[2]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		driver.findElement(By.cssSelector("#modals-container > div:nth-child(3) > div > div.v--modal-box.v--modal.v--dialog > div > div.x2ModalTitleBox > svg")).click();
		
		
		
	}
				
	public static void LogOutQuit(WebDriver driver){
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		driver.findElement(By.xpath("//*[@id=\"x2NavUserText\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"x2NavUserText\"]/ul/li[5]/a")).click();
		
		driver.close();
	}
	
	public static void elementExists(WebDriver driver, String elementText, String element, JavascriptExecutor js){
		
		Boolean tof = driver.findElements(By.xpath(elementText)).size() > 0;
		
		if(tof) {
			
			driver.findElement(By.xpath(element)).click();		
			
		}else {
						
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
			driver.navigate().refresh();
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
			
			elementExists(driver, elementText, element, js);
			
		}
			
			
		
		
	}
		
}