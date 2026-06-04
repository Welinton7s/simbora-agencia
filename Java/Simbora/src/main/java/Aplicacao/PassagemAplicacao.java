package Aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import controller.ClienteDao;
import controller.DestinoDao;
import controller.PassagemDao;
import model.Cliente;
import model.Destino;
import model.Passagem;

public class PassagemAplicacao {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simbora", "root", "zero0034");

            ClienteDao clienteDao = new ClienteDao(connection);
            DestinoDao destinoDao = new DestinoDao(connection);
            PassagemDao passagemDao = new PassagemDao(connection);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o nome do cliente:");
            String nomeCliente = scanner.nextLine();

            Cliente cliente = clienteDao.getClientePeloNome(nomeCliente);
            if (cliente == null) {
                System.out.println("Cliente não encontrado.");
                return;
            }

            System.out.println("Nome do cliente: " + cliente.getNome());

            System.out.println("Você já escolheu um destino? (sim/não)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println("Digite o destino:");
                String nomeDestino = scanner.nextLine();

                Destino destino = destinoDao.getDestinoPeloNome(nomeDestino);
                if (destino == null) {
                    System.out.println("Destino não encontrado.");
                    return;
                }

                Random random = new Random();
                double preco = 100 + (5000 - 100) * random.nextDouble();

                System.out.println("Preço da passagem: " + preco);

                Passagem passagem = new Passagem(0, cliente, destino, destino.getData(), preco);

                passagemDao.salvar(passagem);

                System.out.println("Passagem salva com sucesso!");
                System.out.println("Data da viagem: " + destino.getData());
            } else {
                System.out.println("Por favor, escolha um destino primeiro.");
            }

            System.out.println("Você gostaria de alterar ou excluir uma passagem? (alterar/excluir/não)");
            resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("alterar")) {
                System.out.println("Digite o ID da passagem que você gostaria de alterar:");
                int idPassagem = scanner.nextInt();
                scanner.nextLine(); // consome a linha restante

                Passagem passagem = passagemDao.getPassagem(idPassagem);
                if (passagem == null) {
                    System.out.println("Passagem não encontrada.");
                    return;
                }

                System.out.println("Digite o novo destino:");
                String nomeDestino = scanner.nextLine();

                Destino destino = destinoDao.getDestinoPeloNome(nomeDestino);
                if (destino == null) {
                    System.out.println("Destino não encontrado.");
                    return;
                }

                passagem.setDestino(destino);

                passagemDao.altera(passagem);

                System.out.println("Passagem alterada com sucesso!");
            } else if (resposta.equalsIgnoreCase("excluir")) {
                System.out.println("Digite o ID da passagem que você gostaria de excluir:");
                int idPassagem = scanner.nextInt();

                passagemDao.exclui(idPassagem);

                System.out.println("Passagem excluída com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}