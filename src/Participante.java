public class Participante {
    private String nome;
    private int golsFeitos;
    private int golsSofridos;
    private int vitorias;
    private boolean bonusArtilheiro;

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

    public int getVitorias() {
        return vitorias;
    }


    public boolean isBonusArtilheiro() {
        return bonusArtilheiro;
    }
    public void setBonusArtilheiro(boolean bonusArtilheiro) {
        this.bonusArtilheiro = bonusArtilheiro;
    }

    public int calcularPontos() {
        return 0;
    }

    public void addGolFeito() {

    }

    public void addGolSofrido() {

    }

    public void addVitoria() {

    }
}
