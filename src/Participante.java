public class Participante {
    private String nome;
    private int golsFeitos;
    private int golsSofridos;
    private int vitorias;
    private boolean bonusArtilheiro;

    public Participante(String nome, int golsFeitos, int vitorias, boolean bonusArtilheiro) {
        this.nome = nome;
        this.golsFeitos = golsFeitos;
        this.vitorias = vitorias;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGolsFeitos() {
        return golsFeitos;
    }

    public void setGolsFeitos(int golsFeitos) {
        this.golsFeitos = golsFeitos;
    }

    public int getVitorias() {
        return vitorias;
    }


    public int getGolsSofridos() {
        return golsSofridos;
    }

    public void setGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public boolean isBonusArtilheiro() {
        return bonusArtilheiro;
    }

    public void setBonusArtilheiro(boolean bonusArtilheiro) {
        this.bonusArtilheiro = bonusArtilheiro;
    }
}
