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

    public void criaLabirinto(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){ // Necessário uso do try/chatch, pois FileNotFoundException e IOException são Exceções CHECKED. | Acessa o arquivo .txt que será passado como parâmetro
            String linha = br.readLine(); // Tenta ler a 1ª linha do arquivo .txt 

            ArrayList<String> linhas = new ArrayList<String>(); // Cria uma lista que armazenará as linhas obtidas

            while(linha != null){ // Enquanto não acabou o arquivo...
                linhas.add(linha); // Armazena a linha no ArrayList (Lista)
                linha = br.readLine(); // Tenta ler a próxima linha do arquivo .txt
            }

            int numLinhas = linhas.size(); // Guarda o número de linhas coletadas no ArrayList
            int numColunas = linhas.get(0).length(); // Guarda o número de colunhas baseado no tamanho da 1ª linha do arquivo

            labirinto = new char[numLinhas][numColunas]; // Passa o tamanho da matriz com base nas informações coletadas e armazenadas dentro do ArrayList (Linhas)

            for (int i = 0; i < numLinhas; i++) { // Percorre, com base no número de linhas do ArrayList, e separa a String por Caracteres.
                labirinto[i] = linhas.get(i).toCharArray();
            }

        } catch(FileNotFoundException e){
            System.out.println("O Arquivo não foi encontrado: " + e.getMessage()); // Trata dentro do método a Exceção FileNotFoundException
        } catch(IOException e){
            System.out.println("Erro ao tentar ler o arquivo: " + e.getMessage()); // Trata dentro do método a Exceção IOException
        }
    }

    public boolean percorreLabirinto(){
        labirinto[0][0] = CAMINHO_SOLUCAO; // Partindo da posição [0][0]
        return resolverLabirinto(0, 0);
    }

    private boolean resolverLabirinto(int x, int y){
        if(labirinto[x][y] == SAIDA) return true; // 1. CASO BASE: chegou no destino?
        labirinto[x][y] = CAMINHO_SOLUCAO; // 2. Marca posição atual

        // 3. Tenta as 4 direções
        if(x - 1 >= 0 && labirinto[x-1][y] != PAREDE && labirinto[x][y] != CAMINHO_SOLUCAO){ // Valida se pode ir para cima
            if(resolverLabirinto(x-1, y)) return true; // Vai para cima
        }
        if(x + 1 < labirinto.length && labirinto[x+1][y] != PAREDE && labirinto[x][y] != CAMINHO_SOLUCAO){ // Valida se pode ir para baixo
            if(resolverLabirinto(x+1, y)) return true; // Vai para baixo
        }
        if(y - 1 >= 0 && labirinto[x][y-1] != PAREDE && labirinto[x][y] != CAMINHO_SOLUCAO){ // Valida se pode ir para esquerda
            if(resolverLabirinto(x, y-1)) return true; // Vai para esquerda
        } 
        if(y + 1 < labirinto[x].length && labirinto[x][y+1] != PAREDE && labirinto[x][y] != CAMINHO_SOLUCAO){ // Valida se pode ir para direita
            if(resolverLabirinto(x, y+1)) return true; // Vai para a direita
        }
        return false;
    }
}
