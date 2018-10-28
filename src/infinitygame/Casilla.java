/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

/**
 *
 * @author Mauricio
 */
public class Casilla {

    private int valor;

    public Casilla(int valor) {
        this.valor = valor;
    }

    public char devolverCasilla() {
        char casilla[] = {'B', 'P', 'S', 'D'};
        switch (this.valor) {
            case 1:
                return casilla[0];
            case 2:
                return casilla[1];
            case 3:
                return casilla[2];
            case 4:
                return casilla[3];
            default:
                return casilla[0];
        }
    }
}
