package com.company;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        sorts sorts = new sorts();
	    // escribir archivo
        FileWriter ficheros = null;
        File archivos = new File("datos.txt");
        Scanner s = null;
        String linea = "";
        try{
            s = new Scanner("datos.txt");
            ficheros= new FileWriter("datos.txt");
            for(int i = 0; i<3000; i++) {
                int n = rand.nextInt(50);
                linea= linea + "\n" + Integer.toString(n);
            }
            ficheros.write(linea);
            ficheros.close();
        }
        catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }

        // leer archivo y guardar en array (guardar los numeros random en una var)
        File fichero = new File("datos.txt");
        linea = "";
        try{
            s = new Scanner(fichero);
            while(s.hasNextLine()){
                linea = linea + s.nextLine() + "/";
            }
        }
        catch(Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        finally{
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null)
                    s.close();

            }
            catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        String[] numerosString = linea.split("/");
        int[] numeros = new int[numerosString.length];
        for (int i = 0; i < numerosString.length; i++) {
            numeros[i] = Integer.parseInt(numerosString[i]);
        }

        // ordenar por selection sort
        int[] numerosOrdenados = sorts.selectionSort(numeros);

        // mostrar tiempo

        // ordenar por selection sort (ya ordenado = otra var)
        numerosOrdenados = sorts.selectionSort(numerosOrdenados);

        // mostrar tiempo 2

        // ordenar por merge sort
        sorts.mergeSort(numeros, 0, numeros.length-1);

        // mostrar tiempo

        // ordenar por merge sort (ya ordenado = otra var)
        sorts.mergeSort(numerosOrdenados, 0, numerosOrdenados.length-1);

        // mostrar tiempo 2

        // ordenar por quick sort
        sorts.quickSort(numeros,0, numeros.length-1);

        // mostrar tiempo

        // ordenar por quick sort (ya ordenado = otra var)
        sorts.quickSort(numerosOrdenados, 0,numerosOrdenados.length-1);

        // mostrar tiempo 2

        // ordenar por radix sort
        sorts.radixSort(numeros, numeros.length);

        // mostrar tiempo

        // ordenar por radix sort (ya ordenado = otra var)
        sorts.radixSort(numerosOrdenados, numerosOrdenados.length);

        // mostrar tiempo 2

        // ordenar por bubble sort
        sorts.bubbleSort(numeros);

        // mostrar tiempo

        // ordenar por bubble sort (ya ordenado = otra var)
        sorts.bubbleSort(numerosOrdenados);
        // mostrar tiempo 2

    }
}
