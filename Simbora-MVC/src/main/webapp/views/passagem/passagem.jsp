<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/style.css">
    <title>Simbora</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
                    <th>Ações</th>
                </tr>
            </thead>
            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simbora", "root", "zero0034");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cliente, destino, passagem");
            %>
            <tbody>
                <% while(rs.next()) { %>
                    <tr>
                        <td><%= rs.getInt("id_cliente") %></td>
                        <td><%= rs.getInt("id_destino") %></td>
                        <td><%= rs.getDate("data_viagem") %></td>
                        <td><%= rs.getFloat("preco") %></td>
                        <td>
                            <button class="btn btn-primary edit-btn">Editar</button>
                            <button class="btn btn-danger delete-btn">Excluir</button>
                        </td>
                    </tr>
                <% } %>
            </tbody>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>Telefone</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <% rs.beforeFirst(); %>
                <% while(rs.next()) { %>
                    <tr>
                        <td><%= rs.getString("nome") %></td>
                        <td><%= rs.getString("email") %></td>
                        <td><%= rs.getString("senha") %></td>
                        <td><%= rs.getString("telefone") %></td>
                        <td>
                            <button class="btn btn-primary edit-btn">Editar</button>
                            <button class="btn btn-danger delete-btn">Excluir</button>
                        </td>
                    </tr>
                <% } %>
            </tbody>
            <%
                rs.close();
                stmt.close();
                con.close();
            %>
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
    <script>
        $(document).ready(function() {
            $('.edit-btn').click(function() {
                // Código para lidar com o evento de clique do botão editar
                alert('Botão editar clicado!');
            });

            $('.delete-btn').click(function() {
                // Código para lidar com o evento de clique do botão excluir
                alert('Botão excluir clicado!');
            });
        });
    </script>
</body>
</html>
