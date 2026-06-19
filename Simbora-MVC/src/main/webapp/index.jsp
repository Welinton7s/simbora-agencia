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
        <%@ include file="components/menu.jsp" %>
    </header>
    <main>
        <section id="home">
            <div class="container">
                <div class="d-flex flex-column align-items-center text-center text-white">
                    <h1>Economize muito com as melhores ofertas de viagens</h1>
                    <p>Aqui você pode agendar um dia e horário com um agente de viagem especializado</p>
                </div>
                <div class="card mx-auto d-flex" style="width: 20rem; background-color: transparent;">
					 <div class="login card-body d-flex flex-column align-items-center" style="background-color: #242424 !important; border: 0.10rem solid #828282; border-radius: 0.5rem;">
					    <h2 style="color: #fff;">Acessar</h2>
					    <p style="color: #fff;">"Entre no Mundo de Aventuras! Faça login na sua conta e comece a jornada dos seus sonhos." 😊</p>
					    <a href="${pageContext.request.contextPath}/views/cliente/login.jsp" class="btn btn-success">Acessar</a>
					</div>
					<div class="cadastrar card-body d-flex flex-column align-items-center" style="background-color: #242424 !important; border: 0.10rem solid #828282; border-radius: 0.5rem;">
					    <h2 style="color: #fff;">Cadastrar</h2>
					    <p style="color: #fff;">"Descubra o Mundo, Comece Aqui! Cadastre-se na nossa agência de viagens e embarque na viagem dos seus sonhos." 😊</p>
					    <a href="${pageContext.request.contextPath}/views/cliente/cadastro.jsp" class="btn btn-success">Cadastra-se</a>
					</div>
                </div>
            </div>
        </section>
    </main>
    <%@ include file="../components/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>