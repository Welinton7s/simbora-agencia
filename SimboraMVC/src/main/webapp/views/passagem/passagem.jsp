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
        <table class="table">
		<thead>
			<tr>
			<th>ID Cliente</th>
			<th>ID Destino</th>
			<th>Data Viagem</th>
			<th>Preço</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaPassagens}" var="passagem">
			<tr>
				<td>${passagem.idCliente}</td>
				<td>${passagem.idDestino}</td>
				<td>${passagem.dataViagem}</td>
				<td>${passagem.preco}</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
        
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