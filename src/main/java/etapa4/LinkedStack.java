package etapa4;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int numElements;

    public LinkedStack() {
        this.top = null;
        this.numElements = 0;
    }

    // Retorna true se a lista não possuir elementos
    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    // Estruturas dinâmicas não possuem capacidade fixa.
    // Portanto, a fila só ficaria cheia em caso de falta de memória.
    @Override
    public boolean isFull() {
        return false;
    }

    // Insere o elemento no inicio da pilha e incrementa o número de elementos.
    @Override
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element); // Cria um novo nó com o elemento passado por parâmetro
        newNode.setNext(this.top); // Conecta o novo NÓ à pilha existente. Em resumo: O próximo do novo nó passa a
                                   // ser o antigo topo da pilha.
        this.top = newNode; // Aponta o TOP para o novo elemento.
        this.numElements++; // Incrementa o número de elementos.
    }

    // Remove o elemento do inicio da pilha e decrementa o número de elementos.
    @Override
    public E pop() throws UnderflowException {
        // Verifica se a pilha está vazia.
        if (isEmpty())
            throw new UnderflowException();

        Node<E> current = this.top; // Current referencia o nó que está no topo da pilha.
        this.top = this.top.getNext(); // TOP aponta para o próximo nó
        current.setNext(null); // Desconecta o nó removido do restante da pilha.
        this.numElements--; // Decrementa a quantidade de elementos
        return current.getElement(); // Retorna o elemento removido do topo da pilha.
    }

    // Retorna o elemento do TOP.
    @Override
    public E top() throws UnderflowException {
        // Verifica se a pilha está vazia.
        if (isEmpty())
            throw new UnderflowException();
        return this.top.getElement();
    }

    // Retorna o número de elementos.
    @Override
    public int numElements() {
        return this.numElements;
    }
}
