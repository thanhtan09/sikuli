import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.element.ImageElement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class api {

	protected WebDriver driver;

	@BeforeMethod
	public void start() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://logigear.vn/");
		Thread.sleep(10);
	}

	@Test
	public void Test() throws  IOException, InterruptedException{

		ScreenRegion s = new DesktopScreenRegion();
		Target target = new ImageTarget(new File("src/new.PNG"));
		ScreenRegion r = s.find(target);
		
//		// Create a mouse object
//		Mouse mouse = new DesktopMouse();
//		// Use the mouse object to click on the center of the target region
//		mouse.click(r.getCenter());
		
//		Canvas canvas = new DesktopCanvas();
//		
//		canvas.addBox(r);
//		canvas.addLabel(r, "Tan Vo");
//		canvas.display(3);
		if(r == null){
			System.out.print("Cannot find"+r);
		} else {
			Mouse mouse = new DesktopMouse();
			mouse.click(r.getCenter());
		}
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
