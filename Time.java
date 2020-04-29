import java.util.ArrayList;

public class Time {
    private ArrayList<Jogador>jogadores = new ArrayList<>();

    private String nome;

    public Time (String nome) {
        this.nome = nome;
    }

    public void addJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
