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
//    public static void main(String[] args) {
//        System.out.println("Bienvenido a InfinityGame");
//        int casilla = numeroCasilla();
//        char tablero[] = creacionTablero(casilla);
//        int numjug = cantidadJugadores();
//        Scanner sc = new Scanner(System.in);
//
//        String jugadores[] = new String[numjug];
//        for (int i = 0; i < jugadores.length; i++) {
//            jugadores[i] = nombreJugador();
//        }
//
//        //creacion array de objectos de la clase jugador
//        Jugador[] players = new Jugador[numjug];
//        for (int i = 0; i < jugadores.length; i++) {
//            String nombre = jugadores[i];
//            players[i] = new Jugador(nombre, casilla - 1);
//        }
//        boolean estado = false;
//        do {
//            for (int i = 0; i < players.length; i++) {
//                mostrarTabla(players);
//                System.out.println("Que acción desea realizar? 1)Lanzar Dados 2)Meditar");
//                int eleccion = sc.nextInt();
//                switch (eleccion) {
//                    case 1:
//                        System.out.println("Presione cualquier tecla para lanzar tus dados");
//                        sc.next();
//                        int dado = lanzarDados();
//                        players[i].cambiarPosicion(dado);
//                        if (players[i].getPosicion() == (casilla - 1)) {
//                            System.out.println("El jugador " + players[i].getName() + " es el ganador!!!!");
//                            estado = true;
//                        } else {
//                            int position = players[i].getPosicion();
//                            char letra = tablero[position];
//                            System.out.println(letra);
//                            switch (letra) {
//                                case 'B':
//                                    break;
//                                case 'P':
//                                    casillaPortal(players[i], i, tablero);
//                                    break;
//                                case 'S':
//                                    casillaSalud(players[i]);
//                                    break;
//                                case 'D':
//                                    casillaDesafio(players, i);
//                                    break;
//                                default:
//                                    System.out.println("Hola programa culiao");
//                                    break;
//                            }
//                        }
//                        break;
//                    case 2:
//                        meditar(players[i], tablero);
//                        break;
//                    default:
//                        System.out.println("Has perdido tu turno por baka");
//                        break;
//                }
//            }
//
//        } while (!estado);
//    }
    public static void ejecutarGame() {
        System.out.println("Bienvenido a InfinityGame");
        //Creacion casilla
        int casilla = numeroCasilla();
        Tablero tablerito = new Tablero(casilla);
        tablerito.llenadoTablero();
        char tablero[] = tablerito.getTablero();
        //Creacion array de jugadores
        int numjug = cantidadJugadores();
        String jugadores[] = new String[numjug];
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = nombreJugador();
        }
        Jugador[] players = new Jugador[numjug];
        for (int i = 0; i < jugadores.length; i++) {
            String nombre = jugadores[i];
            players[i] = new Jugador(nombre, casilla - 1);
        }
        //Creacion Guardian
        Guardian guardian = new Guardian(numjug);
        boolean estado = false;
        Scanner sc = new Scanner(System.in);
        do {
            for (int i = 0; i < players.length; i++) {
                mostrarTabla(players);
                //Hablidad de furia del guardian
                int habilidad = guardian.habilidadFuria();
                if (habilidad == 1) {
                    for (int recorrido = 0; recorrido < players.length; recorrido++) {
                        players[recorrido].cambiarVida(-1);
                    }
                    System.out.println("El guardian ha activado su habilidad furia!");
                    System.out.println("Se ha restado 1 de vida a todos los jugadores");
                }
                //Turno normal del jugador
                System.out.println("Que acción desea realizar? 1)Lanzar Dados 2)Meditar");
                int eleccion = sc.nextInt();
                switch (eleccion) {
                    case 1:
                        System.out.println("Presione cualquier tecla para lanzar tus dados");
                        sc.next();
                        Dado dice = new Dado();
                        Reliquia reliquia = new Reliquia();
                        int dado = dice.lanzarDado();
                        int suerte = 0;
                        if (dado == 12) {
                            guardian.restarVida(3);
                            suerte = reliquia.activarReliquia(1);
                        } else {
                            guardian.restarVida(1);
                            suerte = reliquia.activarReliquia(2);
                        }
                        if (suerte == 1) {
                            players[i].cambiarVida(15);
                        }
                        //Comprobacion de vida del guardian
                        if (guardian.getVida() == 0) {
                            System.out.println("\"El jugador \" + players[i].getName() + \" es el ganador!!!!\"");
                            estado = true;
                        }
                        players[i].cambiarPosicion(dado);
                        if (players[i].getPosicion() == (casilla - 1)) {
                            System.out.println("El jugador " + players[i].getName() + " es el ganador!!!!");
                            estado = true;
                        } else {
                            int position = players[i].getPosicion();
                            char letra = tablero[position];
                            System.out.println(letra);
                            switch (letra) {
                                case 'B':
                                    break;
                                case 'P':
                                    casillaPortal(players[i], i, tablero);
                                    break;
                                case 'S':
                                    casillaSalud(players[i]);
                                    break;
                                case 'D':
                                    casillaDesafio(players, i);
                                    break;
                                default:
                                    System.out.println("Hola");
                                    break;
                            }
                        }
                        break;
                    case 2:
                        meditar(players[i], tablero);
                        break;
                    default:
                        System.out.println("Has perdido tu turno por baka");
                        break;
                }
            }

        } while (!estado);
    }

    public static int cantidadJugadores() {
        int numjug = 0;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Cuantos jugadores van a jugar? ");
                numjug = sc.nextInt();
                while (numjug < 1) {
                    System.out.println("El número mínimo de jugadores es 1, intente denuevo");
                    numjug = sc.nextInt();
                }
                System.out.println("El numero de jugadores es de : " + numjug);
                break;
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un número");
            }
        }
        return numjug;
    }

    public static String nombreJugador() {
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador :");
        nombre = sc.nextLine();
        return nombre;
    }

    public static int numeroCasilla() {
        int casilla = 0;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese el número de casillas que desea ocupar, no debe ser menor que 20");
                casilla = sc.nextInt();
                while (casilla < 20) {
                    System.out.println("El número que has ingresado es menor que 20, intenta denuevo");
                    casilla = sc.nextInt();
                }
                System.out.println("El número de casillas selecionadas es de: " + casilla);
                break;

            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un número");
            }
        }
        return casilla;
    }

