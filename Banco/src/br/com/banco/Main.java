package br.com.banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcao = 0;
        ArrayList<ContaBanco> contas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1-Abrir conta\n2-Exibir todas as contas\n3-Procurar conta");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    abrirConta(contas);
                    break;

                case 2:
                    exibirTodasAsContas(contas);
                    break;

                case 3:
                	procurarConta(contas);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }while (opcao != 0);
    }

    private static void abrirConta(ArrayList<ContaBanco> contas) {
        Scanner sc = new Scanner(System.in);
        ContaBanco contaBanco = new ContaBanco();

        System.out.println("Numero da conta:");
        int numConta = sc.nextInt();
        sc.nextLine();
        contaBanco.setNumConta(numConta);

        System.out.println("Dono da conta:");
        String dono = sc.nextLine();
        contaBanco.setDono(dono);

        System.out.println("Tipo da conta(CC/CP):");
        String tipo = sc.nextLine();
        contaBanco.setTipo(tipo);
        contaBanco.abrirConta(tipo);

        contas.add(contaBanco);
    }

    private static void exibirTodasAsContas(ArrayList<ContaBanco> contas) {
        for (ContaBanco contaBan : contas) {
            System.out.println("Nome: " + contaBan.getNumConta());
            System.out.println("Dono: " + contaBan.getDono());
            System.out.println("Tipo: " + contaBan.getTipo());
            System.out.println("Saldo: " + contaBan.getSaldo());
            System.out.println("Status: " + contaBan.isStatus());
            System.out.println();
        }
    }

    // Adicione mais métodos conforme necessário para outras funcionalidades
    private static void procurarConta(ArrayList<ContaBanco> contas) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o numero da conta:");
        int numConta = sc.nextInt();

        double valor = 0;

        for (ContaBanco contaBan : contas) {
            if (numConta == contaBan.getNumConta()) {
                System.out.println("Nome: " + contaBan.getNumConta());
                System.out.println("Dono: " + contaBan.getDono());
                System.out.println("Tipo: " + contaBan.getTipo());
                System.out.println("Saldo: " + contaBan.getSaldo());
                System.out.println("Status: " + contaBan.isStatus());
                System.out.println();

              
                int opcao = 0
                		; // Correção: Inicializar opcao dentro do loop

                do{
                	
                	System.out.println("O que deseja?\n1-Depositar\n2-Sacar\n3-Fechar conta\n4-Ver saldo");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o valor a ser depositado:");
                            valor = sc.nextDouble();
                            contaBan.depositar(valor);
                            break; // Adicionado para encerrar o case
                        case 2:
                            System.out.println("Digite o valor a ser sacado:");
                            valor = sc.nextDouble();
                            contaBan.sacar(valor);
                            break; // Adicionado para encerrar o case
                        case 3:
                            contaBan.fecharConta();
                            break; // Adicionado para encerrar o case
                        case 4:
                            System.out.println("Saldo: " + contaBan.getSaldo());
                            break; // Adicionado para encerrar o case
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break; // Adicionado para encerrar o default
                    }
                    }while (opcao != 0);
            }
        }
    }


}
