package etapa2;

public class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos){
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getPartido(){
        return this.partido;
    }
    public void setPartido(String partido){
        this.partido = partido;
    }

    public int getIntencoesVotos(){
        return this.intencoesVotos;
    }
    public void setIntencoesVotos(int intencoesVotos){
        this.intencoesVotos = intencoesVotos;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %d", nome, partido, intencoesVotos);
    }
}
