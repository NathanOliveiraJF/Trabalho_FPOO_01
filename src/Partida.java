public class Partida {
    private Participante participanteA;
    private Participante participanteB;
    private int golsA;
    private int golsB;
    private int rodada;

    public Partida() {}
    public Partida(Participante participanteA, Participante participanteB) {
        this.participanteA = participanteA;
        this.participanteB = participanteB;
    }

    public Participante getParticipanteA() {
        return participanteA;
    }
    public void setParticipanteA(Participante participanteA) {
        this.participanteA = participanteA;
    }

    public Participante getParticipanteB() {
        return participanteB;
    }
    public void setParticipanteB(Participante participanteB) {
        this.participanteB = participanteB;
    }

    public int getGolsA() {
        return golsA;
    }
    public void setGolsA(int golsA) {
        this.golsA = golsA;
    }

    public int getGolsB() {
        return golsB;
    }
    public void setGolsB(int golsB) {
        this.golsB = golsB;
    }

    public Participante defineGanhador() {
        if(this.golsA > this.golsB){
            return this.participanteA;
        }
        return this.participanteB;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public int getRodada() {
        return rodada;
    }
}
