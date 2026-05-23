package etapa2;

public class OrdenarCandidatos {
    static void ordenaCandidatosPorNome(Candidato[] candidatos){
        for(int i = 1; i <candidatos.length; i++){
            Candidato candidatoAtual = candidatos[i]; // Pega o elemento atual
            int j = i - 1;

            while(j >= 0 && candidatos[j].getNome().compareTo(candidatoAtual.getNome()) > 0){ // Enquanto o candidato anterior for MAIOR que o atual... | compareTo() = retorna ou -1, ou 0, ou 1.
                candidatos[j + 1] = candidatos[j]; // desloca para a direita
                j--;
            }
            candidatos[j + 1] = candidatoAtual;
        }
    }

    static void ordenaCandidatosPorVotos(Candidato[] candidatos){
        int i = candidatos.length - 1;
        while (i > 0){
            int ultimaTroca = 0;
            for(int j = 0; j < i; j++){
                if(candidatos[j].getIntencoesVotos() > candidatos[j + 1].getIntencoesVotos()){ // Troca o par de posição
                    Candidato candidatoAtual = candidatos[j];
                    candidatos[j] = candidatos[j+1]; // Inverte a posição do candidato com maior inteções de votos para direita
                    candidatos[j+1] = candidatoAtual; // Inverte a posição do candidato com menor inteções de votos para esquerda
                    ultimaTroca = j;
                }
            }
            i = ultimaTroca;
        }
    }

    static void ordenaCandidatosPorPartido(Candidato[] candidatos){
        for(int i = 1; i <candidatos.length; i++){
            Candidato candidatoAtual = candidatos[i]; // Pega o elemento atual
            int j = i - 1;

            while(j >= 0 && candidatos[j].getPartido().compareTo(candidatoAtual.getPartido()) > 0){ // Enquanto o candidato anterior for MAIOR que o atual... | compareTo() = retorna ou -1, ou 0, ou 1.
                candidatos[j + 1] = candidatos[j]; // desloca para a direita
                j--;
            }
            candidatos[j + 1] = candidatoAtual;
        }
    }

    static int pesquisaBinariaCandidatos(Candidato[] candidatos, String arg){
        // Com base no retorno do método compareTo() o método faz as comparações para saber se está próximo ou não.
        int inf = 0;
        int sup = candidatos.length - 1;
        while(inf <= sup){
            int med = (inf + sup) / 2;
            int comparacao = arg.compareTo(candidatos[med].getNome()); // Compara o argumento passado com o nome do candidato

            if(comparacao == 0){ 
                while(med > 0 && candidatos[med-1].getNome().equals(arg)) med--; // Garante que retorna a PRIMEIRA ocorrência
                return med;
            } else if(comparacao < 0){ 
                sup = med - 1;
            } else{
                inf = med + 1;
            }
        }
        return -1;
    }
}
