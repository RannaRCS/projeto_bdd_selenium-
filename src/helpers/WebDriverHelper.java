package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {

// função para retornar a configuração do navegador utilizado para os testes 
	public static WebDriver getInstance() {

		// definindo o local do drive para o chrome
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		// Abrindo o googlechrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;

	}

}
