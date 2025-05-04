public class Musica {
    private String titulo;  // Título da música
    private int duracao;  // Duração da música em segundos
    private String path;  // Caminho para o arquivo de áudio (arquivo .wav)
    private String artista;  // Artista da música

    // Construtor para inicializar uma nova instância de Música
    public Musica(String titulo, int duracao, String path, String artista) {
        this.titulo = titulo;  // Define o título da música
        this.duracao = duracao;  // Define a duração da música
        this.path = path;  // Define o caminho do arquivo de áudio
        this.artista = artista;  // Define o artista da música
    }

    // Método para obter o título da música
    public String getTitulo() {
        return titulo;  // Retorna o título da música
    }

    // Método para obter a duração da música
    public int getDuracao() {
        return duracao;  // Retorna a duração da música
    }

    // Método para obter o caminho do arquivo de áudio da música
    public String getPath() {
        return path;  // Retorna o caminho do arquivo de áudio
    }

    // Método para obter o artista da música
    public String getArtista() {
        return artista;  // Retorna o nome do artista
    }
}
