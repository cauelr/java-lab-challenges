package etapa1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Labirinto {
    private static final char PAREDE = 'X';
    private static final char CAMINHO_ABERTO = ' ';
    private static final char SAIDA = 'D';
    private static final char CAMINHO_SOLUCAO = '#';

    private char[][] labirinto;

    public void criaLabirinto(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { // Necessário uso do try/chatch, pois
                                                                                 // FileNotFoundException e IOException
                                                                                 // são Exceções CHECKED. | Acessa o
                                                                                 // arquivo .txt que será passado como
                                                                                 // parâmetro
            String linha = br.readLine(); // Tenta ler a 1ª linha do arquivo .txt

            ArrayList<String> linhas = new ArrayList<String>(); // Cria uma lista que armazenará as linhas obtidas

            while (linha != null) { // Enquanto não acabou o arquivo...
                linhas.add(linha); // Armazena a linha no ArrayList (Lista)
                linha = br.readLine(); // Tenta ler a próxima linha do arquivo .txt
            }

            int numLinhas = linhas.size(); // Guarda o número de linhas coletadas no ArrayList
            int numColunas = linhas.get(0).length(); // Guarda o número de colunhas baseado no tamanho da 1ª linha do
                                                     // arquivo

            labirinto = new char[numLinhas][numColunas]; // Passa o tamanho da matriz com base nas informações coletadas
                                                         // e armazenadas dentro do ArrayList (Linhas)

            for (int i = 0; i < numLinhas; i++) { // Percorre, com base no número de linhas do ArrayList, e separa a
                                                  // String por Caracteres.
                labirinto[i] = linhas.get(i).toCharArray();
            }

        } catch (FileNotFoundException e) {
            System.out.println("O Arquivo não foi encontrado: " + e.getMessage()); // Trata dentro do método a Exceção
                                                                                   // FileNotFoundException
            throw new IllegalArgumentException(e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao tentar ler o arquivo: " + e.getMessage()); // Trata dentro do método a Exceção
                                                                                   // IOException
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean percorreLabirinto() {
        return resolverLabirinto(0, 0); // Partindo da posição [0][0]
    }

    private boolean resolverLabirinto(int x, int y) {
        if (labirinto[x][y] == SAIDA)
            return true; // 1. CASO BASE: chegou no destino?
        labirinto[x][y] = CAMINHO_SOLUCAO; // 2. Marca posição atual

        // 3. Variáveis que recebem uma estrutura condicional:
        boolean podeCima = x - 1 >= 0 && labirinto[x - 1][y] != PAREDE && labirinto[x - 1][y] != CAMINHO_SOLUCAO; // PODE
                                                                                                                  // IR
                                                                                                                  // PARA
                                                                                                                  // CIMA?
        boolean podeBaixo = x + 1 < labirinto.length && labirinto[x + 1][y] != PAREDE
                && labirinto[x + 1][y] != CAMINHO_SOLUCAO; // PODE IR PARA BAIXO?
        boolean podeEsquerda = y - 1 >= 0 && labirinto[x][y - 1] != PAREDE && labirinto[x][y - 1] != CAMINHO_SOLUCAO; // PODE
                                                                                                                      // IR
                                                                                                                      // PARA
                                                                                                                      // ESQUERDA?
        boolean podeDireita = y + 1 < labirinto[x].length && labirinto[x][y + 1] != PAREDE
                && labirinto[x][y + 1] != CAMINHO_SOLUCAO; // PODE IR PARA DIREITA?

        // 4. Tenta as 4 direções
        if (podeCima) { // Valida se pode ir para CIMA
            if (resolverLabirinto(x - 1, y))
                return true; // Vai para cima
        }
        if (podeBaixo) { // Valida se pode ir para BAIXO
            if (resolverLabirinto(x + 1, y))
                return true; // Vai para baixo
        }
        if (podeEsquerda) { // Valida se pode ir para ESQUERDA
            if (resolverLabirinto(x, y - 1))
                return true; // Vai para esquerda
        }
        if (podeDireita) { // Valida se pode ir para DIREITA
            if (resolverLabirinto(x, y + 1))
                return true; // Vai para a direita
        }
        return false;
    }

    public void imprimeLabirinto() {
        for (int linha = 0; linha < labirinto.length; linha++) {
            for (int coluna = 0; coluna < labirinto[0].length; coluna++) {
                System.out.print(labirinto[linha][coluna]);
            }
            System.out.println();
        }
    }
}
