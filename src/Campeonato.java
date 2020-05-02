import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Campeonato {
    private ArrayList<Participante> participantes;
    private ArrayList<Partida> partidas;
    private ArrayList<Time> times;

    public Campeonato() {
        participantes =  new ArrayList<Participante>();
        partidas =  new ArrayList<Partida>();
        times =  new ArrayList<Time>();

        populaTimes();
    }

    public void cadastraParticipante(Participante participante) {
        this.participantes.add(participante);
    }
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void cadastraTime(Time time) {
        this.times.add(time);
    }
    public Time getTime(int i) {
        return times.get(i);
    }
    public String listTimesDisponiveis() {
        String timesDisponiveis = "";
        ArrayList<Time> timesAux = new ArrayList<>();
        timesAux.addAll(times);

        for (Time t : times) {
            for (Participante p : participantes) {
                if (p.getTime().getNome().equals(t.getNome())) {
                    timesAux.remove(t);
                }
            }
        }

        for (Time t : timesAux) {
            timesDisponiveis += "[" + (times.indexOf(t) + 1) + "] " + t.getNome() + "\n";
        }

        return timesDisponiveis;
    }

    public void geraTabelaPartidas() {
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

        ordenaPartidas(partidas);
    }

    public String getTabelaPartidas() {
        if (partidas.size() == 0) geraTabelaPartidas();

        String tabela = "";

        // Separa a impressão por rodadas.
        for (int i = 1; i < participantes.size(); i++) {
            tabela += "\n╭──────────────────── Rodada " + i + " ─────────────────╮\n";

            for (Partida p : partidas) {
                if (p.getRodada() == i){
                    tabela += "  " + p.getParticipanteA().getNome() + " X " + p.getParticipanteB().getNome() + "\n";
                }
            }
            tabela += ("╰───────────────────────────────────────────────╯");
        }

        return tabela;
    }

    private ArrayList<Partida> geraRodadas(ArrayList<Partida> partidas) {
        ArrayList<Partida> partidasAux = new ArrayList<>();
        boolean erro = true;
        while (erro) {
            for (Partida partida : partidas) {
                partida.setRodada(0);
            }
            erro = false;
            partidasAux = new ArrayList<>();
            partidasAux.addAll(partidas);

            //Número de rodadas
            for (int i = 1; i <= (participantes.size() - 1); i++) {
                ArrayList<Partida> jogosRodada = new ArrayList<Partida>();

                for (Partida jogo : partidasAux) {
                    if (jogo.getRodada() == 0) {
                        jogosRodada.add(jogo);
                    }
                }
                //Jogos por rodada
                for (int j = 0; j < (participantes.size() / 2); j++) {
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
        String ranking = "";

        // Recupera o artilheiro e dá o bônus ao participante.
        String artilheiro = artilheiro().getNome();
        int golsArtilheiro = artilheiro().getGols();

        ordenaRanking(participantes);

        for (int i = 0; i < participantes.size(); i++) {
            ranking += "#" + (i + 1) + " - " + participantes.get(i).getNome() + "(" + participantes.get(i).calculaPontos() + ")\n";
        }

        ranking += "Artilheiro: " + artilheiro + " (" + golsArtilheiro + " gols)\n";

        return ranking;
    }

    private void ordenaRanking(ArrayList<Participante> participantes) {
        ordenaRanking(participantes, participantes.size());
    }
    private void ordenaRanking(ArrayList<Participante> participantes, int n) {
        if (n == 1) return;

        for (int i = 0; i < n - 1; i++) {
            if (participantes.get(i).calculaPontos() < participantes.get(i + 1).calculaPontos()) {
                trocaParticipante(participantes, i, i + 1);
            }

            ordenaRanking(participantes, n - 1);
        }
    }
    private void trocaParticipante(ArrayList<Participante> part, int i, int j) {
        Participante aux = part.get(i);
        part.set(i, part.get(j));
        part.set(j, aux);
    }

    private void ordenaPartidas(ArrayList<Partida> partidas) {
        ordenaPartidas(partidas, partidas.size());
    }
    private void ordenaPartidas(ArrayList<Partida> partidas, int n) {
        if (n == 1) return;

        for (int i = 0; i < n - 1; i++) {
            if (partidas.get(i).getRodada() > partidas.get(i + 1).getRodada()) {
                trocaPartida(partidas, i, i + 1);
            }

            ordenaPartidas(partidas, n - 1);
        }
    }
    private void trocaPartida(ArrayList<Partida> part, int i, int j) {
        Partida aux = part.get(i);
        part.set(i, part.get(j));
        part.set(j, aux);
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

    private void populaTimes() {
        Time cruzeiro = new Time("Cruzeiro");
        cruzeiro.addJogador(new Jogador("Rafael"));
        cruzeiro.addJogador(new Jogador("Dedé"));
        cruzeiro.addJogador(new Jogador("Léo"));
        cruzeiro.addJogador(new Jogador("Murilo Cerqueira"));
        cruzeiro.addJogador(new Jogador("Fabrício Bruno"));
        cruzeiro.addJogador(new Jogador("Cacá"));
        cruzeiro.addJogador(new Jogador("Edu"));
        cruzeiro.addJogador(new Jogador("Jonathan Monteiro"));
        cruzeiro.addJogador(new Jogador("Egídio"));
        cruzeiro.addJogador(new Jogador("Dodô"));
        cruzeiro.addJogador(new Jogador("Patrick"));
        times.add(cruzeiro);

        Time atletico = new Time("Atlético");
        atletico.addJogador(new Jogador("Victor"));
        atletico.addJogador(new Jogador("Réver"));
        atletico.addJogador(new Jogador("Gustavo Blanco"));
        atletico.addJogador(new Jogador("Fábio Santos"));
        atletico.addJogador(new Jogador("Rómulo Otero"));
        atletico.addJogador(new Jogador("Jair"));
        atletico.addJogador(new Jogador("Diego Tardelli"));
        atletico.addJogador(new Jogador("Juan Cazares"));
        atletico.addJogador(new Jogador("Maicón"));
        atletico.addJogador(new Jogador("Guilherme Arana"));
        atletico.addJogador(new Jogador("José Welison"));
        times.add(atletico);

        Time america = new Time("América");
        america.addJogador(new Jogador("Léo Lang"));
        america.addJogador(new Jogador("Savio"));
        america.addJogador(new Jogador("Ynaiã"));
        america.addJogador(new Jogador("Leandro Silva"));
        america.addJogador(new Jogador("Lucas Kal"));
        america.addJogador(new Jogador("Zé Ricardo"));
        america.addJogador(new Jogador("João Paulo"));
        america.addJogador(new Jogador("Juninho"));
        america.addJogador(new Jogador("Matheusinho"));
        america.addJogador(new Jogador("Airton"));
        america.addJogador(new Jogador("Neto Berola"));
        times.add(america);

        Time tupi = new Time("Tupi");
        tupi.addJogador(new Jogador("Luís Gueguel"));
        tupi.addJogador(new Jogador("Arilton"));
        tupi.addJogador(new Jogador("Afonso"));
        tupi.addJogador(new Jogador("Esquerdinha"));
        tupi.addJogador(new Jogador("João Vitor"));
        tupi.addJogador(new Jogador("Marcel"));
        tupi.addJogador(new Jogador("Pedro Vitor"));
        tupi.addJogador(new Jogador("Yan Everton Almeida Suhet"));
        tupi.addJogador(new Jogador("Lucas Tavares"));
        tupi.addJogador(new Jogador("Gonçalves"));
        tupi.addJogador(new Jogador("Diogo"));
        times.add(tupi);

        Time orgrimmar = new Time("Orgrimmar");
        orgrimmar.addJogador(new Jogador("Thrall"));
        orgrimmar.addJogador(new Jogador("Baine Bloodhoof"));
        orgrimmar.addJogador(new Jogador("Rokhan"));
        orgrimmar.addJogador(new Jogador("Lilian Voss"));
        orgrimmar.addJogador(new Jogador("Lor'themar Theron"));
        orgrimmar.addJogador(new Jogador("Gazlowe"));
        orgrimmar.addJogador(new Jogador("Ji Firepaw"));
        orgrimmar.addJogador(new Jogador("Thalyssra"));
        orgrimmar.addJogador(new Jogador("Sylvanas"));
        orgrimmar.addJogador(new Jogador("Zul'Jhin"));
        orgrimmar.addJogador(new Jogador("Kiro"));
        times.add(orgrimmar);

        Time stormwind = new Time("Stormwind");
        stormwind.addJogador(new Jogador("Anduin Wrynn"));
        stormwind.addJogador(new Jogador("Muradin Bronzebeard"));
        stormwind.addJogador(new Jogador("Moira Thaurissan"));
        stormwind.addJogador(new Jogador("Falstad Wildhammer"));
        stormwind.addJogador(new Jogador("Tyrande"));
        stormwind.addJogador(new Jogador("Malfurion"));
        stormwind.addJogador(new Jogador("Genn Greymane"));
        stormwind.addJogador(new Jogador("Jaina Proudmore"));
        stormwind.addJogador(new Jogador("Erazmin"));
        stormwind.addJogador(new Jogador("Turalyon"));
        stormwind.addJogador(new Jogador("Alleria Windrunner"));
        times.add(stormwind);

        Time noxus = new Time("Noxus");
        noxus.addJogador(new Jogador("Cassiopeia"));
        noxus.addJogador(new Jogador("Darius"));
        noxus.addJogador(new Jogador("Draven"));
        noxus.addJogador(new Jogador("Katarina"));
        noxus.addJogador(new Jogador("Kled"));
        noxus.addJogador(new Jogador("Leblanc"));
        noxus.addJogador(new Jogador("Riven"));
        noxus.addJogador(new Jogador("Sion"));
        noxus.addJogador(new Jogador("Swain"));
        noxus.addJogador(new Jogador("Talon"));
        noxus.addJogador(new Jogador("Vladmir"));
        times.add(noxus);

        Time zaun = new Time("Zaun");
        zaun.addJogador(new Jogador("Jinx"));
        zaun.addJogador(new Jogador("Ekko"));
        zaun.addJogador(new Jogador("Twitch"));
        zaun.addJogador(new Jogador("Blitzcrank"));
        zaun.addJogador(new Jogador("Dr.Mundo"));
        zaun.addJogador(new Jogador("Singed"));
        zaun.addJogador(new Jogador("Urgot"));
        zaun.addJogador(new Jogador("Viktor"));
        zaun.addJogador(new Jogador("Warwick"));
        zaun.addJogador(new Jogador("Zac"));
        zaun.addJogador(new Jogador("Ziggs"));
        times.add(zaun);
    }
}
