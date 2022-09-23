
Feature: Esqueci minha senha
	Como um usuário cadastrado no sistema
	Eu quero recuperar minha senha de acesso
	De modo que eu possa autenticar no sistema
	
Scenario: Recuperação de senha com sucesso
	Recuperação de senha do usuário bem sucedida
	
	Given Acessar a página de recuperação de senha do usuário
	And Informar o email cadastrado do usuário
	When Solicitar a recuperação da senha
	Then Sistema informa que um email de recuperação de senha foi enviado com sucesso
	
Scenario: Email inválido para recuperação de senha
	Recuperação de senha não permitida pois o email é inválido
	
	Given Acessar a página de recuperação de senha do usuário
	And Informar um email inválido
	When Solicitar a recuperação da senha
	Then Sistema informa que o email é inválido para recuperação da senha
	
Scenario: Campos obrigatórios para recuperação da senha
	Validação dos campos do formulário de recuperação de senha
	
	Given Acessar a página de recuperação de senha do usuário
	And Preencher o email para recuperação da senha com valor vazio
	When Solicitar a recuperação da senha
	Then Sistema informa que o preenchimento do email é obrigatório
