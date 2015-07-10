import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo {

	protected WebDriver driver;

	@BeforeMethod
	public void start() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://logigear.vn/");
		driver.manage().window().maximize();
		Thread.sleep(10);
	}

	@Test
	public void Test() throws FindFailed {

		Screen screen = new Screen();
		Pattern pattern1 = new Pattern(new File("src","install.png").getAbsolutePath());
		
		screen.wait(pattern1, 10);
		screen.click(pattern1);
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
