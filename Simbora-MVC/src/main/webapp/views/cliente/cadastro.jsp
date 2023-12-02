<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/style.css">
    <title>Simbora</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <!--Inicio do cabeçalho-->
    <header>
    	<jsp:include page="../../components/menu.jsp">
		<jsp:param value="../cadastroServlet" name="cadastroServlet" />

	</jsp:include>
	    </header>
    <!--Fim do cabeçalho-->
    <main>
        <!--Inicio do cadastro-->
        <section id="cadastro">
            <div class="container">
                <div class="d-flex flex-column justify-content-center align-items-center text-center">
                    <h2>Cadastro</h2>
                    <form action="../../usuario-create" method="post" class="card mx-auto border border-dark border-3" style="width: 20rem; background-color: #f3f3f3; ">
					    <div class="form-group card-body d-flex flex-column align-items-center">
					        <label for="nome">Nome</label>
					        <input id="nome" name="nome" type="text" class="form-control" required>
					        <label for="email">Email</label>
					        <input id="email" name="email" type="email" class="form-control" required>
					        <label for="senha">Senha</label>
					        <input id="senha" name="senha" type="password" class="form-control" required>
					        <label for="telefone">Telefone</label>
					        <input id="telefone" name="telefone" type="tel" class="form-control" required>
					        <button type="submit" class="btn btn-success" <%=request.getParameter("cadastroServlet")%>>Cadastrar</button>
					    </div>
					</form>

                </div>
            </div>
        </section>
        <!--Fim do cadastro-->
    </main>
    <!--Inicio do rodapé-->
    <footer class="d-flex justify-content-center align-items-center text-center">
      <div class="container">
        <p>Feito com <span>❤</span> por Welinton</p>
      </div>
    </footer>
    <!--Fim do rodapé-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>