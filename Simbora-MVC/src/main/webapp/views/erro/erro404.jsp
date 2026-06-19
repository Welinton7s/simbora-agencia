<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <title>Simbora - Página não encontrada</title>
</head>
<body>
    <header>
        <%@ include file="../../components/menu.jsp" %>
    </header>
    <main>
        <section id="home">
            <div class="container text-center text-white">
                <h1 style="font-size: 8rem;">404</h1>
                <h2>Página não encontrada</h2>
                <p>A página que você está procurando não existe ou foi removida.</p>
                <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-success mt-3">Voltar para o início</a>
            </div>
        </section>
    </main>
    <%@ include file="../../components/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>