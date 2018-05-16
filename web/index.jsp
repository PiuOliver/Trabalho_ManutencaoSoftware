<%-- 
    Document   : login
    Created on : 16/05/2018, 00:57:48
    Author     : gabrieldeoliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<title>Tela De login</title>
</head>
<style>
	.position-vertical-center {
		height: 500px;
		-webkit-height: 500px;
		display: flex;
		display: -webkit-flex;
		align-items: center;
		-webkit-align-items: center;
	}
	
	.position-center {
		width: 100%;
		-webkit-width: 100%;
		display: flex;
		display: -webkit-flex;
		justify-content: center;
		-webkit-justify-content: center;
	}
</style>

<body>
	<div class="block">
		<div class="position-vertical-center">
			<div class="position-center"><b>Login:</b>
				<form method="post" action="LoginSistema">
                                    <center>
					<input type="text" name="login" value="" placeholder="Login:">
					<input type="password" name="senha" value="" placeholder="Senha:">
                                        <br><br>
                                        <input type="radio" name="perfil" value="Professor"/> Professor
                                        <input type="radio" name="perfil" value="Secretaria"/> Secretária
                                        <input type="radio" name="perfil" value="Aluno"/> Aluno
                                        <br><br>
                                        <button type="submit" name="acao" value="salvar">Entrar</button>
                                    </center>
				</form>
			</div>
		</div>
	</div>
</body>

</html>