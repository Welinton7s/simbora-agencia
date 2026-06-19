<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Cliente" %>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #242424;">
        <div class="container-fluid">
            <div class="navbar-brand d-flex align-items-center">
                <a href="${pageContext.request.contextPath}/index.jsp">SIMBORA</a>
                <img src="${pageContext.request.contextPath}/imagens/travel-6913775_1280.png" alt="Logo do Simbora" style="height: 40px; margin-left: 8px;">
            </div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse d-lg-flex justify-content-end" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/views/destino/destinos.jsp">Destinos</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/views/promocao/promocao.jsp">Promoções</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/views/contato/contato.jsp">Contato</a></li>
                    <%
                    Cliente menuCliente = (Cliente) session.getAttribute("clienteLogado");
                    if (menuCliente != null) {
                    %>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/passagem-listar">Minhas Passagens</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/perfil"><%= menuCliente.getNome() %></a></li>
                    <li class="nav-item"><a class="nav-link text-danger" href="${pageContext.request.contextPath}/logout">Sair</a></li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>
</div>