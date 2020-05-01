import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
        //Gera a tabela com todas as partidas possiveis
        for (int i = 0; i < participantes.size(); i++) {
            Participante pA = participantes.get(i);
            for (int j = (i + 1); j < participantes.size(); j++) {
                Participante pB = participantes.get(j);

                partidas.add(new Partida(pA, pB));
                // Se criamos uma lista de partidas para o participante
                // adicionar a mesma instância da partida para cada
                // um dos participantes neste ponto.
            }
        }

        partidas = geraRodadas(partidas);
    }
    public String getTabelaJogos() {
        String tabela = "";

        for (Partida p : partidas) {
            tabela += p.getParticipanteA() + " X " + p.getParticipanteB() + " - Rodada " + p.getRodada() + "\n";
        }

        return tabela;
    }

    private ArrayList<Partida> geraRodadas(ArrayList<Partida> partidas) {
        ArrayList<Partida> partidasAux = new ArrayList<Partida>();
        boolean erro = true;
        while (erro) {
            for (Partida partida : partidas) {
                partida.setRodada(0);
            }
            erro = false;
            partidasAux = new ArrayList<>();
            partidasAux.addAll(partidas);

            //Número de rodadas
            for (int i = 1; i <= (partidas.size() - 1); i++) {
                ArrayList<Partida> jogosRodada = new ArrayList<Partida>();

                for (Partida jogo : partidasAux) {
                    if (jogo.getRodada() == 0) {
                        jogosRodada.add(jogo);
                    }
                }
                //Jogos por rodada
                for (int j = 0; j < (partidas.size() / 2); j++) {
                    if (jogosRodada.isEmpty()) {
                        erro = true;
                        break;
                    }
                    Random r = new Random(new Date().getTime());
                    int idx = r.nextInt(jogosRodada.size());

                    Partida partidaSelecionada = jogosRodada.get(idx);
                    partidaSelecionada.setRodada(i);
                    jogosRodada.remove(idx);
                    jogosRodada = retiraPartidasSelecionadas(partidaSelecionada, jogosRodada);

                }
                if (erro) {
                    break;
                }

            }
        }
        return partidasAux;
    }

    private ArrayList<Partida> retiraPartidasSelecionadas(Partida partidaSelecionada, ArrayList<Partida> partidas) {
        ArrayList<Partida> jogosAux = new ArrayList<>();
        jogosAux.addAll(partidas);

        for (Partida partida : partidas) {
            if ((partida.getParticipanteA().equals(partidaSelecionada.getParticipanteA())
                    || partida.getParticipanteA().equals(partidaSelecionada.getParticipanteB())
                    || partida.getParticipanteB().equals(partidaSelecionada.getParticipanteA())
                    || partida.getParticipanteB().equals(partidaSelecionada.getParticipanteB()))) {
                jogosAux.remove(partida);
            }
        }
        return jogosAux;

    }

    public String geraRanking() {
        return "";
    }

    public Participante vencedor(Participante participante) {
        Participante vencedor = participantes.get(0);

        for (Participante p : participantes) {
            if (p.calculaPontos() > vencedor.calculaPontos()) {
                vencedor = p;
            }
        }

        return vencedor;
    }

    public Jogador artilheiro() {
        Jogador artilheiro = new Jogador();
        Participante pArtilheiro = new Participante();

        for (Participante p : participantes) {
            if (p.artilheiro().getGols() > artilheiro.getGols()) {
                artilheiro = p.artilheiro();
                pArtilheiro = p;
            }
        }

        marcaPontosArtilheiro(pArtilheiro);

        return artilheiro;
    }

    public void marcaPontosArtilheiro(Participante participante) {
        participante.setBonusArtilheiro();
    }
}
