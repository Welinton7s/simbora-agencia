<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/style.css">
    <title>Simbora</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <!--Inicio do cabeçalho-->
    <header>
        <%@ include file="components/menu.jsp" %>
    </header>
    <!--Fim do cabeçalho-->
    <main>
        <!--Inicio do home-->
        <section id="home">
            <div class="container text-white">
                <div class="d-flex flex-column align-items-center text-center">
                    <h1>Economize muito com as melhores ofertas de viagens</h1>
                    <p>Aqui você pode agendar um dia e horário com um agente de viagem especializado</p>
                </div>
                <div class="card mx-auto d-flex" style="width: 20rem; background-color: transparent; ">
                    <div class="login card-body d-flex flex-column align-items-center border border-dark border-3">
                        <h2>Acessar</h2>
                        <p>“Entre no Mundo de Aventuras!  Faça login na sua conta e comece a jornada dos seus sonhos.” 😊</p>
                        <a href="views/cliente/login.jsp" class="btn btn-success">Acessar</a>
                    </div>
                    <div class="cadastrar card-body d-flex flex-column align-items-center border border-dark border-3">
                        <h2>Cadastrar</h2>
                        <p>“Descubra o Mundo, Comece Aqui!  Cadastre-se na nossa agência de viagens e embarque na viagem dos seus sonhos.” 😊</p>
                        <a href="views/cliente/cadastro.jsp" class="btn btn-success">Cadastra-se</a>
                    </div>
                </div>
            </div>
        </section>
        <!--Fim do home-->
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
