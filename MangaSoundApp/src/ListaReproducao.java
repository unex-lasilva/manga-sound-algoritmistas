import java.util.ArrayList;

public class ListaReproducao {
    private String titulo;  // Título da lista de reprodução
    private ListaEncadeada lista;  // Lista encadeada que armazena as músicas

    // Construtor que inicializa a lista de reprodução com um título
    public ListaReproducao(String titulo) {
        this.titulo = titulo;  // Define o título da lista de reprodução
        this.lista = new ListaEncadeada();  // Cria uma nova lista encadeada para armazenar músicas
    }

    // Método para adicionar uma música à lista de reprodução
    public void addMusica(Musica musica) {
        lista.append(musica);  // Adiciona a música ao final da lista
    }

    // Método para remover uma música de uma posição específica
    public boolean removerMusica(int posicao) {
        return lista.remove(posicao);  // Remove a música da posição especificada
    }

    // Método para inserir uma música em uma posição específica
    public void inserirMusica(int posicao, Musica musica) {
        lista.insertAt(posicao, musica);  // Insere a música na posição fornecida
    }

    // Método para verificar se a lista de reprodução está vazia
    public boolean isVazia() {
        return lista.isEmpty();  // Retorna se a lista está vazia
    }

    // Método para retornar o tamanho da lista de reprodução
    public int tamanho() {
        return lista.size();  // Retorna o número de músicas na lista
    }

    // Método para criar uma nova lista de reprodução a partir de outra
    public void criarListaApartirDe(ListaReproducao outra) {
        this.lista.clear();  // Limpa a lista atual
        // Adiciona todas as músicas da outra lista de reprodução
        for (int i = 0; i < outra.tamanho(); i++) {
            Musica musica = (Musica) outra.lista.get(i);  // Obtém a música da outra lista
            this.addMusica(musica);  // Adiciona à lista atual
        }
    }

    // Método para encontrar a posição de uma música na lista
    public int posicaoDa(Musica musica) {
        return lista.indexOf(musica);  // Retorna a posição da música na lista
    }

    // Método para verificar se a música está na lista
    public boolean contemMusica(Musica musica) {
        return lista.contains(musica);  // Retorna se a música está na lista
    }

    // Método para limpar a lista de reprodução
    public boolean limparLista() {
        return lista.clear();  // Limpa todos os elementos da lista
    }

    // Método para obter uma música a partir de uma posição específica
    public Musica obterMusica(int posicao) {
        return (Musica) lista.get(posicao);  // Retorna a música na posição especificada
    }

    // Método para obter o título da lista de reprodução
    public String getTitulo() {
        return titulo;  // Retorna o título da lista de reprodução
    }

    // Método para definir o título da lista de reprodução
    public void setTitulo(String titulo) {
        this.titulo = titulo;  // Define um novo título para a lista de reprodução
    }

    // Método para remover uma música da lista de reprodução pelo título
    public boolean removerMusicaPorTitulo(String titulo) {
        for (int i = 0; i < lista.size(); i++) {  // Percorre a lista de músicas
            Musica musica = (Musica) lista.get(i);  // Obtém a música na posição i
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {  // Verifica se o título da música corresponde
                lista.remove(i);  // Remove a música da lista
                return true;  // Retorna verdadeiro se a música for removida
            }
        }
        return false;  // Retorna falso se a música não for encontrada
    }
}
