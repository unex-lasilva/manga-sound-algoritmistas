//Luan Felipe
// Andrey Ramos Ferraz
//
// Arthur Prates

import java.util.Scanner;

public class MangaSoundApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner para ler a entrada do usuário
        MangaController MangaController = new MangaController();  // Cria uma instância do controller que gerencia a aplicação
        int opcao;  // Variável para armazenar a opção escolhida pelo usuário

        // Exibe o menu para o usuário
        System.out.println("Manga Sound");
        System.out.println("1-Adicionar música ao Repositorio");
        System.out.println("2-Criar Lista de reprodução");
        System.out.println("3-Editar lista de Reprodução");
        System.out.println("4-Executar a lista de reprodução");
        System.out.println("5-Sair do aplicativo");

        // Solicita ao usuário que escolha uma opção
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();  // Lê a opção escolhida pelo usuário

        switch (opcao) {  // Dependendo da opção escolhida, executa a ação correspondente
            case 1:
                // Caso 1: Adicionar música ao repositório
                System.out.print("Título da música: ");
                String titulo = scanner.nextLine();  // Lê o título da música
                scanner.nextLine();  // Limpa o buffer
                System.out.print("Caminho do arquivo .wav: ");
                String caminho = scanner.nextLine();  // Lê o caminho do arquivo .wav
                System.out.print("Artista: ");
                String artista = scanner.nextLine();  // Lê o nome do artista
                // Chama o método do controller para adicionar a música ao repositório
                MangaController.adicionarMusica(titulo, caminho, artista);
                break;
            case 2:
                // Caso 2: Criar uma nova lista de reprodução
                System.out.print("Título da nova lista: ");
                scanner.nextLine();  // Consome a quebra de linha restante
                String tituloLista = scanner.nextLine();  // Lê o título da lista
                // Chama o método do controller para criar a lista de reprodução
                MangaController.criarListaDeReproducao(tituloLista);
                break;

            case 3:
                // Opção para editar a lista de reprodução
                System.out.print("1 - Adicionar música à lista\n2 - Remover música da lista\nEscolha: ");
                int editOpcao = scanner.nextInt();
                scanner.nextLine();  // Consome a quebra de linha
                System.out.print("Título da lista: ");
                String listaTitulo = scanner.nextLine();

                if (editOpcao == 1) {
                    System.out.print("Título da música a adicionar: ");
                    String musicaAdicionar = scanner.nextLine();
                    MangaController.adicionarMusicaListaDeReproducao(musicaAdicionar, listaTitulo);
                } else if (editOpcao == 2) {
                    System.out.print("Título da música a remover: ");
                    String musicaRemover = scanner.nextLine();
                    MangaController.removerMusicaDaListaDeReproducao(musicaRemover, listaTitulo);
                }
                break;
            case 4:
                // Caso 4: Executar a lista de reprodução
                System.out.print("Título da lista a executar: ");
                String execTitulo = scanner.nextLine();  // Lê o título da lista de reprodução a ser executada
                // Chama o método do controller para reproduzir a lista de reprodução
                MangaController.reproduzirListaDeReproducao(execTitulo);
                // Chama o método do controller para começar a execução da música
                MangaController.executarMusica();

                // Informa ao usuário para pressionar ENTER para parar a reprodução
                System.out.println("Pressione ENTER para parar a reprodução.");
                scanner.nextLine();  // Aguarda o usuário pressionar ENTER
                // Chama o método do controller para parar a reprodução
                MangaController.paraLista();
                break;
            case 0:
                // Caso 0: Sair do aplicativo
                System.out.println("Saindo...");
                scanner.close();  // Fecha o scanner
                return;  // Encerra a execução do programa
            default:
                // Caso default: Caso a opção escolhida seja inválida
                System.out.println("Opção inválida.");
        }
    }
}
