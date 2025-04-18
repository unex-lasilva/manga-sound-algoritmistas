import java.util.Scanner;

// Nicolas Santos Sampaio
// Marcos Vinicius Duarte Paranhos

public class MangaSound {

    // Classe interna Musica
    static class Musica {
        private int id;
        private String titulo;
        private String artista;

        public Musica(int id, String titulo, String artista) {
            this.id = id;
            this.titulo = titulo;
            this.artista = artista;
        }

        public int getId() { return id; }
        public String getTitulo() { return titulo; }
        public String getArtista() { return artista; }

        @Override
        public String toString() {
            return id + " - " + titulo + " (" + artista + ")";
        }
    }

    // Nó para lista encadeada
    static class NoMusica {
        Musica musica;
        NoMusica proximo;

        public NoMusica(Musica musica) {
            this.musica = musica;
            this.proximo = null;
        }
    }

    // Repositório de músicas
    static class Repositorio {
        private NoMusica inicio;
        private int contadorId = 1;

        public void adicionarMusica(String titulo, String artista) {
            Musica nova = new Musica(contadorId++, titulo, artista);
            NoMusica novoNo = new NoMusica(nova);

            if (inicio == null) {
                inicio = novoNo;
            } else {
                NoMusica atual = inicio;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novoNo;
            }
            System.out.println("Música adicionada: " + nova);
        }

        public void listarMusicas() {
            if (inicio == null) {
                System.out.println("Repositório vazio.");
                return;
            }
            NoMusica atual = inicio;
            while (atual != null) {
                System.out.println(atual.musica);
                atual = atual.proximo;
            }
        }

        public Musica buscarPorId(int id) {
            NoMusica atual = inicio;
            while (atual != null) {
                if (atual.musica.getId() == id) {
                    return atual.musica;
                }
                atual = atual.proximo;
            }
            return null;
        }
    }

    // Playlist
    static class Playlist {
        private String nome;
        private NoMusica inicio;

        public Playlist(String nome) {
            this.nome = nome;
            this.inicio = null;
        }

        public void adicionarMusica(Musica musica) {
            NoMusica novoNo = new NoMusica(musica);
            if (inicio == null) {
                inicio = novoNo;
            } else {
                NoMusica atual = inicio;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novoNo;
            }
            System.out.println("Música adicionada à playlist!");
        }

        public void tocar() {
            if (inicio == null) {
                System.out.println("Playlist vazia.");
                return;
            }
            System.out.println("Tocando playlist: " + nome);
            NoMusica atual = inicio;
            while (atual != null) {
                System.out.println("🎵 " + atual.musica);
                atual = atual.proximo;
            }
        }
    }

    // Menu principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repositorio repositorio = new Repositorio();
        Playlist playlist = null;

        int opcao;
        do {
            System.out.println("\n=== MangaSound ===");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    repositorio.adicionarMusica(titulo, artista);
                    break;

                case 2:
                    System.out.print("Nome da playlist: ");
                    String nomePlaylist = scanner.nextLine();
                    playlist = new Playlist(nomePlaylist);
                    System.out.println("Playlist criada!");
                    break;

                case 3:
                    if (playlist == null) {
                        System.out.println("Crie uma playlist primeiro.");
                        break;
                    }
                    repositorio.listarMusicas();
                    System.out.print("Digite o ID da música para adicionar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Musica musica = repositorio.buscarPorId(id);
                    if (musica != null) {
                        playlist.adicionarMusica(musica);
                    } else {
                        System.out.println("Música não encontrada.");
                    }
                    break;

                case 4:
                    if (playlist != null) {
                        playlist.tocar();
                    } else {
                        System.out.println("Nenhuma playlist criada.");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando o MangaSound...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}
