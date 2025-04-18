package br.com.mangarosa;

import br.com.mangarosa.collections.ListaEncadeada;

import java.util.Scanner;

public class MangaSoundApplication {
    private static ListaEncadeada repositorioMusicas = new ListaEncadeada();
    private static ListaEncadeada listaReproducao = new ListaEncadeada();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarMusicaAoRepositorio(scanner);
                    break;
                case 2:
                    criarListaDeReproducao(scanner);
                    break;
                case 3:
                    editarListaDeReproducao(scanner);
                    break;
                case 4:
                    executarListaDeReproducao();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void adicionarMusicaAoRepositorio(Scanner scanner) {
        System.out.print("Título da música: ");
        String titulo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Duração: ");
        String duracao = scanner.nextLine();
        repositorioMusicas.append(titulo + " - " + artista + " (" + duracao + ")");
        System.out.println("Música adicionada ao repositório.");
    }

    private static void criarListaDeReproducao(Scanner scanner) {
        System.out.print("Nome da lista de reprodução: ");
        String nomeLista = scanner.nextLine();
        listaReproducao = new ListaEncadeada();
        System.out.println("Lista de reprodução criada: " + nomeLista);
    }

    private static void editarListaDeReproducao(Scanner scanner) {
        if (repositorioMusicas.isEmpty()) {
            System.out.println("Nenhuma música no repositório.");
            return;
        }

        System.out.println("Músicas disponíveis no repositório:");
        for (int i = 0; i < repositorioMusicas.size(); i++) {
            System.out.println(i + ": " + repositorioMusicas.get(i));
        }

        System.out.print("Escolha o índice da música para adicionar à lista de reprodução: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (indice >= 0 && indice < repositorioMusicas.size()) {
            listaReproducao.append(repositorioMusicas.get(indice));
            System.out.println("Música adicionada à lista de reprodução.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void executarListaDeReproducao() {
        if (listaReproducao.isEmpty()) {
            System.out.println("Lista de reprodução vazia.");
            return;
        }

        System.out.println("Executando lista de reprodução:");
        for (int i = 0; i < listaReproducao.size(); i++) {
            System.out.println(listaReproducao.get(i));
        }
    }
}
