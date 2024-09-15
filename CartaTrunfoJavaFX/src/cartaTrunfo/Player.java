/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartaTrunfo;

/**
 *
 * @author Lab06aluno
 */
public class Player {

    public int score;
    public Carta monteCarta[] = new Carta[7];

    public Player() {
        this.score = 0;

        for (int i = 1; i < monteCarta.length; i++) {
            Carta carta = new Carta();
            this.monteCarta[i] = carta;
        }
    }

    public void exibirMonte() {
        System.out.println("---Cartas---");
        for (int i = 0; i < monteCarta.length; i++) {
            monteCarta[i].exibirCarta();
            System.out.println("\n");
        }
    }
}
