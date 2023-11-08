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
        <%@ include file="../../components/menu.jsp" %>
    </header>
    <!--Fim do cabeçalho-->
    <main>
        <!--Inicio do destinos-->
        <section id="destinos">
            <div class="container text-center">
                <h2>Destinos</h2>
                <p>As melhores viagens você so encontra aqui</p>
                
                <div class="cards row justify-content-center">
                    <div class="d-flex flex-column justify-content-center align-items-center text-center">
                        <form action="destinoServlet" class="card mx-auto border border-dark border-3" style=" background-color: #f3f3f3; ">
						    <form action="destinoServlet" class="card mx-auto border border-dark border-3" style=" background-color: #f3f3f3; ">
							    <div class="form-group card-body d-flex flex-column align-items-center">
							        <label for="saida">De onde você está saindo?</label>
							        <input id="saida" name="saida" type="search" class="form-control" required>
							        <label for="destino">Para onde você vai?</label>
							        <input id="destino" name="destino" type="search" class="form-control" required>
							        <label for="data">Escolha as datas</label>
							        <input id="data" name="data" type="date" class="form-control" required>
							        <label for="Passageiros">Passageiros</label>
							        <input id="Passageiros" name="Passageiros" type="number" class="form-control" required><br>
							        <button class="btn btn-success">Buscar</button>
							    </div>
							</form>


                    </div>
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="../../imagens/presidente-dutra.jpg" alt="Card image cap">
                        <div class="card-body">
                          <p class="card-text">Presidente Dutra</p>
                          <p>A cidade mais cobiçada do Brasil é, certamente, um dos destinos mais bonitos em nosso país, bastante procurado para férias e viagens, é o tipo de lugar que você pode ir várias e várias vezes e sempre se impressionará com sua beleza.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="../../imagens/konoha.jpg" alt="Card image cap">
                        <div class="card-body">
                          <p class="card-text">Konoha</p>
                          <p>A cidade mais cobiçada do Brasil é, certamente, um dos destinos mais bonitos em nosso país, bastante procurado para férias e viagens, é o tipo de lugar que você pode ir várias e várias vezes e sempre se impressionará com sua beleza.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="../../imagens/pexels-marcin-gierbisz-1125212.jpg" alt="Card image cap">
                        <div class="card-body">
                          <p class="card-text">Paris</p>
                          <p>A cidade mais cobiçada do Brasil é, certamente, um dos destinos mais bonitos em nosso país, bastante procurado para férias e viagens, é o tipo de lugar que você pode ir várias e várias vezes e sempre se impressionará com sua beleza.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="../../imagens/pexels-michelle-guimarães-3648269.jpg" alt="Card image cap">
                        <div class="card-body">
                          <p class="card-text">Rio de Janeiro</p>
                          <p>A cidade mais cobiçada do Brasil é, certamente, um dos destinos mais bonitos em nosso país, bastante procurado para férias e viagens, é o tipo de lugar que você pode ir várias e várias vezes e sempre se impressionará com sua beleza.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--Fim do destinos-->
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