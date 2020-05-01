import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Participante> participantes;

    public Campeonato() {
        participantes =  new ArrayList<Participante>();
    }

    private void cadastrarParticipantes(Participante participante) {
        this.participantes.add(participante);
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public String gerarTabelaJogos() {
        return "";
    }

    public String gerarRanking() {
        return "";
    }

    public Participante vencedor(Participante participante) {
        return null;
    }

    public Jogador artilheiro(Jogador jogador) {
        return jogador;
    }

    public void pontosArtilheiro(Participante participante) {

    }
}
