package etapa3;

public class Etapa3 {
    public boolean checkBrackets(Stack<Character> s1) {
        // Pilha auxiliar utilizada para armazenar
        // os parênteses de fechamento encontrados.
        Stack<Character> aux = new StaticStack<>(s1.numElements());

        // Percorre a pilha removendo os elementos do topo
        // até que a pilha original fique vazia.
        while (!s1.isEmpty()) {
            // Remove o elemento do topo da pilha
            char c = s1.pop();

            // Como a pilha é processada do topo para a base,
            // o ')' é encontrado antes do '(' correspondente.
            // Por isso, os ')' são armazenados na pilha auxiliar.
            if (c == ')')
                aux.push(c);

            // Ao encontrar '('
            // verifica se existe um ')' correspondente.
            if (c == '(') {

                // Se a pilha auxiliar estiver vaza,
                // significa que existe um '(' sem fechamento.
                if (aux.isEmpty())
                    return false;

                // Remove o ')' correspondente.
                aux.pop();
            }
        }

        // Ao final:
        // se a pilha auxiliar estiver vazia,
        // todos os parênteses foram agrupados corretamente.
        return aux.isEmpty();
    }
}
