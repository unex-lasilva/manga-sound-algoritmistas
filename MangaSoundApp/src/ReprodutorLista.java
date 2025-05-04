import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReprodutorLista {
    private ListaReproducao listaReproducao;  // Lista de reprodução associada ao reprodutor
    private String status;  // Status atual do reprodutor (parado, tocando, pausado)
    private Clip clip;  // Objeto Clip para controlar a reprodução do áudio

    // Construtor padrão, inicializa a lista de reprodução como nula e o status como parado
    public ReprodutorLista(){
        this.listaReproducao = null;
        this.status = "parado";
        this.clip = null;
    }

    // Construtor com a lista de reprodução, inicializa o status como parado
    public ReprodutorLista(ListaReproducao listaReproducao){
        this.listaReproducao = listaReproducao;
        this.status = "parado";
        this.clip = null;
    }

    // Define a lista de reprodução do reprodutor
    public void setListaReproducao(ListaReproducao lista){
        this.listaReproducao = lista;
    }

    // Retorna a lista de reprodução associada ao reprodutor
    public ListaReproducao getListaReproducao() {
        return this.listaReproducao;
    }

    // Inicia a reprodução da primeira música na lista de reprodução
    public void play(){
        if(listaReproducao == null || listaReproducao.isVazia()){
            System.out.println("Lista vazia");
            return;
        }
        try{
            Musica musica = listaReproducao.obterMusica(0);  // Pega a primeira música da lista
            File arquivo = new File(musica.getPath());  // Cria um arquivo a partir do caminho da música
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(arquivo);  // Cria um fluxo de áudio

            clip = AudioSystem.getClip();  // Cria um novo Clip (para tocar o áudio)
            clip.open(audioInput);  // Abre o fluxo de áudio no clip
            clip.start();  // Inicia a reprodução do áudio

            status = "tocando";  // Atualiza o status para "tocando"
            System.out.println("Tocando " + musica.getTitulo());  // Exibe o título da música
        } catch (Exception e) {
            System.out.println("Erro ao tocar musica: " + e.getMessage());  // Caso ocorra um erro, exibe a mensagem de erro
        }
    }

    // Pausa a reprodução da música
    public void pause(){
        if(clip != null && clip.isRunning()){
            clip.stop();  // Interrompe a reprodução da música
            status = "pausado";  // Atualiza o status para "pausado"
            System.out.println("Música pausada");  // Exibe mensagem de pausa
        } else {
            System.out.println("Música tocando");  // Se a música não estiver tocando, exibe mensagem
        }
    }

    // Reinicia a música atual
    public void restartMusica(){
        if (clip != null){
            clip.stop();  // Interrompe a música
            clip.setFramePosition(0);  // Reseta a posição do áudio para o início
            clip.start();  // Reinicia a música
            status = "tocando";  // Atualiza o status para "tocando"
        }
    }

    // Reinicia a lista de reprodução, tocando a primeira música novamente
    public void restartLista(){
        if(listaReproducao != null && !listaReproducao.isVazia()){
            stop();  // Para a reprodução atual

            Musica primeiraMusica = listaReproducao.obterMusica(0);  // Pega a primeira música da lista
            if(primeiraMusica != null){
                play();  // Inicia a reprodução da primeira música
                status = "tocando";  // Atualiza o status para "tocando"
            }
        }
    }

    // Para a reprodução da música e fecha o clip
    public void stop(){
        if(clip != null && clip.isRunning()){
            clip.stop();  // Interrompe a reprodução
            clip.close();  // Fecha o clip
            clip = null;  // Limpa a referência do clip
            status = "parado";  // Atualiza o status para "parado"
        }
    }
}
