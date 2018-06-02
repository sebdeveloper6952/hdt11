package com.uvg.hdt11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class EntryPoint {

    private static final String fileName = "src/guategrafo.txt";

    public static void main(String[] args) {
        // inicializar grafo
        GraphMatrixDirected<String, Float> grafo =  new GraphMatrixDirected<>(50);
        // leer archivo para crear grafo
        iniciarGrafo();
        System.out.println("Se agregaron las ciudades al grafo...");
        // loop
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        while(opcion != 3) {
            mostrarMenu();
            opcion = Integer.parseInt(s.next());
            switch (opcion) {
                case 1:
                    String ciudad1, ciudad2;
                    Float distancia;
                    System.out.println("Ingrese ciudad1: ");
                    ciudad1 = s.next();
                    System.out.println("Ingrese ciudad2: ");
                    ciudad2 = s.next();
                    System.out.println("Ingrese distancia: ");
                    distancia = Float.parseFloat(s.next());
                    if(distancia < 0f) {
                        System.out.println("No se permite distancia negativa.");
                    }
                    if(!grafo.addEdge(ciudad1, ciudad2, distancia)) {
                        System.out.println("Error en nombre de ciudad.");
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando algoritmo de Floyd...");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                    default:
                        break;
            }
        }

    }

    private static void mostrarMenu() {
        System.out.println("************ Menu ************");
        System.out.println("1. Agregar aristas");
        System.out.println("2. Ejecutar algoritmo de Floyd");
        System.out.println("3. Salir del programa");
        System.out.print("Ingrese numero de opcion: ");
    }

    private static void iniciarGrafo() {
        try {
            BufferedReader rdr = new BufferedReader(new FileReader(fileName));
            String line = rdr.readLine();
            while(line != null) {
                String[] parts = line.split(" ");
                if(parts.length != 3) {
                    System.out.println("guategrafo.txt: Error en formato.");
                    return;
                }

                line = rdr.readLine();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
