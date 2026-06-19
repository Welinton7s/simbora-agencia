<%@ page import="model.Cliente" %>
<%
Cliente clienteJaLogado = (Cliente) session.getAttribute("clienteLogado");
if (clienteJaLogado != null) {
    response.sendRedirect(request.getContextPath() + "/views/destino/destinos.jsp");
    return;
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <title>Simbora</title>
</head>
<body>
    <header>
        <%@ include file="../../components/menu.jsp" %>
    </header>
    <main>
        <section id="cadastro">
            <div class="container">
                <div class="d-flex flex-column justify-content-center align-items-center text-center">
                    <h2>Cadastro</h2>
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
                    <form id="formCadastro" action="${pageContext.request.contextPath}/usuario-create" method="post" class="card mx-auto border border-dark border-3" style="width: 20rem;">
                        <div class="form-group card-body d-flex flex-column align-items-center">
                            <label for="nome">Nome</label>
                            <input id="nome" name="nome" type="text" class="form-control" required>
                            <label for="email">Email</label>
                            <input id="email" name="email" type="email" class="form-control" required>
                            <label for="senha">Senha</label>
                            <input id="senha" name="senha" type="password" class="form-control" required>
                            <label for="confirmar-senha">Confirmar Senha</label>
                            <input id="confirmar-senha" type="password" class="form-control" required>
                            <div id="erroSenha" class="text-danger mt-1" style="display:none; font-size: 0.85rem;">
                                As senhas não coincidem.
                            </div>
                            <label for="telefone">Telefone</label>
                            <input id="telefone" name="telefone" type="tel" class="form-control" required>
                            <button type="submit" class="btn btn-success mt-2">Cadastrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </main>
    <%@ include file="../../components/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        document.getElementById('formCadastro').addEventListener('submit', function(e) {
            const senha = document.getElementById('senha').value;
            const confirmar = document.getElementById('confirmar-senha').value;
            const erro = document.getElementById('erroSenha');
            if (senha !== confirmar) {
                e.preventDefault();
                erro.style.display = 'block';
            } else {
                erro.style.display = 'none';
            }
        });
    </script>
</body>
</html>