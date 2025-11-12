package com.clases;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class permutaciones_k {

    // --- DEFINA SUS VALORES AQUÍ ---
    private static final String[] SET = {"AB", "C", "D", "E"};
    private static final int K = 3; // k: El largo de la selección (k <= N)
    private static final int N = SET.length; // n: El total de elementos
    // ---------------------------------

    public static void main(String[] args) {
        if (K > N) {
            System.out.println("Error: K no puede ser mayor que N.");
            return;
        }

        List<String> resultados = new ArrayList<>();
        boolean[] usados = new boolean[N]; // Checklist para P(n,k)
        
        generarPermutacionesK(new ArrayList<String>(), usados, resultados);

        // --- Bloque de Impresión (Consola y TXT) ---
        String nombreArchivo = "permutaciones_k.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            
            System.out.println("--- k-Permutaciones P(n, k) | P(" + N + ", " + K + ") ---\n");
            writer.write("--- k-Permutaciones P(n, k) | P(" + N + ", " + K + ") ---\n");

            for (String p : resultados) {
                System.out.println(p);      // Imprime en Consola
                writer.write(p);            // Escribe en Archivo
                writer.newLine();           // Añade salto de línea en Archivo
            }

            String total = String.format("%nTotal: %d", resultados.size());
            System.out.println(total);
            writer.write(total);

            System.out.println("\nResultados guardados en " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
        // --- Fin del Bloque de Impresión ---
    }

    /**
     * Función recursiva (backtracking) para generar k-permutaciones
     */
    private static void generarPermutacionesK(ArrayList<String> actual, boolean[] usados, List<String> resultados) {
        // CASO BASE: La palabra ya tiene el largo K
        if (actual.size() == K) {
            resultados.add(actual.toString());
            return;
        }

        // CASO RECURSIVO: Probar todas las fichas
        for (int i = 0; i < N; i++) {
            if (!usados[i]) {
                // 1. Elegir
                usados[i] = true;
                actual.add(SET[i]);

                // 2. Explorar
                generarPermutacionesK(actual, usados, resultados);

                // 3. Des-elegir (Backtrack)
                actual.remove(actual.size() - 1);
                usados[i] = false;
            }
        }
    }
}