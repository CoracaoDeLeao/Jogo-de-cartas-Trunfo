/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartaTrunfo;

import java.util.Random;

/**
 *
 * @author Lab06aluno
 */
public class Carta {

    public String nome;
    public int forca;
    public int inteligencia;
    public int resistencia;
    public int fadiga;

    public Carta() {
        gerarAtributos();
    }

    private void gerarAtributos() {
        Random random = new Random();

        String[] nomes = {
            "Reinos Arcanos",
            "Glifos Etéreos",
            "Arcana Mítica",
            "Baralhos Celestiais",
            "Runas Elementais",
            "Gambito do Dragão",
            "Torre do Feiticeiro",
            "Encantamentos Élficos",
            "Mão do Mestre das Feras",
            "Destinos da Terra das Fadas"
        };

        this.nome = nomes[random.nextInt(10)];
        this.forca = random.nextInt(101);
        this.inteligencia = random.nextInt(101);
        this.resistencia = random.nextInt(101);
        this.fadiga = random.nextInt(101);
    }

    public String exibirCarta() {
           return nome + "\n" +
           "\n1-Força: " + forca + "\n" +
           "2-Inteligência: " + inteligencia + "\n" +
           "3-Resistência: " + resistencia + "\n" +
           "4-Fadiga: " + fadiga;
    }
}
