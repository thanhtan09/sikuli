import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.api.*;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class api {

	protected WebDriver driver;

	@BeforeMethod
	public void start() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://google.com/");
		Thread.sleep(10);
		driver.manage().window().maximize();
	}

	@Test
	public void Test() throws  IOException, InterruptedException{

		ScreenRegion s = new DesktopScreenRegion();
		Target target1 = new ImageTarget(new File("imgs","sign-in.png").getAbsoluteFile());
		Target target2 = new ImageTarget(new File("imgs/txt-email.png"));
		ScreenRegion r = s.find(target1);
		
		Canvas canvas = new DesktopCanvas();
		
		canvas.addBox(r);
		canvas.addLabel(r, "Ta đây rồi");
		canvas.display(3);
		if(r == null){
			System.out.print("Cannot find"+r);
		} else {
			Mouse mouse = new DesktopMouse();
			mouse.click(r.getCenter());
			
			Thread.sleep(5000);
			
			r = s.find(target2);
			mouse.doubleClick(r.getCenter());
			//mouse.click(r.getCenter());
			
			Thread.sleep(3000);
			Keyboard keyboard = new DesktopKeyboard();
			keyboard.type("abc");
		}
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
