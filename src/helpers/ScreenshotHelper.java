package helpers;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	// função para fazer o print das telas
	public static void print(WebDriver driver, String nome) {

		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File(nome + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}