import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Campeonato c = new Campeonato();

        Participante breno = new Participante("Breno");
        breno.setTime(c.getTime(0));
        c.cadastraParticipante(breno);

        c.cadastraParticipante(new Participante("Nathan"));
        c.cadastraParticipante(new Participante("Jorge"));
        c.cadastraParticipante(new Participante("Gustavo"));
        c.cadastraParticipante(new Participante("Maria"));
        c.cadastraParticipante(new Participante("Betânia"));

        System.out.println("Gerando a tabela de partidas...");
        c.geraTabelaPartidas();

        System.out.println("Imprimindo a tabela de partidas...");
        System.out.print(c.getTabelaPartidas());

        System.out.println("\n===== Lista de times disponíveis ======");
        System.out.println(c.listTimesDisponiveis());

	    // Chama o metodo que popula a lista de times.
    }
}
