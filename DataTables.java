package SeleniumPkg;

import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Converter;

public class DataTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 60);
		
		//loading datatables
		driver.navigate().to("http://datatables.net");
		WebElement selectEntryEle = driver.findElement(By.xpath("//*[@name='example_length']"));
		Select selEntry=new Select(selectEntryEle);
		selEntry.selectByValue("50");
		List<WebElement> rowEle=driver.findElements(By.xpath("//table[@id='example']//tbody/tr"));
		int rows=rowEle.size();
		System.out.println("No of Rows:"+rows);
		
		for (int i=1;i<rows;i++)
			{
				WebElement ageEle=driver.findElement(By.xpath("//table[@id='example']//tbody/tr["+i+"]/td[4]"));
				String ageValue=ageEle.getText().trim();
				int age = Integer.parseInt(ageValue);
				int j=i+1;
				if (age>=50)
				{	
					WebElement nameEle=driver.findElement(By.xpath("//table[@id='example']//tbody/tr["+i+"]/td[1]"));
					nameEle.click();
					WebElement salEle = driver.findElement(By.xpath("//span[@class='dtr-data']"));
					String salary=salEle.getText().trim();
					String Sal=salary.replace(",", "");
					String salFinal=salary.replace("$","");
					int salDigit=Integer.parseInt(salFinal);
					if(salDigit>=200000)
					{
						nameEle.click();
						System.out.println("Name of Person - "+nameEle.getText().trim());
						nameEle.click();
					}
					
				}
			}
		driver.quit();
	}

}
