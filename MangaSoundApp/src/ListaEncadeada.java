public class ListaEncadeada {
    private No cabeca;  // Cabeça da lista encadeada, que aponta para o primeiro nó
    private int tamanho;  // Tamanho da lista encadeada

    // Construtor que inicializa a lista vazia
    public ListaEncadeada() {
        this.cabeca = null;  // A lista começa sem nenhum nó
        this.tamanho = 0;  // A lista começa com tamanho 0
    }

    // Método para adicionar um novo elemento no final da lista
    public void append(Object value) {
        No novo = new No(value);  // Cria um novo nó com o valor fornecido

        // Se a lista estiver vazia, o novo nó se torna a cabeça da lista
        if (cabeca == null) {
            cabeca = novo;
        } else {
            No atual = cabeca;
            // Percorre até o último nó da lista
            while (atual.getprox() != null) {
                atual = atual.getprox();
            }
            // O último nó agora aponta para o novo nó
            atual.setprox(novo);
        }
        tamanho++;  // Aumenta o tamanho da lista
    }

    // Método para remover um nó na posição especificada
    public boolean remove(int position) {
        if (position < 0 || position > tamanho) {  // Verifica se a posição é válida
            return false;
        }
        if (position == 0) {  // Se for a posição 0 (primeiro elemento), remove a cabeça
            cabeca = cabeca.getprox();
        } else {
            No anterior = cabeca;
            // Percorre até o nó anterior à posição a ser removida
            for (int i = 0; i < position - 1; i++) {
                anterior = anterior.getprox();
            }
            // O nó anterior agora aponta para o nó seguinte ao que será removido
            No atual = anterior.getprox();
            anterior.setprox(atual.getprox());
        }
        tamanho--;  // Diminui o tamanho da lista
        return false;
    }

    // Método para inserir um novo nó em uma posição específica
    public boolean insertAt(int position, Object value) {
        if (position < 0 || position > tamanho) {  // Verifica se a posição é válida
            return false; // Tentou colocar em uma posição inválida
        }
        No novo = new No(value);  // Cria um novo nó com o valor fornecido
        if (position == 0) {  // Se for a posição 0 (primeiro elemento), insere na frente
            novo.setprox(cabeca);
            cabeca = novo;
        } else {
            No anterior = cabeca;
            // Percorre até o nó anterior à posição onde o novo nó será inserido
            for (int i = 0; i < position - 1; i++) {
                anterior = anterior.getprox();
            }
            // O novo nó será inserido entre o anterior e o próximo
            novo.setprox(anterior.getprox());
            anterior.setprox(novo);
        }
        tamanho++;  // Aumenta o tamanho da lista
        return true;  // Inserção bem-sucedida
    }

    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return cabeca == null;  // Se a cabeça for null, significa que a lista está vazia
    }

    // Método para retornar o tamanho da lista
    public int size() {
        return tamanho;  // Retorna o tamanho da lista
    }

    // Método para adicionar todos os elementos de outra lista à lista atual
    public void addAll(ListaEncadeada lista) {
        for (int i = 0; i < lista.size(); i++) {
            Object value = lista.get(i);  // Obtém o valor de cada elemento na outra lista
            this.append(value);  // Adiciona ao final da lista atual
        }
    }

    // Método para retornar o índice de um valor na lista
    public int indexOf(Object value) {
        No atual = cabeca;
        int posicao = 0;
        // Percorre a lista até encontrar o valor
        while (atual != null) {
            if (atual.getValor().equals(value)) {  // Se o valor for encontrado, retorna a posição
                return posicao;
            }
            atual = atual.getprox();  // Move para o próximo nó
            posicao++;  // Incrementa a posição
        }
        return -1;  // Se o valor não for encontrado, retorna -1
    }

    // Método para verificar se um valor existe na lista
    public boolean contains(Object value) {
        No atual = cabeca;
        // Percorre a lista procurando o valor
        while (atual != null) {
            if (atual.getValor().equals(value)) {  // Se encontrado, retorna verdadeiro
                return true;
            }
            atual = atual.getprox();  // Move para o próximo nó
        }
        return false;  // Se não encontrar, retorna falso
    }

    // Método para limpar todos os elementos da lista
    public boolean clear() {
        if (cabeca == null) {  // Se a lista já está vazia, não faz nada
            return false;
        }
        cabeca = null;  // A lista é limpa (cabeça é null)
        tamanho = 0;  // O tamanho é resetado para 0
        return true;  // Limpeza bem-sucedida
    }

    // Método para obter o valor de um nó em uma posição específica
    public Object get(int position) {
        if (position < 0 || position >= tamanho) {  // Verifica se a posição é válida
            throw new IndexOutOfBoundsException("posição invalida");  // Lança exceção se inválida
        }
        No atual = cabeca;
        // Percorre até o nó na posição especificada
        for (int i = 0; i < position; i++) {
            atual = atual.getprox();
        }
        return atual.getValor();  // Retorna o valor do nó encontrado
    }
}
