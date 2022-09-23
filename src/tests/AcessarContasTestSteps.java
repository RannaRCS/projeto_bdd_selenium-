package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.ScreenshotHelper;
import helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AcessarContasTestSteps {

	WebDriver driver;

	@Given("Acessar a pÃ¡gina de autenticaÃ§Ã£o de conta de usuÃ¡rio")
	public void acessar_a_p_ã_gina_de_autentica_ã_ã£o_de_conta_de_usu_ã_rio() {

		driver = WebDriverHelper.getInstance();
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/Jmeter/Exercicio05");

	}

	@Given("Informar o email do usuÃ¡rio")
	public void informar_o_email_do_usu_ã_rio() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys("testador@gmail.com");
	}

	@Given("Informar a senha do usuÃ¡rio")
	public void informar_a_senha_do_usu_ã_rio() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear();
		element.sendKeys("@Teste2022");
	}

	@When("Solicitar a realizaÃ§Ã£o do acesso")
	public void solicitar_a_realiza_ã_ã£o_do_acesso() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"btn_acesso\"]"));

		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}

		else {
			fail("Botão de cadastro não habilitado.");
		}
	}

	@Then("Sistema autentica o usuÃ¡rio com sucesso")
	public void sistema_autentica_o_usu_ã_rio_com_sucesso() {

		String urlAtual = driver.getCurrentUrl();
		String urlEsperada = "http://sergiocontatos-001-site1.ftempurl.com/JMeter/AreaRestrita";

		assertEquals(urlEsperada, urlAtual);

		ScreenshotHelper.print(driver, "Acesso de Contas");

		driver.close();
		driver.quit();

	}

	@Given("Informar um email de usuÃ¡rio invÃ¡lido")
	public void informar_um_email_de_usu_ã_rio_inv_ã_lido() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys("emailinvalido@gmail.com");
	}

	@Given("Informar uma senha de usuÃ¡rio invÃ¡lida")
	public void informar_uma_senha_de_usu_ã_rio_inv_ã_lida() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear();
		element.sendKeys("@Senha123");
	}

	@Then("Sistema informa que o acesso Ã© negado")
	public void sistema_informa_que_o_acesso_ã_negado() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));

		String resultadoObtido = element.getText();
		String resultadoEsperado = "Acesso Negado";

		assertEquals(resultadoObtido, resultadoEsperado);

		ScreenshotHelper.print(driver, "Acesso invalido");

		driver.close();
		driver.quit();

	}

	@Given("Preencher o email com valor vazio")
	public void preencher_o_email_com_valor_vazio() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys("");
	}

	@Given("Preencher a senha com valor vazio")
	public void preencher_a_senha_com_valor_vazio() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear();
		element.sendKeys("");
	}

	@When("Sistema informa que email e senha sÃ£o obrigatÃ³rios")
	public void sistema_informa_que_email_e_senha_s_ã£o_obrigat_ã_rios() {
		WebElement erroEmail = driver
				.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div/div/div/form/div[1]/span"));
		WebElement erroSenha = driver
				.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div/div/div/form/div[2]/span"));

		String erroEmailObtido = erroEmail.getText();
		String erroEmailEsperado = "Por favor, informe o email.";

		String erroSenhalObtido = erroSenha.getText();
		String erroSenhaEsperado = "Por favor, informe a senha.";

		assertEquals(erroEmailObtido, erroEmailEsperado);
		assertEquals(erroSenhalObtido, erroSenhaEsperado);

		ScreenshotHelper.print(driver, "Email e senha obrigatório");

		driver.close();
		driver.quit();
	}

}
