<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Cliente" %>
<%
Cliente clienteLogado = (Cliente) session.getAttribute("clienteLogado");
if (clienteLogado == null) {
    response.sendRedirect(request.getContextPath() + "/views/cliente/login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <title>Simbora - Meu Perfil</title>
</head>
<body>
    <header>
        <%@ include file="../../components/menu.jsp" %>
    </header>
    <main>
        <section id="login">
            <div class="container">
                <div class="d-flex flex-column justify-content-center align-items-center text-center">
                    <h2>Meu Perfil</h2>
                    <% String sucesso = (String) request.getAttribute("mensagemSucesso");
                       if (sucesso != null) { %>
                        <div class="alert alert-success mt-2 w-100" style="max-width: 22rem;">
                            <%= sucesso %>
                        </div>
                    <% } %>
                    <% String erro = (String) request.getAttribute("mensagemErro");
                       if (erro != null) { %>
                        <div class="alert alert-danger mt-2 w-100" style="max-width: 22rem;">
                            <%= erro %>
                        </div>
                    <% } %>
                    <form action="${pageContext.request.contextPath}/perfil-atualizar" method="post" class="card mx-auto w-100" style="max-width: 22rem;">
                        <div class="form-group card-body d-flex flex-column align-items-center">
                            <label for="nome">Nome</label>
                            <input id="nome" name="nome" type="text" class="form-control" value="<%= clienteLogado.getNome() %>" required>
                            <label for="email">Email</label>
                            <input id="email" name="email" type="email" class="form-control" value="<%= clienteLogado.getEmail() %>" required>
                            <label for="telefone">Telefone</label>
                            <input id="telefone" name="telefone" type="tel" class="form-control" value="<%= clienteLogado.getTelefone() %>">
                            <hr style="width: 100%;">
                            <p class="text-white mb-1">Alterar senha (opcional)</p>
                            <label for="senhaAtual">Senha Atual</label>
                            <input id="senhaAtual" name="senhaAtual" type="password" class="form-control">
                            <label for="novaSenha">Nova Senha</label>
                            <input id="novaSenha" name="novaSenha" type="password" class="form-control">
                            <button type="submit" class="btn btn-success mt-2">Salvar</button>
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