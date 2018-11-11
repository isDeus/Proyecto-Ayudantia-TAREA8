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

    private char casilla;
    private char tipo;

    public Casilla(String Tipo) {
        TipoCasilla elTipo = Enum.valueOf(TipoCasilla.class, Tipo);
        this.tipo = elTipo.getTipo();
    }
    
    public char devolverTipoCasilla(){
        return this.tipo;
    }
}
