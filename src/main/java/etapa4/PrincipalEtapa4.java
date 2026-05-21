package etapa4;

public class PrincipalEtapa4 {
    public static void main(String[] args) {
        // Teste 1: Operações com Pilha (LinkedStack)
        System.out.println("Teste 1: Contagem de Elementos na Pilha (LinkedStack)");
        LinkedStack stack = new LinkedStack<>();

        // Verifica se a pilha está vazia
        System.out.println("Pilha está vazia? " + stack.isEmpty());

        // Empilhando elementos
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Elemento no topo da pilha: " + stack.top());

        // Desempilhando um elemento
        System.out.println("Desempilhando: " + stack.pop());
        System.out.println("Número de elementos na pilha: " + stack.numElements());
        System.out.println("---------------------------------------------------");

        // Teste 2: Operações com Fila (LinkedQueue)
        System.out.println("Teste 2: Verificação de Elementos na Fila (LinkedQueue)");
        LinkedQueue queue = new LinkedQueue<>();

        // Verifica se a fila está vazia
        System.out.println("Fila está vazia? " + queue.isEmpty());

        // Enfileirando elementos
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println("Primeiro da fila: " + queue.front());

        // Desenfileirando um elemento
        System.out.println("Desenfileirando: " + queue.dequeue());
        System.out.println("Número de elementos na fila: " + queue.numElements());

        // Verificar último elemento (back)
        System.out.println("Último da fila (back): " + queue.back());
        System.out.println("---------------------------------------------------");
    }
}
