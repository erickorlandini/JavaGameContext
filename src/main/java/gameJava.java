package main.java;

import main.java.dto.JogoDaVelha;

public class gameJava {
    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            jogo.inicializarTabuleiro();

            boolean fimDeJogo = false;
            while (!fimDeJogo) {
                jogo.imprimirTabuleiro();
                fimDeJogo = jogo.fazerJogada();
            }
            
            System.out.println("Deseja jogar novamente? (s/n)");
            String resposta = jogo.scanner.next().toLowerCase();
            jogarNovamente = resposta.equals("s");
        }

        jogo.scanner.close();
        System.out.println("Obrigado por jogar!");
    }
}
