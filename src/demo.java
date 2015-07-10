import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class demo {

	protected WebDriver driver;

	@BeforeMethod
	public void start() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://logigear.vn/");
		driver.manage().window().maximize();
		Thread.sleep(10);
	}

//	@Test
//	public void Test() throws FindFailed {
//
//		Screen screen = new Screen();
//		Pattern pattern1 = new Pattern(new File("src","install.png").getAbsolutePath());
//		
//		screen.wait(pattern1, 10);
//		screen.click(pattern1);
//	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
