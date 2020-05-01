public class Participante {
    // TODO: implementar o comparable etc etc https://howtodoinjava.com/sort/collections-sort/
    private String nome;
    private int golsFeitos;
    private int golsSofridos;
    private int vitorias;
    private boolean bonusArtilheiro;
    private Time time;

    public Participante() {
        this.nome = "";
        this.golsFeitos = 0;
        this.golsSofridos = 0;
        this.vitorias = 0;
        this.bonusArtilheiro = false;
    }
    public Participante(String nome) {
        this.nome = nome;
        this.golsFeitos = 0;
        this.golsSofridos = 0;
        this.vitorias = 0;
        this.bonusArtilheiro = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGolFeito() {
        return golsFeitos;
    }

    public int getGolSofrido() {
        return golsSofridos;
    }

    public int getVitoria() {
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

    public void setBonusArtilheiro() {
        this.bonusArtilheiro = true;
    }

    public double calculaPontos() {
        double pontos = 0;

        if(this.bonusArtilheiro){
            pontos += 5;
        }

        pontos += (3 * this.vitorias) + this.golsFeitos + (this.golsSofridos * 0.5);

        return pontos ;
    }

    public void addGolFeito(int numGol) {
        this.golsFeitos += numGol;

    }

    public void addGolSofrido(int numGol) {
        this.golsSofridos += numGol;
    }

    public void addVitoria() {
        this.vitorias++;
    }

    public Jogador artilheiro(){
        return time.artilheiro();
    }
}
