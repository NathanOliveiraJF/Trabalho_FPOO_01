public class Partida {
    private Participante participanteA;
    private Participante participanteB;
    private int golsPa;
    private int golsPb;

    public Partida(Participante participanteA, Participante participanteB, int golsPa, int golsPb) {
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.golsPa = golsPa;
        this.golsPb = golsPb;
    }

    public Participante defineGanhador() {
        return null;
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

    public int getGolsPa() {
        return golsPa;
    }

    public void setGolsPa(int golsPa) {
        this.golsPa = golsPa;
    }

    public int getGolsPb() {
        return golsPb;
    }

    public void setGolsPb(int golsPb) {
        this.golsPb = golsPb;
    }
}
