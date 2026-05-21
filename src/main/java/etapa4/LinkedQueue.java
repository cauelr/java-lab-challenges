package etapa4;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int numElements;

    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.numElements = 0;
    }

    // Se estiver vazia retorna true
    @Override
    public boolean isEmpty() {
        return this.front == null;
    }

    // Estruturas dinâmicas não possuem capacidade fixa.
    // Portanto, a fila só ficaria cheia em caso de falta de memória.
    @Override
    public boolean isFull() {
        return false;
    }

    // Insere um elemento ao final da FILA.
    @Override
    public void enqueue(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element); // Cria um novo nó contendo o elemento informado.
        if (isEmpty()) { // Verifica se a FILA está vazia.
            this.front = this.back = newNode; // Aponta o FRONT e o BACK para o novo nó.
        } else {
            this.back.setNext(newNode); // Conecta o último nó da fila ao novo nó.
            this.back = newNode; // Aponta o BACK para o novo nó.
        }
        this.numElements++; // Incrementa o número de elementos.
    }

    // Remove o primeiro elemento da fila.
    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) // Valida se a FILA está vazia.
            throw new UnderflowException();
        Node<E> current = this.front; // Armazena uma referência para o primeiro nó da fila.
        this.front = this.front.getNext(); // FRONT passa a apontar para o próximo nó.
        if (this.front == null) // Verifica se FRONT está null, se estiver BACK também receberá null.
            this.back = null;
        current.setNext(null); // Remove a referência para o próximo nó.
        this.numElements--; // Decrementa o número de elementos.
        return current.getElement(); // Retorna o elemento removido.
    }

    // Retorna o primeiro elemento da FILA.
    @Override
    public E front() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return this.front.getElement();
    }

    // Retorna o último elemento da FILA.
    @Override
    public E back() throws UnderflowException {
        return this.back.getElement();
    }

    // Retorna o número de elementos dentro da FILA.
    @Override
    public int numElements() {
        return this.numElements;
    }
}
