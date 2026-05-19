package etapa2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    public static ArrayList<String> lerArquivo(String filename) {
        ArrayList<String> linhas = new ArrayList<String>(); // Cria uma lista que armazenará as linhas obtidas

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linha = br.readLine(); // Tenta ler a 1ª linha do arquivo .txt

            while (linha != null) { // Enquanto não acabou o arquivo...
                linhas.add(linha); // Armazena a linha no ArrayList (Lista)
                linha = br.readLine(); // Tenta ler a próxima linha do arquivo .txt
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao tentar ler o arquivo: " + e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
        return linhas; // retorna o ArrayList preenchido!
    }

    public static void main(String[] args) {
        Random random = new Random(); // Instancia a Classe Random
        int tamanho = random.nextInt(100) + 1; // Define um tamnho aleatório de 1 a 100

        Candidato[] candidatos = new Candidato[tamanho];

        ArrayList<String> nomes = lerArquivo("src/main/java/etapa2/nomes.txt");
        ArrayList<String> partidos = lerArquivo("src/main/java/etapa2/partidos.txt");

        for (int i = 0; i < tamanho; i++) {
            String nome = nomes.get(random.nextInt(nomes.size())); // Seleciona um nome aleatório com base no tamanho do
                                                                   // ArrayList
            String partido = partidos.get(random.nextInt(partidos.size())); // Seleciona um partido aleatório com base
                                                                            // no tamanho do ArrayList
            int votos = random.nextInt(1000) + 1; // Cria, de forma aleatória, um número de vótos de 1 a 1000

            candidatos[i] = new Candidato(nome, partido, votos); // Cria um objeto Candidato.
        }

        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        System.out.println("Pesquise o nome de algum candidato: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        int resultadoDaPesquisa = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nome);
        if (resultadoDaPesquisa != -1) {
            System.out.println("Candidato encontrado: " + candidatos[resultadoDaPesquisa]);
        } else {
            System.out.println("Candidato não encontrado!");
        }
    }

}
