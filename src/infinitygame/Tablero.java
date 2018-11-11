/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import java.util.Random;

/**
 *
 * @author Mauricio
 */
public class Tablero {

    private char tablero[];

    public Tablero(int numeroCasilla) {
        this.tablero = new char[numeroCasilla];
        tablero[0] = 'A';
        tablero[numeroCasilla - 1] = 'Z';
    }

    public void llenadoTablero() {
        for (int i = 1; i < (this.tablero.length - 2); i++) {
            String[] valores = new String[]{"BLANCO","PORTAL", "SALUD", "DESAFIO"};
            int rnd = new Random().nextInt(valores.length);
            String tipo = valores[rnd];
            Casilla casilla = new Casilla(tipo);
            char tipoCasilla = casilla.devolverTipoCasilla();
            this.tablero[i] = tipoCasilla;
        }
    }

    public char[] getTablero() {
        return this.tablero;
    }

}
