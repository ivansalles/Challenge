package test1;

import java.io.IOException;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Challenge1 {

	private static Scanner in;

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Starting Chalenge 1...");
		in = new Scanner(System.in);
		System.out.println("Username:");
		String username = in.nextLine();
		System.out.println("Password:");
		String pwd = in.nextLine();

		System.out.println("User: " + username + ", Password: " + pwd);

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("http://walmart.com.br/");
		driver.findElement(By.id("suggestion-search")).click();
		driver.findElement(By.id("suggestion-search")).clear();
		driver.findElement(By.id("suggestion-search")).sendKeys("tv");
		driver.findElement(By.cssSelector("button.search-icon")).click();
		
		String result = driver.findElement(By.className("result-items")).getText();
		System.out.println("Resultados:" + result);

		driver.findElement(By.cssSelector("span.product-title")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.id("navegaCarrinho")).click();
		driver.findElement(By.className("cart-icon")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-finalize-cart")).click();
		
		driver.switchTo().frame("iframeLogin");
		driver.findElement(By.id("signinField")).clear();
		driver.findElement(By.id("signinField")).sendKeys(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("signinButtonSend")).click();

		System.out.println("Completed..");
		
	}

}
