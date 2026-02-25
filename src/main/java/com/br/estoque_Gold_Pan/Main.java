package com.br.estoque_Gold_Pan;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        EstoqueService estoqueService = new EstoqueService();
        int opcao = 1;

        do {
            System.out.println("\n ========== Sistema de Estoque ============");
            System.out.println("1 - Cadastrar Materia-Prima");
            System.out.println("2 - Adicionar Estoque");
            System.out.println("3 - Remover Estoque");
            System.out.println("4 - Mostrar Estoque");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            scanner.nextLine(); //Limpar buffer

            switch (opcao) {

                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Fornecedor: ");
                    String fornecedor = scanner.nextLine();

                    System.out.println("Unidade de medida: ");
                    System.out.println("1 - Kg");
                    System.out.println("2 - Unidade");
                    System.out.println("3 - Litros");

                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    UnidadeMedida unidade;

                    if (tipo == 1) {
                        unidade = UnidadeMedida.Kg;
                    } else if (tipo == 2) {
                        unidade = UnidadeMedida.Unidade;
                    } else {
                        unidade = UnidadeMedida.Litro;
                    }
                    MateriaPrima mp = new MateriaPrima(nome, unidade, fornecedor);
                    estoqueService.adicionarMateriaPrima(mp);

                    System.out.println("Matéria-Prima cadastrada com sucesso!");
                    break;


                case 2:
                    if (estoqueService.listarMateriasPrimas().isEmpty()) {
                        System.out.println("Nenhuma matéria-prima cadastrada");
                        break;
                    }
                    int contador = 0;

                    for (MateriaPrima materia : estoqueService.listarMateriasPrimas()) {
                        System.out.println(contador + " - " + materia.getNome());
                        contador++;
                    }

                    System.out.println("Digite o número da Matéria-Prima: ");
                    int indice = scanner.nextInt();

                    if (indice < 0 || indice >= estoqueService.listarMateriasPrimas().size()) {
                        System.out.println("Índice Inválido. ");
                        break;
                    }
                    MateriaPrima mpSelecionada = estoqueService.listarMateriasPrimas().get(indice);

                    System.out.println("Quantidade a Adicionar: ");
                    double quantidade = scanner.nextDouble();

                    estoqueService.registraEntrada(mpSelecionada, quantidade);

                    System.out.println("Entrada registrada com sucesso.");

                    break;

                case 3:
                    break;

                case 4:
                    if (estoqueService.listarMateriasPrimas().isEmpty()) {
                        System.out.println("Nenhuma matéria-prima cadastrada.");
                        break;
                    }

                    System.out.println("\n===== ESTOQUE ATUAL =====");

                    for (MateriaPrima materia : estoqueService.listarMateriasPrimas()) {
                        System.out.println(materia.exibirEstoque());
                    }

                    break;

                case 0:
                    System.out.println("Encerrando Sistema...");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        }while (opcao != 0);

    }
}
