package etapa3;

public class StaticList<E> implements Lista<E> {
    private E[] elements; // Array de elementos genéricos
    private int size; // Número de elementos

    // Inicializa o array que armazenará os elementos da lista
    // com o tamanho máximo informado.
    // O atributo size começa com 0, pois a lista inicia vazia.
    public StaticList(int maxSize) {
        this.elements = (E[]) new Object[maxSize];
        this.size = 0;
    }

    // Em vista de que esta classe implementa a interface Lista<E>,
    // se faz obrigatório implementarmos alguns métodos.
    @Override
    public void insert(E element, int pos) {
        // Verifica se a lista está cheia.
        // Se a lista estiver cheia, lança OverflowException,
        // pois não há espaço disponível para inserção.
        if (isFull())
            throw new OverflowException();
        // Verifica se a posição é válida.
        // É permitido inserir na posição size,
        // pois isso representa inserir no final da lista.
        if (pos < 0 || pos > numElements())
            throw new IndexOutOfBoundsException();

        // Desloca os elementos uma posição para a direita,
        // abrindo espaço para a inserção do novo elemento.
        for (int i = this.size - 1; i >= pos; i--) {
            this.elements[i + 1] = elements[i];
        }
        // Armazena o novo elemento e ajusta o total:
        elements[pos] = element;
        size++;
    }

    // Método público responsável por iniciar
    // a contagem recursiva a partir do índice 0.
    @Override
    public int contaElementos(E element) {
        return contaElementosRecursivo(element, 0); // Inicia do indice 0.
    }

    // Método auxiliar recursivo
    // Percorre a lista verificando quantas vezes "element" aparece a partir do
    // índice i.
    private int contaElementosRecursivo(E element, int i) {
        // CASO BASE:
        // Se o índice i atingir o tamanho da lista,
        // significa que não há mais elementos para analisar.
        if (i == this.size)
            return 0;

        // PASSO RECURSIVO (caso o elemento atual seja igual):
        // Soma 1 à contagem caso o elemento atual seja igual
        // e continua a busca recursivamente no restante da lista.
        if (element.equals(this.elements[i]))
            return 1 + contaElementosRecursivo(element, i + 1);

        // PASSO RECURSIVO (caso o elemento atual NÃO seja igual):
        // Apenas continua a busca no próximo índice.
        return contaElementosRecursivo(element, i + 1);
    }

    // Retorna o número total de elementos.
    @Override
    public int numElements() {
        return size;
    }

    // Retorna true se a lista não possuir elementos.
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Retorna true quando a quantidade de elementos
    // atingir a capacidade máxima do array.
    @Override
    public boolean isFull() {
        return this.size == elements.length;
    }

    // Retorna o elemento armazenado na posição informada.
    @Override
    public E get(int pos) {
        // Verifica se a posição do elemento é válida
        if (pos < 0 || pos >= this.size)
            throw new IndexOutOfBoundsException();
        // Retorna o elemento cuja posição foi passada.
        return elements[pos];
    }

    // Remove o elemento da posição informada por parâmetro.
    @Override
    public E remove(int pos) {
        // Verifica se não está vazio
        if (isEmpty())
            throw new UnderflowException();

        // Verifica se a posição é válida
        if (pos < 0 || pos >= this.size)
            throw new IndexOutOfBoundsException();

        // Guarda uma referência temporária do elemento removido
        E element = this.elements[pos];

        // Desloca para a esquerda os elemento necessários
        // Sobreescrevendo a posição do elemento que está sendo removido:
        for (int i = pos; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        // Define para null a posição antes ocupada pelo último,
        // para que a coleta de lixo possa atuar e ajusta o total.
        elements[size - 1] = null;
        size--;

        // Retorna o valor removido.
        return element;
    }
}
