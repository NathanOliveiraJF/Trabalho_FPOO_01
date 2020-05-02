import java.util.ArrayList;

public class Time {
    private ArrayList<Jogador>jogadores;
    private String nome;

    public Time() {
        this.nome = "";
        this.jogadores = new ArrayList<>();
    }
    public Time (String nome) {
        this.jogadores = new ArrayList<>();
        this.nome = nome;
    }

    public void addJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }
    public Jogador getJogador(int index) {
        return this.jogadores.get(index);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogador artilheiro() {
        Jogador jogador = new Jogador();

        for(Jogador jog : this.jogadores){
            if(jog.getGols() > jogador.getGols()) {
                jogador = jog;
            }
        }

        return jogador;
    }

    public String listaJogador() {
        String nomeJogador = "";

        for(int i = 0; i < jogadores.size(); i++){
            nomeJogador += "[" + ( i + 1) + "] " + jogadores.get(i).getNome() + "\n";
        }

        return nomeJogador;
    }
}
