package Login;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TESTCASES {

	WebDriver driver = new ChromeDriver();
	String TheURL = "https://automationteststore.com/";
	String SignUpPage = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();

	String TheUserName;
	String ThePassword = "R569823";

	@BeforeTest

	public void MySetUp() {

		driver.get(TheURL);
		driver.manage().window().maximize();

	};

	@Test(enabled = true)

	public void signup() throws InterruptedException {

		driver.navigate().to(SignUpPage);

		// Element

		WebElement FirstNameInput = driver.findElement(By.xpath("//input[@id='AccountFrm_firstname']"));
		WebElement LastNameInput = driver.findElement(By.xpath("//input[@id='AccountFrm_lastname']"));
		WebElement EmailInput = driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
		WebElement TelephoneInput = driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']"));
		WebElement FaxInput = driver.findElement(By.xpath("//input[@id='AccountFrm_fax']"));
		WebElement CompanyInput = driver.findElement(By.xpath("//input[@id='AccountFrm_company']"));
		WebElement Address1Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
		WebElement Address2Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']"));
		WebElement CityInput = driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));
		WebElement PostalCodeInput = driver.findElement(By.xpath("//input[@id='AccountFrm_postcode']"));
		WebElement LoginInput = driver.findElement(By.xpath("//input[@id='AccountFrm_loginname']"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordInputconfirm = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement AgreeBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		WebElement CountySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateSelect = driver.findElement(By.id("AccountFrm_zone_id"));

		// Data
		String[] FirstNames = { "Randah", "rania", "rojaina", "sonia" };
		int RandomIndexForFirstNames = rand.nextInt(FirstNames.length);
		String RandomFirstNames = FirstNames[RandomIndexForFirstNames];

		String[] LastNames = { "mohammad", "moath" };
		int RandomIndexForLastNames = rand.nextInt(LastNames.length);
		String RandomLastNames = LastNames[RandomIndexForLastNames];

		int RandomNumberForTheEmail = rand.nextInt(7000);
		String Email = RandomFirstNames + RandomLastNames + RandomNumberForTheEmail + "@gmail.com";
		String Telphone = "079557437";
		String Fax = "1245";
		String Company = "css";
		String Address1 = "mecca1";
		String Address2 = "mecca2";
		String City = "Amman";

		// Actions

		TheUserName = RandomFirstNames + RandomLastNames + RandomNumberForTheEmail;

		FirstNameInput.sendKeys(RandomFirstNames);
		LastNameInput.sendKeys(RandomLastNames);
		EmailInput.sendKeys(Email);
		TelephoneInput.sendKeys(Telphone);
		FaxInput.sendKeys(Fax);
		CompanyInput.sendKeys(Company);
		Address1Input.sendKeys(Address1);
		Address2Input.sendKeys(Address2);
		CityInput.sendKeys(City);

		Select MySelectCountries = new Select(CountySelect);
		int AllCountries = CountySelect.findElements(By.tagName("option")).size();
		int RandomCountries = rand.nextInt(1, AllCountries);
		MySelectCountries.selectByIndex(RandomCountries);
		// MySelectCountries.selectByVisibleText("Spain");

		Thread.sleep(3000);

		int NumberOfOptions = StateSelect.findElements(By.tagName("option")).size();
		Select MySelectForState = new Select(StateSelect);
		int RandomStateindex = rand.nextInt(1, NumberOfOptions);
		MySelectForState.selectByIndex(RandomStateindex);

//		Select MySelectForState = new Select (StateSelect);
//		int RandomStateindex= rand.nextInt(1,NumberOfOptions);
//		MySelectForState.selectByIndex(RandomStateindex);
//		MySelectForState.selectByValue("1705");

		Thread.sleep(1000);
		System.out.println(NumberOfOptions);
		PostalCodeInput.sendKeys("5555");
		LoginInput.sendKeys(TheUserName);
		PasswordInput.sendKeys(ThePassword);
		PasswordInputconfirm.sendKeys(ThePassword);
		AgreeBox.click();
		ContinueButton.click();

		Thread.sleep(3000);

	};

	@Test(priority = 2, enabled = true)

	public void LogOut() throws InterruptedException {

		WebElement LogOut = driver.findElement(By.linkText("Logoff"));
		LogOut.click();

		Thread.sleep(1000);
		WebElement ContinueButton = driver.findElement(By.linkText("Continue"));
		ContinueButton.click();

	}

	@Test(priority = 3, enabled = true)

	public void Login() {

		WebElement LoginButton = driver.findElement(By.partialLinkText("Login"));
		LoginButton.click();

		WebElement LoginNameInput = driver.findElement(By.id("loginFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("loginFrm_password"));
		LoginNameInput.sendKeys(TheUserName);
		PasswordInput.sendKeys(ThePassword);

		WebElement LoginName = driver.findElement(By.xpath("//button[@title='Login']"));
		LoginName.click();

	};

	@Test(priority = 4,invocationCount = 1)

	public void AddToCart() throws InterruptedException {

		driver.navigate().to("https://automationteststore.com/");

		Thread.sleep(1000);
		
		List<WebElement> ListOfItems = driver.findElements(By.className("prdocutname"));
		int TotalNumberOfItems = ListOfItems.size();
		int RandomNumberOfList = rand.nextInt(2);
//		int RandomNumberOfList = rand.nextInt(TotalNumberOfItems);
		ListOfItems.get(RandomNumberOfList).click();
		if(driver.getPageSource().contains("Out of Stock")) {
			driver.navigate().back();
			System.out.println("the item not found");
			
			
		}else {
			System.out.println("the item is available");

		}

	
		
		

	};

}
