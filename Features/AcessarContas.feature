#encoding: ISO-8859-1

Feature: Acessar Conta
	Como um usuário cadastrado no sistema
	Eu quero acessar minha conta
	De modo que eu possa autenticar no sistema
	
Scenario: Acessar conta com sucesso
	Autenticação de usuário bem sucedida
	
	Given Acessar a página de autenticação de conta de usuário
	And Informar o email do usuário
	And Informar a senha do usuário
	When Solicitar a realização do acesso
	Then Sistema autentica o usuário com sucesso
	
Scenario: Acesso negado
	Acesso não autorizado de usuário
	
	Given Acessar a página de autenticação de conta de usuário
	And Informar um email de usuário inválido
	And Informar uma senha de usuário inválida
	When Solicitar a realização do acesso
	Then Sistema informa que o acesso é negado
	
Scenario: Campos obrigatórios para autenticação
	Validação dos campos do formulário de acesso
	
	Given Acessar a página de autenticação de conta de usuário
	And Preencher o email com valor vazio
	And Preencher a senha com valor vazio
	When Solicitar a realização do acesso
	When Sistema informa que email e senha são obrigatórios