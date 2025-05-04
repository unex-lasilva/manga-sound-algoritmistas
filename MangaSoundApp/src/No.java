public class No {
    private Object valor;  // Armazena o valor do nó (pode ser qualquer tipo de objeto)
    private No prox;  // Referência para o próximo nó na lista encadeada

    // Construtor para inicializar um nó com um valor
    public No(Object valor){
        this.valor = valor;  // Define o valor armazenado no nó
        this.prox = null;  // Inicializa o próximo nó como nulo (indicando que não há próximo nó)
    }

    // Método para obter o valor armazenado no nó
    public Object getValor(){
        return valor;  // Retorna o valor armazenado no nó
    }

    // Método para definir o valor armazenado no nó
    public void setValor(Object valor){
        this.valor = valor;  // Define um novo valor para o nó
    }

    // Método para obter o próximo nó da lista
    public No getprox(){
        return prox;  // Retorna o próximo nó
    }

    // Método para definir o próximo nó da lista
    public void setprox(No prox){
        this.prox = prox;  // Define o próximo nó da lista
    }
}
