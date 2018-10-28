/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mauricio
 */
public class InfinityGameTest {
    
    public InfinityGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Dado dado = new Dado();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class InfinityGame.
     */

    @Test
    public void testLanzarDado(){
        int resultado = dado.lanzarDado();
        boolean esperado = false;
        if(resultado>1&&resultado<13){
            esperado = true;
        }
        assertTrue(esperado);
    }
    @Test
    public void testCasillaSalud(){
        //El test de casilla de la salud necesita el jugador
        //Creacion Jugador con la clase jugador
        Jugador[] players = new Jugador[1];
        players[0] = new Jugador("test",100);
        //La vida del juegador debe ser menor que 15 y no negativa
        InfinityGame.casillaSalud(players[0]);
        boolean esperado = false;
        if(players[0].getSalud()>=0 && players[0].getSalud()<=15){
            esperado = true;
        }
        assertTrue(esperado);
    }
    
    @Test
    public void testCasillaPortal(){
     //Creacion de tablero con el metodo creacionTablero
     char[] testTablero = InfinityGame.creacionTablero(100);
     //Creacion Jugador con la clase jugador
     Jugador[] players = new Jugador[1];
     players[0] = new Jugador("test",100);
    boolean esperado = false;
     //Asignar una posicion de portal
     for(int i=0;i<testTablero.length;i++){
         if(testTablero[i]=='P'){
             int nuevaPosicion = i;
             players[0].setPosicion(i);
             InfinityGame.casillaPortal(players[0], 0, testTablero);
             if(testTablero[nuevaPosicion] == 'P'){
                 esperado = true;
             }
             assertTrue(esperado);
         }
     }
    }
    
    @Test
    public void testNumeroCasilla(){
        
    }
    
}
