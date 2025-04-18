import java.util.Scanner;

class Musica {
    String titulo;
    String artista;
    String duracao;
    Musica proxima;

    public Musica(String titulo, String artista, String duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.proxima = null;
    }
}

class RepositorioMusicas {
    Musica primeiraMusica;

    public void adicionarMusica(String titulo, String artista, String duracao) {
        Musica novaMusica = new Musica(titulo, artista, duracao);
        if (primeiraMusica == null) {
            primeiraMusica = novaMusica;
        } else {
            Musica atual = primeiraMusica;
            while (atual.proxima != null) {
                atual = atual.proxima;
            }
            atual.proxima = novaMusica;
        }
        System.out.println("Música adicionada: " + titulo);
    }

    public void listarMusicas() {
        Musica atual = primeiraMusica;
        if (atual == null) {
            System.out.println("Nenhuma música no repositório.");
            return;
        }
        while (atual != null) {
            System.out.println(atual.titulo + " - " + atual.artista + " (" + atual.duracao + ")");
            atual = atual.proxima;
        }
    }
}

class ListaReproducao {
    String nome;
    Musica primeiraMusica;

    public ListaReproducao(String nome) {
        this.nome = nome;
        this.primeiraMusica = null;
    }

    public void adicionarMusica(Musica musica) {
        if (primeiraMusica == null) {
            primeiraMusica = musica;
        } else {
            Musica atual = primeiraMusica;
            while (atual.proxima != null) {
                atual = atual.proxima;
            }
            atual.proxima = musica;
        }
        System.out.println("Música adicionada à lista de reprodução: " + musica.titulo);
    }

    public void executar() {
        Musica atual = primeiraMusica;
        if (atual == null) {
            System.out.println("Lista de reprodução vazia.");
            return;
        }
        System.out.println("Executando lista: " + nome);
        while (atual != null) {
            System.out.println("Executando: " + atual.titulo + " - " + atual.artista + " (" + atual.duracao + ")");
            atual = atual.proxima;
        }
    }
}

public class MangaSound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RepositorioMusicas repositorio = new RepositorioMusicas();
        ListaReproducao listaReproducao = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Duração: ");
                    String duracao = scanner.nextLine();
                    repositorio.adicionarMusica(titulo, artista, duracao);
                    break;
                case 2:
                    System.out.print("Nome da lista de reprodução: ");
                    String nomeLista = scanner.nextLine();
                    listaReproducao = new ListaReproducao(nomeLista);
                    System.out.println("Lista de reprodução criada: " + nomeLista);
                    break;
                case 3:
                    if (listaReproducao == null) {
                        System.out.println("Nenhuma lista de reprodução criada.");
                        break;
                    }
                    repositorio.listarMusicas();
                    System.out.print("Escolha o título da música para adicionar à lista: ");
                    String tituloMusica = scanner.nextLine();
                    Musica atual = repositorio.primeiraMusica;
                    while (atual != null) {
                        if (atual.titulo.equals(tituloMusica)) {
                            listaReproducao.adicionarMusica(atual);
                            break;
                        }
                        atual = atual.proxima;
                    }
                   
