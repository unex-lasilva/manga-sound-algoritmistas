public class MangaController {
    private ListaEncadeada repositorioMusica;
    private ListaEncadeada listaReproducao;
    private ListaEncadeada artistas;
    private ReprodutorLista reprodutorLista;

    public MangaController(){
        this.repositorioMusica=new ListaEncadeada();
        this.listaReproducao=new ListaEncadeada();
        this.artistas=new ListaEncadeada();
        this.reprodutorLista=new ReprodutorLista();
    }
   public void adicionarMusica(String titulo,String path,String nomeArtista){
        Musica novaMusica=new Musica(titulo,180,path,nomeArtista);
            repositorioMusica.append(novaMusica);
            if(!artistas.contains(nomeArtista)){
                artistas.append(nomeArtista);
        }
        System.out.println("musica"+titulo+ "do(a) "+nomeArtista+" foi adiconada com sucesso");
    }
    public void criarListaDeReproducao(String titulo){
        ListaReproducao novaLista=new ListaReproducao(titulo);
        listaReproducao.append(novaLista);
        System.out.println("Lista de reprodução criada "+titulo);
    }
    public void excluirListaDeReproducap(String titulo){
        for(int i=0; i<listaReproducao.size();i++){
            ListaReproducao lista=(ListaReproducao) listaReproducao.get(i);
            if (lista.getTitulo().equalsIgnoreCase(titulo)){
                listaReproducao.remove(i);
                System.out.println("Lista de reprodução removida "+titulo);
                return;
            }
        }
        System.out.println("Lista de reprodução não encontrada");
    }
public void adicionarMusicaListaDeReproducao(String tituloMusica,String tituloLista){
        ListaReproducao lista=null;
        Musica musica=null;

        for(int i=0;i<listaReproducao.size();i++){
            ListaReproducao listaTemp=(ListaReproducao) listaReproducao.get(i);
            if(listaTemp.getTitulo().equalsIgnoreCase(tituloLista)){
                lista=listaTemp;
                break;
            }
        }
        for(int i=0;i<repositorioMusica.size();i++){
            Musica m=(Musica) repositorioMusica.get(i);
            if(m.getTitulo().equalsIgnoreCase(tituloMusica)){
                musica=m;
                break;
            }
        }
        if (lista!=null && musica != null){
            lista.addMusica(musica);
            System.out.println("Musica adicionada "+tituloMusica);
        }else{
            System.out.println("Lista ou música não encoontrada");
    }
}
   public void adicionarMusicaListaDeReproducaoEmPosicao(String tituloMusica,String tituloLista,int posicao){
        ListaReproducao lista=null;
        Musica musica=null;
       for(int i=0;i<listaReproducao.size();i++){
           ListaReproducao listaTemp=(ListaReproducao) listaReproducao.get(i);
           if(listaTemp.getTitulo().equalsIgnoreCase(tituloLista)){
               lista=listaTemp;
               break;
           }
       }
       for(int i=0;i<repositorioMusica.size();i++){
           Musica m=(Musica) repositorioMusica.get(i);
           if(m.getTitulo().equalsIgnoreCase(tituloMusica)){
               musica=m;
               break;
           }
      if(lista!=null && musica!=null){
          lista.inserirMusica(posicao,musica);
          System.out.println("Musica "+tituloMusica+"inserida na posição "+posicao+ " da lista");
      }else{
          System.out.println("Erro:Lista ou musica não encontrda");
      }
        }

   }
    public void removerMusicaDaListaDeReproducao(String tituloMusica, String tituloLista) {
        ListaReproducao lista = null;

        for (int i = 0; i < listaReproducao.size(); i++) {
            ListaReproducao listaTemp = (ListaReproducao) listaReproducao.get(i);
            if (listaTemp.getTitulo().equalsIgnoreCase(tituloLista)) {
                lista = listaTemp;
                break;
            }
        }

        if (lista != null) {
            boolean removido = lista.removerMusicaPorTitulo(tituloMusica);
            if (removido) {
                System.out.println("Música " + tituloMusica + " removida da lista " + tituloLista);
            } else {
                System.out.println("Música " + tituloMusica + " não encontrada na lista");
            }
        } else {
            System.out.println("Lista de reprodução " + tituloLista + " não encontrada");
        }
    }
        public void reproduzirListaDeReproducao(String tituloLista){
        ListaReproducao lista=null;
        for(int i=0;i<listaReproducao.size();i++){
            ListaReproducao atual=(ListaReproducao) listaReproducao.get(i);
            if(atual.getTitulo().equalsIgnoreCase(tituloLista)){
                lista=atual;
                break;
            }
        }
        if(lista!=null){
            reprodutorLista.setListaReproducao(lista);
            reprodutorLista.play();
            System.out.println("Reproduzir lista:"+tituloLista);
        }else{
            System.out.println("Lista de reprodução não encontrada");
        }
        }
 public void pausarMusica(){
reprodutorLista.pause();
System.out.println("Musica pausada");
 }
 public void executarMusica(){
reprodutorLista.play();
System.out.println("Musica tocando");
 }
 public void voltarMusica(){
 reprodutorLista.restartMusica();
 System.out.println("Musica reiniciada");
 }
 public void passarMusica(){
reprodutorLista.stop();
reprodutorLista.play();
System.out.println("Proxima musica");
 }
 public void reiniciarMusica(){
reprodutorLista.restartLista();
System.out.println("Lista reinicada");
 }
 public void paraLista(){
reprodutorLista.stop();
System.out.println("Rprodução parada");
 }


}
