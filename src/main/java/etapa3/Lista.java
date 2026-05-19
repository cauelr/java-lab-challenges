package etapa3;

public interface Lista<E> {

    public void insert(E element, int pos);

    public int contaElementos(E element);

    public int numElements();

    public boolean isEmpty();

    public boolean isFull();

    public E get(int pos);

    public E remove(int pos);
}
