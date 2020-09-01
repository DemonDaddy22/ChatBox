package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.Model.ChatMessage;
import com.udacity.jwdnd.c1.review.Page.ChatPage;
import com.udacity.jwdnd.c1.review.Page.LoginPage;
import com.udacity.jwdnd.c1.review.Page.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	public int port;

	public static WebDriver driver;

	public String baseUrl;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeEach
	public void beforeEach() {
		baseUrl = "http://localhost:" + this.port;
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver = null;
	}

	@Test
	public void testReviewApp() throws InterruptedException {
		String username = "dwightS";
		String password = "sensei";
		String message = "I am Assistant Regional Manager";

		driver.get(this.baseUrl + "/signup");
		SignupPage signupPage = new SignupPage(driver);
		signupPage.registerUser("Dwight", "Schrute", username, password);

//		Thread.sleep(1500);
		driver.get(this.baseUrl + "/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginUser(username, password);

//		Thread.sleep(1500);
		driver.get(this.baseUrl + "/chat");
		ChatPage chatPage = new ChatPage(driver);
		chatPage.sendMessage(message);

		ChatMessage sentMessage = chatPage.getFirstMessage(driver);

		assertEquals(username, sentMessage.getUsername());
		assertEquals(message, sentMessage.getMessage());
	}

}
