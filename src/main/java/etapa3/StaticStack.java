package etapa3;

public class StaticStack<E> implements Stack<E> {
    private int top; // Índice do elemento que está no topo da pilha.
    private E[] elements; // Array de elementos genéricos.

    // Inicializa o array que armazenará os elementos da lista
    // com o tamanho máximo informado.
    // O atributo top começa com -1, pois a pilha inicia vazia.
    public StaticStack(int maxSize) {
        this.elements = (E[]) new Object[maxSize];
        this.top = -1;
    }

    // Retorna true se a pilha estiver vazia
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    // Retorna true quando a pilha atingir a capacidade máxima de elementos dentro
    // do array.
    @Override
    public boolean isFull() {
        return this.top == this.elements.length - 1;
    }

    // Retorna o número atual de elementos dentro da pilha.
    @Override
    public int numElements() {
        return this.top + 1;
    }

    // Insere um elemento no topo da pilha.
    @Override
    public void push(E element) throws OverflowException {
        // Verifica se a pilha está cheia.
        // Se a pilha estiver cheia, lança OverflowException,
        // pois não há espaço disponível para inserção.
        if (isFull())
            throw new OverflowException();
        // Diferentemente de uma Lista Estática, não faz sentido validarmos se a posição
        // é válida ou não, visto que, em uma pilha, só é possível adicionarmos um
        // elemento ao topo.

        // Incrementa o topo ANTES da atribuição,
        // fazendo com que o novo elemento seja inserido
        // na próxima posição disponível da pilha.
        elements[++top] = element;
    }

    // Remove o último elemento da pilha
    // Segue a nomenclatura de LIFO (Last In, First Out)
    @Override
    public E pop() throws UnderflowException {
        // Verifica se a pilha está vazia.
        // Se a pilha estiver vazia, lança UnderflowException,
        // pois não existem elementos para remoção.
        if (isEmpty())
            throw new UnderflowException();

        // Cria e inicializa uma variável que receberá uma referência do elemento
        // removido.
        E element = this.elements[top];

        // Remove a referência do elemento atual do topo
        // e decrementa o topo APÓS a atribuição.
        elements[top--] = null;
        // Retorna a referência do elemento removido.
        return element;
    }

    // Retorna o elemento do topo sem removê-lo da pilha.
    @Override
    public E top() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return elements[top];
    }

}
