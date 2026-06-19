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
    <title>Simbora</title>
</head>
<body>
    <header>
        <%@ include file="../../components/menu.jsp" %>
    </header>
    <main>
        <section id="destinos">
            <div class="container text-center">
                <h2>Destinos</h2>
                <p>As melhores viagens você só encontra aqui</p>
                <div class="mt-3 mb-2">
                    <button class="btn btn-outline-light"
                        data-bs-toggle="modal"
                        data-bs-target="#modalDestino"
                        data-destino="">
                        🔍 Buscar outro destino
                    </button>
                </div>
                <div class="row justify-content-center mt-4">
                    <div class="col-md-5 mb-3">
                        <div class="card border-dark">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/imagens/presidente-dutra.jpg" alt="Presidente Dutra">
                            <div class="card-body">
                                <p class="card-text fw-bold">Presidente Dutra</p>
                                <p>Um dos destinos mais bonitos do Brasil, bastante procurado para férias e viagens.</p>
                                <button class="btn btn-success btn-sm"
                                    data-bs-toggle="modal"
                                    data-bs-target="#modalDestino"
                                    data-destino="Presidente Dutra">
                                    Escolher destino
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 mb-3">
                        <div class="card border-dark">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/imagens/konoha.jpg" alt="Konoha">
                            <div class="card-body">
                                <p class="card-text fw-bold">Konoha</p>
                                <p>Um dos destinos mais bonitos do Brasil, bastante procurado para férias e viagens.</p>
                                <button class="btn btn-success btn-sm"
                                    data-bs-toggle="modal"
                                    data-bs-target="#modalDestino"
                                    data-destino="Konoha">
                                    Escolher destino
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 mb-3">
                        <div class="card border-dark">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/imagens/pexels-marcin-gierbisz-1125212.jpg" alt="Paris">
                            <div class="card-body">
                                <p class="card-text fw-bold">Paris</p>
                                <p>Um dos destinos mais bonitos do mundo, bastante procurado para férias e viagens.</p>
                                <button class="btn btn-success btn-sm"
                                    data-bs-toggle="modal"
                                    data-bs-target="#modalDestino"
                                    data-destino="Paris">
                                    Escolher destino
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 mb-3">
                        <div class="card border-dark">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/imagens/pexels-michelle-guimarães-3648269.jpg" alt="Rio de Janeiro">
                            <div class="card-body">
                                <p class="card-text fw-bold">Rio de Janeiro</p>
                                <p>Um dos destinos mais bonitos do Brasil, bastante procurado para férias e viagens.</p>
                                <button class="btn btn-success btn-sm"
                                    data-bs-toggle="modal"
                                    data-bs-target="#modalDestino"
                                    data-destino="Rio de Janeiro">
                                    Escolher destino
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <!-- Modal -->
    <div class="modal fade" id="modalDestino" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Reservar Passagem</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="${pageContext.request.contextPath}/destino-cadastrar" method="post">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">De onde você está saindo?</label>
                            <input type="text" class="form-control" name="saida" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Para onde você vai?</label>
                            <input type="text" class="form-control" name="destino" id="inputDestino" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Data</label>
                            <input type="date" class="form-control" name="data" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Passageiros</label>
                            <input type="number" class="form-control" name="Passageiros" min="1" value="1" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-success">Buscar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@ include file="../../components/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        const modalDestino = document.getElementById('modalDestino');
        modalDestino.addEventListener('show.bs.modal', function(event) {
            const btn = event.relatedTarget;
            document.getElementById('inputDestino').value = btn.getAttribute('data-destino');
        });
    </script>
</body>
</html>