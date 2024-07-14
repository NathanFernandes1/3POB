import br.edu.faeterj.Cliente;
import br.edu.faeterj.Processamento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Vou acessar banco mysql!");
        Scanner scanner = new Scanner(System.in);
        Processamento proc = null;

        try {
            proc = new Processamento();
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar o processamento: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir clientes de um arquivo");
            System.out.println("2. Listar todos os clientes");
            System.out.println("3. Atualizar cliente");
            System.out.println("4. Deletar cliente");
            System.out.println("5. Exibir um cliente por ID");
            System.out.println("6. Adicionar novo cliente");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o caminho do arquivo: ");
                    String arquivo = scanner.nextLine();
                    try {
                        ArrayList<Cliente> clientes = proc.lerClientesDeArquivo(arquivo);
                        proc.InsertBanco(clientes);
                        System.out.println("Clientes inseridos com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir clientes: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ArrayList<Cliente> clientes = proc.GetClientes();
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente.imprimeCliente());
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao listar clientes: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID do cliente a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha

                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    if (!novoNome.matches("[a-zA-Z ]+")) {
                        System.out.println("Nome inválido! Deve conter apenas letras.");
                        break;
                    }

                    System.out.print("Digite o novo CPF: ");
                    String novoCpf = scanner.nextLine();
                    if (!novoCpf.matches("\\d+")) {
                        System.out.println("CPF inválido! Deve conter apenas números.");
                        break;
                    }

                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();

                    System.out.print("Digite o novo endereço: ");
                    String novoEndereco = scanner.nextLine();
                    if (!novoEndereco.matches("[a-zA-Z ]+")) {
                        System.out.println("Endereço inválido! Deve conter apenas letras.");
                        break;
                    }

                    System.out.print("Digite o novo CEP: ");
                    String novoCep = scanner.nextLine();
                    if (!novoCep.matches("\\d+")) {
                        System.out.println("CEP inválido! Deve conter apenas números.");
                        break;
                    }

                    try {
                        Cliente clienteAtualizado = new Cliente(idAtualizar, novoNome, novoCpf, novoEmail, novoEndereco, novoCep);
                        proc.UpdateCliente(clienteAtualizado);
                        System.out.println("Cliente atualizado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao atualizar cliente: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do cliente a ser deletado: ");
                    int idDeletar = scanner.nextInt();
                    try {
                        proc.DeleteCliente(idDeletar);
                        System.out.println("Cliente deletado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao deletar cliente: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Digite o ID do cliente a ser exibido: ");
                    int idExibir = scanner.nextInt();
                    try {
                        Cliente cliente = proc.GetClienteById(idExibir);
                        if (cliente != null) {
                            System.out.println(cliente.imprimeCliente());
                        } else {
                            System.out.println("Cliente não encontrado!");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao exibir cliente: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    if (!nome.matches("[a-zA-Z ]+")) {
                        System.out.println("Nome inválido! Deve conter apenas letras.");
                        break;
                    }

                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    if (!cpf.matches("\\d+")) {
                        System.out.println("CPF inválido! Deve conter apenas números.");
                        break;
                    }

                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();

                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();
                    if (!endereco.matches("[a-zA-Z ]+")) {
                        System.out.println("Endereço inválido! Deve conter apenas letras.");
                        break;
                    }

                    System.out.print("Digite o CEP: ");
                    String cep = scanner.nextLine();
                    if (!cep.matches("\\d+")) {
                        System.out.println("CEP inválido! Deve conter apenas números.");
                        break;
                    }

                    try {
                        ArrayList<Cliente> novosClientes = new ArrayList<>();
                        Cliente novoCliente = new Cliente(0, nome, cpf, email, endereco, cep);
                        novosClientes.add(novoCliente);
                        proc.InsertBanco(novosClientes);
                        System.out.println("Novo cliente inserido com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir novo cliente: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
