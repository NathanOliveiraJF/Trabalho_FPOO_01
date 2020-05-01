import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Participante> participantes;
    private ArrayList<Partida> partidas;

    public Campeonato() {
        participantes =  new ArrayList<Participante>();
        partidas =  new ArrayList<Partida>();
    }

    private void cadastraParticipante(Participante participante) {
        this.participantes.add(participante);
    }
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void geraTabelaJogos() {
        return;
    }
    public String getTabelaJogos() {
        return "";
    }

    public String geraRanking() {
        return "";
    }

    public Participante vencedor(Participante participante) {
        return null;
    }

    public Jogador artilheiro(Jogador jogador) {
        return jogador;
    }

    public void marcaPontosArtilheiro(Participante participante) {

    }
}
