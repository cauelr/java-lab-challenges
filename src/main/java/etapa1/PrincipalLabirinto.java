package etapa1;

public class PrincipalLabirinto {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();

        labirinto.criaLabirinto("DesafioLabII\\src\\main\\java\\etapa1\\labirinto.txt"); // Carrega o labirinto a partir
                                                                                         // do arquivo de texto.
        labirinto.imprimeLabirinto(); // Exibi o labirinto inicial.

        boolean encontrou = labirinto.percorreLabirinto();
        if (encontrou) { // Executa a busca pela saída.
            System.out.println("Solução encontrada");
            labirinto.imprimeLabirinto(); // Exibi o labirinto final, mostrando o caminho da solução, se encontrado.
        } else {
            System.out.println("Caminho não encontrado!!");
        }
    }
}