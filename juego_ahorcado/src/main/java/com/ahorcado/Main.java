package com.ahorcado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        
        ArrayList<String> palabras = new ArrayList<String>(Arrays.asList("codigo", "compilador", "arreglo", "javascript", "terminal", "metodo", "funcion", "software", "sistema", "datos"));
    
        Random palrand = new Random();
        int index = palrand.nextInt(palabras.size());
        String palselecc = palabras.get(index);
        StringBuilder progreso = new StringBuilder("_ ".repeat(palselecc.length()));

        ArrayList<Character> letrasAdivinadas = new ArrayList<>();
        int intentos = palselecc.length();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Bienvenido al juego del Ahorcado!");

        while (intentos > 0 && progreso.toString().contains("_")) {
            System.out.println(" ");
            System.out.println("Tienes " + intentos + " intentos");
            System.out.println("Adivina la palabra: " + progreso);
            System.out.print("Introduce una letra: ");
            char letra = scanner.next().charAt(0);

            if (letrasAdivinadas.contains(letra)) {
                System.out.println(" ");
                System.out.println("*Ya has adivinado esa letra. Intenta de nuevo*");
            } else if (palselecc.contains(String.valueOf(letra))) {
                letrasAdivinadas.add(letra);

                for (int i = 0; i < palselecc.length(); i++) {
                    if (letra == palselecc.charAt(i)) {
                        progreso.setCharAt(i*2, letra);
                    }
                }
                
            } else {
                intentos--;
            }
        }

        String palabrafinal = progreso.toString().replace(" ", "");
        
        if (palabrafinal.equals(palselecc)) {
            System.out.println(" ");
            System.out.println("FELICITACIONES! Has adivinado la palabra!");
        } else {
            System.out.println(" ");
            System.out.println("Has perdido! La palabra era: " + palselecc);
        }

    }


}