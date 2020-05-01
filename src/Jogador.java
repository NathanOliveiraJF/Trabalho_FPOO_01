public class Jogador {
    private String nome;
    private int gols;

    public Jogador () {}
    public Jogador (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGols() {
        return gols;
    }

    public void addGol(int gols) {
        this.gols += gols;
    }
}
