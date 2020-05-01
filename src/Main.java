import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Campeonato c = new Campeonato();

        c.cadastraParticipante(new Participante("Breno"));
        c.cadastraParticipante(new Participante("Nathan"));
        c.cadastraParticipante(new Participante("Jorge"));
        c.cadastraParticipante(new Participante("Gustavo"));
        c.cadastraParticipante(new Participante("Maria"));
        c.cadastraParticipante(new Participante("Betânia"));

        System.out.println("Gerando a tabela de partidas...");
        c.geraTabelaPartidas();

        System.out.println("Imprimindo a tabela de partidas...");
        System.out.print(c.getTabelaPartidas());

	    // Chama o metodo que popula a lista de times.
    }
}
