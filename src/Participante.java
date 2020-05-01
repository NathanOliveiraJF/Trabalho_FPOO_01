public class Participante {
    private String nome;
    private int golsFeitos;
    private int golsSofridos;
    private int vitorias;
    private boolean bonusArtilheiro;
    private Time time;

    public Participante() {}
    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGolsFeitos() {
        return golsFeitos;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isBonusArtilheiro() {
        return bonusArtilheiro;
    }
    public void setBonusArtilheiro(boolean bonusArtilheiro) {
        this.bonusArtilheiro = bonusArtilheiro;
    }

    public int calculaPontos() {
        return 0;
    }

    public void addGolFeito() {

    }

    public void addGolSofrido() {

    }

    public void addVitoria() {

    }
}
