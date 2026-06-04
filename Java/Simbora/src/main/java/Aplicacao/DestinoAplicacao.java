package Aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import controller.DestinoDao;
import model.Destino;

public class DestinoAplicacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Conecta ao banco de dados
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simbora", "root", "zero0034");

            DestinoDao destinoDao = new DestinoDao(connection);

            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir destino");
            System.out.println("2. Alterar destino");
            System.out.println("3. Excluir destino");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // consome a linha restante

            switch (opcao) {
                case 1:
                    // Cria um novo destino
                    System.out.println("Digite a partida:");
                    String partida = scanner.nextLine();

                    System.out.println("Digite o destino:");
                    String destinoStr = scanner.nextLine();

                    System.out.println("Digite a data (YYYY-MM-DD):");
                    String data = scanner.nextLine();

                    System.out.println("Digite a quantidade de passageiros:");
                    int quantidadeDePassageiros = scanner.nextInt();
                    scanner.nextLine();  // consome a linha restante

                    Destino destino = new Destino(partida, destinoStr, data, quantidadeDePassageiros);
                    destinoDao.adiciona(destino);
                    System.out.println("Destino adicionado com sucesso!");
                    break;
                case 2:
                	
                	// Exibe a lista de destinos
                    System.out.println("Destinos:");
                    for (Destino d : destinoDao.getDestinos()) {
                        System.out.println("ID: " + d.getId() + ", Destino: " + d.getDestino());
                    }
                	
                    // Altera o destino
                    System.out.println("Digite o ID do destino a ser alterado:");
                    int idParaAlterar = scanner.nextInt();
                    scanner.nextLine();  // consome a linha restante

                    System.out.println("Digite a nova partida:");
                    String novaPartida = scanner.nextLine();

                    System.out.println("Digite o novo destino:");
                    String novoDestino = scanner.nextLine();
                    
                    System.out.println("Digite a data (YYYY-MM-DD):");
                    String novaData = scanner.nextLine();
                    
                    System.out.println("Digite a quantidade de passageiros:");
                    int novaQtdDePassageiros = scanner.nextInt();

                    Destino destinoParaAlterar = new Destino(novaPartida, novoDestino, novaData, novaQtdDePassageiros);
                    destinoParaAlterar.setId(idParaAlterar);
                    destinoDao.altera(destinoParaAlterar);
                    System.out.println("Destino alterado com sucesso!");
                    
                 // Exibe a lista de destinos
                    System.out.println("Destinos:");
                    for (Destino d : destinoDao.getDestinos()) {
                        System.out.println("ID: " + d.getId() + ", Destino: " + d.getDestino());
                    }
                    
                    break;
                case 3:
                	
                	// Exibe a lista de destinos
                    System.out.println("Destinos:");
                    for (Destino d : destinoDao.getDestinos()) {
                        System.out.println("ID: " + d.getId() + ", Destino: " + d.getDestino());
                    }
                	
                    // Exclui o destino
                    System.out.println("Digite o ID do destino a ser excluído:");
                    int idParaExcluir = scanner.nextInt();
                    
                    destinoDao.exclui(idParaExcluir);
                    System.out.println("Destino excluído com sucesso!");
                    
                 // Exibe a lista de destinos
                    System.out.println("Destinos:");
                    for (Destino d : destinoDao.getDestinos()) {
                        System.out.println("ID: " + d.getId() + ", Destino: " + d.getDestino());
                    }
                    
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          scanner.close();
        }
    }
}