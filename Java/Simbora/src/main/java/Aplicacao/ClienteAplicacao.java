package Aplicacao;


import java.sql.*;
import java.util.Scanner;

import model.Cliente;
import controller.ClienteDao;

public class ClienteAplicacao {
    public static void main(String[] args) {
        try {
            // Conecta ao banco de dados
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simbora", "root", "zero0034");

            // Cria um objeto ClienteDao
            ClienteDao clienteDao = new ClienteDao(connection);

            // Cria um objeto Scanner para ler a entrada do console
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite a operação (1-inserir, 2-alterar, 3-excluir):");
            String operacao = scanner.nextLine();


            switch (operacao) {
                case "1":
                	
                	System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o email do cliente:");
                    String email = scanner.nextLine();

                    System.out.println("Digite a senha do cliente:");
                    String senha = scanner.nextLine();

                    System.out.println("Digite o telefone do cliente:");
                    String telefone = scanner.nextLine();

                    // Cria um novo cliente com os dados inseridos
                    Cliente cliente = new Cliente(0, nome, email, senha, telefone);
                	
                    // Adiciona o cliente ao banco de dados
                    clienteDao.adiciona(cliente);
                    System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso!");
                    break;

                case "2":
                	
                	// Exibe a lista de clientes
                    System.out.println("Clientes:");
                    for (Cliente c : clienteDao.getClientes()) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome());
                    }
                	
                	// Altera o cliente
                    System.out.println("Digite o ID do cliente a ser alterado:");
                    int idParaAlterar = scanner.nextInt();
                    scanner.nextLine();  // consome a linha restante

                    System.out.println("Digite o nome do cliente:");
                    String nomeAlteradoString = scanner.nextLine();

                    System.out.println("Digite o email do cliente:");
                    String emailAlteradoString = scanner.nextLine();
                    
                    System.out.println("Digite a senha do cliente:");
                    String senhaAlterada = scanner.nextLine();
                    
                    System.out.println("Digite o telefone do cliente:");
                    String telefoneAlterado = scanner.nextLine();

                    Cliente clienteParaAlterar = new Cliente(0, nomeAlteradoString, emailAlteradoString, senhaAlterada, telefoneAlterado);
                    clienteParaAlterar.setId(idParaAlterar);
                    clienteDao.altera(clienteParaAlterar);
                    System.out.println("Cliente alterado com sucesso!");
                    
                 // Exibe a lista de clientes
                    System.out.println("Clientes:");
                    for (Cliente c : clienteDao.getClientes()) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome());
                    }
                    
                    break;
                    

                case "3":
                	
                	// Exibe a lista de clientes
                    System.out.println("Clientes:");
                    for (Cliente c : clienteDao.getClientes()) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome());
                    }
                	
                    // Exclui o cliente
                	System.out.println("Digite o ID do cliente a ser excluído:");
                    int idParaExcluir = scanner.nextInt();
                    
                    clienteDao.exclui(idParaExcluir);
                    System.out.println("Cliente excluído com sucesso!");
                    
                 // Exibe a lista de clientes
                    System.out.println("Clientes:");
                    for (Cliente c : clienteDao.getClientes()) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome());
                    }
                    
                    break;

                default:
                    System.out.println("Operação desconhecida");
            }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao conectar ao banco de dados");
            e.printStackTrace();
        }
    }
}