package SeleniumPkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class moneyControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 60);
		
		//loading moneycontrol
		driver.navigate().to("https://www.moneycontrol.com");
		
		WebElement stocksEle=driver.findElement(By.xpath("(//a[@title='Stocks'])[1]"));
		stocksEle.click();
		WebElement pageAEle= driver.findElement(By.xpath("(//a[@title='A'])[1]"));
		pageAEle.click();
		
		List<WebElement> linkEle=driver.findElements(By.tagName("a"));
		int noOfLinks=linkEle.size();
		System.out.println(noOfLinks);
		
		for(int i=0;i<noOfLinks;i++)
		{
			String link=((WebElement) linkEle).getAttribute("href");
			System.out.println(link);
			
			String text= ((WebElement) linkEle).getText();
			System.out.println(text);
		}
	}

}
