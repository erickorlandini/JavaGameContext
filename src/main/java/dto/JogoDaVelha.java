package main.java.dto;

import java.util.Scanner;

public class JogoDaVelha {
    private char[][] tabuleiro;
    private char jogadorAtual;
    public Scanner scanner;

    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        inicializarTabuleiro();
        jogadorAtual = 'X';
        scanner = new Scanner(System.in);
    }

    public void inicializarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for(int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ' ';
            }
        }
    }

    public void imprimirTabuleiro() {
        System.out.println("  1 | 2 | 3");
        System.out.println(" ---+---+---");
        System.out.println("  4 | 5 | 6");
        System.out.println(" ---+---+---");
        System.out.println("  7 | 8 | 9");
        System.out.println();
        System.out.println();

        for (int linha = 0; linha < 3; linha++) {
            System.out.println("  " + tabuleiro[linha][0] + " | " + tabuleiro[linha][1] + " | " + tabuleiro[linha][2]);
            if(linha < 2) {
                System.out.println(" ---+---+---");
            }
        }
        System.out.println();
    }

    public boolean fazerJogada() {
        int posicao;

        while (true) {
            System.out.println("Jogador" + jogadorAtual + ", digite o numero da posição desejada (1-9):");
            if(scanner.hasNextInt()) {
                posicao = scanner.nextInt();
                if(posicao >= 1 && posicao <= 9) {
                    if(posicaoValida(posicao)) {
                        int linha = (posicao -1) / 3;
                        int coluna = (posicao -1) % 3;
                        tabuleiro[linha][coluna] = jogadorAtual;
                        if(verificarVitoria()) {
                            imprimirTabuleiro();
                            System.out.println("Jogador " + jogadorAtual + " venceu!");
                            return true;
                        } else if(verificarEmpate()) {
                            imprimirTabuleiro();
                            System.out.println("Deu velha!");
                            return true;
                        } else {
                            mudarJogador();
                            return false;
                        }
                    } else {
                        System.out.println("Essa posição já está ocupada. Tente novamente.");
                    }
                } else {
                    System.out.println("Posição inválida. Digite um número entre 1 e 9.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next();
            }
        }
    }

    private boolean posicaoValida(int posicao) {
        int linha = (posicao - 1) / 3;
        int coluna = (posicao - 1) % 3;
        return tabuleiro[linha][coluna] == ' ';
    }

    private void mudarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public Boolean verificarVitoria() {
        for(int linha = 0; linha < 3; linha++) {
            if(tabuleiro[linha][0] == jogadorAtual && 
               tabuleiro[linha][1] == jogadorAtual && 
               tabuleiro[linha][2] == jogadorAtual) {
                return true;
            }
        }

        for(int coluna = 0; coluna < 3; coluna++) {
            if(tabuleiro[0][coluna] == jogadorAtual && 
               tabuleiro[1][coluna] == jogadorAtual && 
               tabuleiro[2][coluna] == jogadorAtual) {
                return true;
            }
        }

        if(tabuleiro[0][0] == jogadorAtual &&
           tabuleiro[1][1] == jogadorAtual &&
           tabuleiro[2][2] == jogadorAtual) {
            return true;
        }

        if(tabuleiro[0][2] == jogadorAtual &&
           tabuleiro[1][1] == jogadorAtual &&
           tabuleiro[2][0] == jogadorAtual) {
            return true;
        }

        return false;
    }

    private boolean verificarEmpate() {
        for(int linha = 0; linha < 3; linha++) {
            for(int coluna = 0; coluna < 3; coluna++) {
                if(tabuleiro[linha][coluna] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}