//    public static char[] creacionTablero(int numerocasilla) {
//        char tablero[] = new char[numerocasilla];
//        //Array de char que contiene cada casilla especial: B=Blanco, P=Portal, S=Salud, D=Desafio
//        char casilla[] = {'B', 'P', 'S', 'D'};
//        //Designar el inicio y el final del tablero con la A y la Z
//        tablero[0] = 'A';
//        tablero[numerocasilla - 1] = 'Z';
//        //LLenado de casillas 
//        for (int i = 1; i < (tablero.length - 2); i++) {
//            int idx = new Random().nextInt(casilla.length);
//            tablero[i] = casilla[idx];
//        }
//        return tablero;
//    }
//    public static int lanzarDados() {
//        int dado[] = {1, 2, 3, 4, 5, 6};
//        int idx = new Random().nextInt(dado.length);
//        int dado1 = dado[idx];
//        int dado2 = dado[idx];
//        int sumaDado = (dado1 + dado2);
//        System.out.println("La suma de tus dados es " + sumaDado);
//        return sumaDado;
//    }
    public static void casillaDesafio(Jugador[] players, int indice) {
        System.out.println("Has caido en la casilla desafio!");
        //Dos tipos de desafios, 0 es avanzar retroceder y 1 es agregar o quitar vida
        //el indice es donde esta el jugador que cae en esa casilla
        int desafio = (int) (Math.random() * 2);
        switch (desafio) {
            case 0:
                int direccion = (int) (Math.random() * 2); //0 negativo, 1 positivo
                int cantidad = (int) ((Math.random() * 6) + 1);//cantidad de posiciones
                switch (direccion) {
                    case 0:
                        players[indice].cambiarPosicion(-cantidad);
                        System.out.println("Has retrocedido " + cantidad + " de casillas");
                        break;
                    case 1:
                        players[indice].cambiarPosicion(cantidad);
                        System.out.println("Has avanzado " + cantidad + " de casillas");
                        break;
                }
                break;
            case 1:
                int cantidadVida = (int) ((Math.random() * 5) + 1);//cantidad de vida
                int signo = (int) (Math.random() * 2);
                switch (signo) {
                    case 0:
                        for (int i = 0; i < players.length; i++) {
                            players[i].cambiarVida(-cantidadVida);
                        }
                        players[indice].cambiarVida(+cantidadVida);
                        System.out.println("Se ha restado la vida de todos en " + cantidadVida);
                        break;
                    case 1:
                        for (int i = 0; i < players.length; i++) {
                            players[i].cambiarVida(cantidadVida);
                        }
                        players[indice].cambiarVida(-cantidadVida);
                        System.out.println("Se ha aumentado la vida de todos en " + cantidadVida);
                        break;
                }
                break;
        }
    }

    public static void casillaPortal(Jugador players, int indice, char tablero[]) {
        System.out.println("Has caido en una casilla de portal!");
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == 'P') {
                if (i > players.getPosicion()) {
                    players.setPosicion(i);
                    System.out.println("Has sido transportado a la casilla " + i);
                    break;
                }
            }
        }
    }

    public static void casillaSalud(Jugador players) {
        System.out.println("Has caido en una casilla de salud!");
        int vida = (int) ((Math.random() * 4) + 1);
        int signo = (int) (Math.random() * 2);
        if (signo == 0) {
            players.cambiarVida(-vida);
            System.out.println("Se te ha restado " + vida + " vida");
        } else if (signo == 1) {
            players.cambiarVida(vida);
            System.out.println("Se te ha sumado " + vida + " vida");
        }
    }

    public static void mostrarTabla(Jugador[] players) {
        System.out.println("NickName " + "\t" + "Puntos de salud " + "\t" + "Posición actual");
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + "\t" + players[i].getSalud() + "\t" + players[i].getPosicion());
        }
    }

    public static void meditar(Jugador players, char tablero[]) {
        System.out.println("Has elegido meditar");
        int oportunidades = players.getMeditar();
        if (oportunidades == 0) {
            System.out.println("Tus oportunidades se han acabado, se ha restado 1 punto de salud por tu insolencia");
            players.cambiarVida(-1);
        } else {
            while (true) {
                try {
                    players.restarMeditar();
                    int position = players.getPosicion();
                    char letra = tablero[position];
                    System.out.println("Tu posición actual es : " + position + letra);
                    System.out.println("Puedes elegir una nueva posicion 3 casillas a la redonda");
                    System.out.println("Que casilla eligiras?");
                    Scanner sc = new Scanner(System.in);
                    int eleccion = sc.nextInt();
                    while (eleccion > (position + 3) || eleccion < (position - 3)) {
                        System.out.println("No puedes elegir un valor afuera de las 3 casillas a la redonda, intenta denuevo");
                        eleccion = sc.nextInt();
                    }
                    players.setPosicion(eleccion);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Te has ido fuera del tablero, intenta denuevo");
                }
            }

        }
        //El erro mas comun que va a ocurrir es un out of bounds, eso significa 
        // hacer lo mismo que en los metodos que arregue de tablero y pedir jugadores
    }
}
