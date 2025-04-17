public class ListaEncadeada<T> {

    // Classe interna para representar um nó
    private static class No<T> {
        T valor;
        No<T> proximo;

        No(T valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Adiciona no final da lista
    public void append(T valor) {
        No<T> novo = new No<>(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    // Insere em uma posição específica
    public void insertAt(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        No<T> novo = new No<>(valor);
        if (posicao == 0) {
            novo.proximo = inicio;
            inicio = novo;
        } else {
            No<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }

        tamanho++;
    }

    // Remove item da posição
    public boolean remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        if (posicao == 0) {
            inicio = inicio.proximo;
        } else {
            No<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }

        tamanho--;
        return true;
    }

    // Retorna valor da posição
    public T get(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        No<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    // Retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Retorna se está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Limpa a lista
    public boolean clear() {
        if (inicio == null) return false;
        inicio = null;
        tamanho = 0;
        return true;
    }

    // Adiciona todos os elementos de outra lista
    public void addAll(ListaEncadeada<T> outra) {
        No<T> atual = outra.inicio;
        while (atual != null) {
            append(atual.valor);
            atual = atual.proximo;
        }
    }

    // Verifica se valor está na lista
    public boolean contains(T valor) {
        return indexOf(valor) != -1;
    }

    // Retorna índice do valor ou -1
    public int indexOf(T valor) {
        No<T> atual = inicio;
        int index = 0;
        while (atual != null) {
            if ((valor == null && atual.valor == null) || 
                (valor != null && valor.equals(atual.valor))) {
                return index;
            }
            atual = atual.proximo;
            index++;
        }
        return -1;
    }

    // Força impressão dos elementos
    public void imprimir() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    // Método principal para testar
    public static void main(String[] args) {
        ListaEncadeada<Object> lista = new ListaEncadeada<>();

        System.out.println("Adicionando elementos:");
        lista.append(10);
        lista.append(20);
        lista.append("Texto");
        lista.append(30.5);
        lista.append(true);
        lista.imprimir();

        System.out.println("Tamanho: " + lista.size());
        System.out.println("Elemento na posição 2: " + lista.get(2));

        System.out.println("Inserindo na posição 1:");
        lista.insertAt(1, "NovoElemento");
        lista.imprimir();

        System.out.println("Removendo da posição 3:");
        lista.remove(3);
        lista.imprimir();

        System.out.println("Contém 'Texto'? " + lista.contains("Texto"));
        System.out.println("Índice de true: " + lista.indexOf(true));

        System.out.println("Limpando a lista...");
        lista.clear();
        System.out.println("Está vazia? " + lista.isEmpty());
        lista.imprimir();
    }
}
