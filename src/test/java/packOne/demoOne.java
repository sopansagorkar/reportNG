package packOne;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alm.cybage.utils.Driver;
import com.alm.cybage.utils.Excel;

public class demoOne extends Driver {

	@BeforeMethod

	public void beforeMethod() throws Exception {

		getDriver();
		driver.get("http://newtours.demoaut.com");

	}

	@Test(dataProvider = "Authentication")

	public void login_data(String sUserName, String sPassword) throws Exception {

		driver.findElement(By.name("userName")).sendKeys(sUserName);

		System.out.println(sUserName);

		driver.findElement(By.name("password")).sendKeys(sPassword);

		System.out.println(sPassword);

		driver.findElement(By.name("login")).click();

		driver.findElement(
				By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
		Assert.assertEquals("SIGN-ON",
				driver.findElement(
						By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"))
						.getText());

	}

	@DataProvider(name = "Authentication")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = Excel.getTableArray("src/test/resources/inputdata.xlsx", "Sheet1");

		return (testObjArray);

	}

	@AfterMethod

	public void afterMethod() {

		driver.close();

	}

}