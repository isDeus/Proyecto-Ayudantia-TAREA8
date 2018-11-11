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
public enum TipoCasilla {
    
    BLANCO('B'),
    PORTAL('P'),
    SALUD('S'),
    DESAFIO('D');
    
    private final char tipo;
    
    private TipoCasilla(char a){
        this.tipo = a;
    }
    
    public char getTipo(){
        return tipo;
    }
}
