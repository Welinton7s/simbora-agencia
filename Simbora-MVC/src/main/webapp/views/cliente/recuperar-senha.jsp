<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <title>Simbora - Recuperar Senha</title>
</head>
<body>
    <header>
        <%@ include file="../../components/menu.jsp" %>
    </header>
    <main>
        <section id="login">
            <div class="container">
                <div class="d-flex flex-column justify-content-center align-items-center text-center">
                    <h2>Recuperar Senha</h2>
                    <% String sucesso = (String) request.getAttribute("mensagemSucesso");
                       if (sucesso != null) { %>
                        <div class="alert alert-success mt-2" style="width: 20rem;">
                            <%= sucesso %>
                        </div>
                    <% } %>
                    <% String erro = (String) request.getAttribute("mensagemErro");
                       if (erro != null) { %>
                        <div class="alert alert-danger mt-2" style="width: 20rem;">
                            <%= erro %>
                        </div>
                    <% } %>
                    <form action="${pageContext.request.contextPath}/recuperar-senha" method="post" class="card mx-auto">
                        <div class="form-group card-body d-flex flex-column align-items-center">
                            <p class="text-white mb-3">Digite seu e-mail cadastrado e enviaremos as instruções para redefinir sua senha.</p>
                            <label for="email">Email</label>
                            <input id="email" name="email" type="email" required class="form-control">
                            <button class="btn btn-success mt-2">Enviar</button>
                            <a href="${pageContext.request.contextPath}/views/cliente/login.jsp" class="btn-novaSenha">Voltar ao login</a>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </main>
   <%@ include file="../../components/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>