/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;
import java.util.*;

/**
 *
 * @author Mauricio
 */
public class InfinityGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Bienvenido a InfinityGame");
       int casilla = numeroCasilla();
       char tablero[] = creacionTablero(casilla);
       int numjug = cantidadJugadores();
       
       String jugadores[] = new String[numjug];
       for(int i=0;i<jugadores.length;i++){
           jugadores[i] = nombreJugador();
       }
       
       //creacion array de objectos de la clase jugador
       Jugador[] players = new Jugador[numjug];
       for(int i=0;i<jugadores.length;i++){
           String nombre = jugadores[i];
           players[i] = new Jugador(nombre,casilla);
       }
       //Turno segun la cantidad de personas
       for(int i=0;i<players.length;i++){
           int cantidadDado = lanzarDados();
           players[i].cambiarPosicion(cantidadDado);
           //if(players[i].getPosicion()==)
           mostrarTabla(players);
       }
     }
    
    private static int cantidadJugadores(){
        int numjug;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos jugadores van a jugar? ");
        numjug = sc.nextInt();
        while(numjug<1){
            System.out.println("El número mínimo de jugadores es 1, intente denuevo");
            numjug = sc.nextInt();
        }
        return numjug;
    }
    
    private static String nombreJugador(){
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador :");
        nombre = sc.nextLine();
        return nombre;
    }
    
    private static int numeroCasilla(){
        Scanner sc = new Scanner(System.in);
        int casilla;
        System.out.println("Ingrese el número de casillas que desea ocupar, no debe ser menor que 20");
        casilla = sc.nextInt();
        while(casilla<20){
        System.out.println("El número que has ingresado es menor que 20, intenta denuevo");
        casilla = sc.nextInt();
        }
        System.out.println("El número de casillas selecionadas es de: "+casilla);
        return(casilla);
    }
    
    private static char[] creacionTablero(int numerocasilla){
        char tablero[] = new char[numerocasilla];
        //Array de char que contiene cada casilla especial: B=Blanco, P=Portal, S=Salud, D=Desafio
        char casilla[] = {'B','P','S','D'};
        //Designar el inicio y el final del tablero con la A y la Z
        tablero[0]='A';
        tablero[numerocasilla-1]='Z';
        //LLenado de casillas 
        for(int i=1;i<(tablero.length-2);i++){
            int idx = new Random().nextInt(casilla.length);
            tablero[i] = casilla[idx];
        }
        return tablero;
    }
    
    private static int lanzarDados(){
        int dado[] = {1,2,3,4,5,6};
        int idx = new Random().nextInt(dado.length);
        int dado1 = dado[idx];
        int dado2 = dado[idx];
        int sumaDado = (dado1+dado2);
        System.out.println("La suma de tus dados es "+sumaDado);
        return sumaDado;
    }
    
    private static void casillaDesafio(Jugador[] players,int indice){
        //Dos tipos de desafios, 0 es avanzar retroceder y 1 es agregar o quitar vida
        //el indice es donde esta el jugador que cae en esa casilla
        int desafio = (int)(Math.random()*2);
        switch(desafio){
            case 0:
               int direccion = (int)(Math.random()*2); //0 negativo, 1 positivo
               int cantidad = (int) ((Math.random()*6)+1);//cantidad de posiciones
               switch(direccion){
                   case 0:
                       players[indice].cambiarPosicion(-cantidad);
                       break;
                   case 1:
                       players[indice].cambiarPosicion(cantidad);
                       break;
               }
                break;
            case 1:
                int cantidadVida = (int)((Math.random()*5)+1);//cantidad de vida
                int signo = (int)(Math.random()*2); 
                switch(signo){
                    case 0:
                    for(int i=0;i<players.length;i++){
                        players[i].cambiarVida(-cantidadVida);
                    }
                    players[indice].cambiarVida(+cantidadVida);
                    
                        break;
                    case 1:
                        for(int i=0;i<players.length;i++){
                        players[i].cambiarVida(cantidadVida);
                    }
                    players[indice].cambiarVida(-cantidadVida);
                        
                        break;
                }
                break;
        }
    }
    
    private static void casillaPortal(Jugador[] players, int indice, char tablero[]){
        for(int i=0;i<tablero.length;i++){
            if(tablero[i]=='P'){
                if(i>players[indice].getPosicion()){
                    players[indice].setPosicion(i);
                }
            }
        }
    }
    
    private static void casillaSalud(Jugador[] players,int indice){
        int vida = (int)((Math.random()*4)+1);
        int signo = (int)(Math.random()*2); 
        if(signo==0){
            players[indice].cambiarVida(-vida);
        } else if (signo==1){
            players[indice].cambiarVida(vida);
        }
    }
    
    private static void mostrarTabla(Jugador[] players){
        System.out.println("NickName "+"\t"+"Puntos de salud "+"\t"+"Posición actual");
        for(int i=0;i<players.length;i++){
            System.out.println(players[i].getName()+"\t"+players[i].getSalud()+"\t"+players[i].getPosicion());
        }
    }
    
}
