<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Passagem" %>
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
    <title>Simbora - Minhas Passagens</title>
</head>
<body>
    <header>
        <%@ include file="../../components/menu.jsp" %>
    </header>
    <main>
        <section id="passagens" style="min-height: 90vh;">
            <div class="container text-center">
                <h2 class="pt-4 text-white">Minhas Passagens</h2>
                <div class="row justify-content-center mt-4">
                    <%
                    List<Passagem> lista = (List<Passagem>) request.getAttribute("listaPassagens");
                    if (lista == null || lista.isEmpty()) {
                    %>
                        <p class="text-white">Nenhuma passagem encontrada.</p>
                    <%
                    } else {
                        for (Passagem p : lista) {
                    %>
                        <div class="col-md-4 mb-3">
                            <div class="card border-dark shadow">
                                <div class="card-body text-center">
                                    <h5 class="card-title">✈ <%= p.getPartida() %> → <%= p.getDestino() %></h5>
                                    <hr>
                                    <p class="card-text"><strong>Data da viagem:</strong> <%= p.getDataViagem() %></p>
                                    <p class="card-text"><strong>Preço:</strong> R$ <%= String.format("%.2f", p.getPreco()) %></p>
                                    <div class="d-flex justify-content-center gap-2 mt-3">
                                        <button class="btn btn-primary btn-sm"
                                            data-bs-toggle="modal"
                                            data-bs-target="#modalEditar"
                                            data-id="<%= p.getId() %>"
                                            data-partida="<%= p.getPartida() %>"
                                            data-destino="<%= p.getDestino() %>"
                                            data-data="<%= p.getDataViagem() %>">
                                            Editar
                                        </button>
                                        <button class="btn btn-danger btn-sm"
                                            data-bs-toggle="modal"
                                            data-bs-target="#modalExcluir"
                                            data-id="<%= p.getId() %>"
                                            data-partida="<%= p.getPartida() %>"
                                            data-destino="<%= p.getDestino() %>">
                                            Excluir
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <%
                        }
                    }
                    %>
                </div>
            </div>
        </section>
    </main>

    <!-- Modal Editar -->
    <div class="modal fade" id="modalEditar" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Editar Passagem</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="${pageContext.request.contextPath}/passagem-editar" method="post">
                    <div class="modal-body">
                        <input type="hidden" name="id" id="editId">
                        <div class="mb-3">
                            <label class="form-label">Partida</label>
                            <input type="text" class="form-control" name="partida" id="editPartida" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Destino</label>
                            <input type="text" class="form-control" name="destino" id="editDestino" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Data da Viagem</label>
                            <input type="date" class="form-control" name="dataViagem" id="editData" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Modal Excluir -->
    <div class="modal fade" id="modalExcluir" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirmar Exclusão</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body text-center">
                    <p>Deseja excluir a passagem</p>
                    <strong id="infoExcluir"></strong>
                    <p class="text-danger mt-2">Esta ação não pode ser desfeita.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <a id="btnConfirmarExcluir" href="#" class="btn btn-danger">Excluir</a>
                </div>
            </div>
        </div>
    </div>
	<%@ include file="../../components/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        const modalEditar = document.getElementById('modalEditar');
        modalEditar.addEventListener('show.bs.modal', function(event) {
            const btn = event.relatedTarget;
            document.getElementById('editId').value = btn.getAttribute('data-id');
            document.getElementById('editPartida').value = btn.getAttribute('data-partida');
            document.getElementById('editDestino').value = btn.getAttribute('data-destino');
            document.getElementById('editData').value = btn.getAttribute('data-data');
        });

        const modalExcluir = document.getElementById('modalExcluir');
        modalExcluir.addEventListener('show.bs.modal', function(event) {
            const btn = event.relatedTarget;
            const id = btn.getAttribute('data-id');
            const partida = btn.getAttribute('data-partida');
            const destino = btn.getAttribute('data-destino');
            document.getElementById('infoExcluir').textContent = partida + ' → ' + destino;
            document.getElementById('btnConfirmarExcluir').href = '${pageContext.request.contextPath}/passagem-excluir?id=' + id;
        });
    </script>
</body>
</html>