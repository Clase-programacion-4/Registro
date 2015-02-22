/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniajc.registro;

import co.edu.uniajc.registro.datos.Estudiante;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author estudiante101
 */
public class Main {
    private List<Estudiante> estudiantes;
    private Scanner _scanner;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001B[1m";

    public Main(Scanner scanner) {
        this.estudiantes = new ArrayList<>();
        this._scanner = scanner;

        // estudiantes.add(new Estudiante("Alex Roldán HD", 1, "UniAJC", "Sistemas"));
        // estudiantes.add(new Estudiante("Carlos Andrés Muñoz", 2, "UniAJC", "Sistemas"));
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.printf("\n%s%sMenu%s\n", ANSI_BOLD, ANSI_BLUE, ANSI_RESET);
            opcion("1", "crear estudiante");
            opcion("2", "listar estudiantes");
            opcion("3", "guardar listado de estudiantes");
            opcion("4", "recuperar listado de estudiantes");
            opcion("0", "salir");
            System.out.print("Haga su seleccion:\t");
            char selection = readChar();
            switch (selection){
                case '1':
                    agregarEstudiante();
                    break;
                case '2':
                    listarEstudiantes();
                    break;
                case '3':
                    guardarArchivo("estudiantes.csv");
                    break;
                case '4':
                    leerArchivo("estudiantes.csv");
                    break;
                case '0':
                    exit = true;
            }
        }
        System.out.printf("%sAplicación cerrada.\n", ANSI_PURPLE);
    }

    private void guardarArchivo(String fileName){
        try {
            File file = new File(fileName);
            FileUtils.writeLines(file, estudiantes, false);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("Error : %s", e.getMessage());
        }
    }

    private void leerArchivo(String fileName){
        try {
            File file = new File(fileName);
            List<String> lista = FileUtils.readLines(file, Charset.defaultCharset());
            estudiantes.clear();
            for (String datos : lista) {
                estudiantes.add(new Estudiante(datos));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("Error : %s", e.getMessage());
        }
    }

    private char readChar() {
        char result = 0;
        String line = _scanner.nextLine();
        if(line.isEmpty()){
            System.out.printf("%sno se capturo nada, se espera un caracter, intentalo de nuevo!%s\n", ANSI_RED, ANSI_RESET );
            result = readChar();
        }else if(line.length()>1){
            System.out.printf("%sse capturo  '%s', se espera un caracter, intentalo de nuevo!%s\n", ANSI_RED, line, ANSI_RESET );
            result = readChar();
        }else{
            result = line.charAt(0);
        }
        return result;
    }

    private void opcion(String key, String accion) {
        System.out.printf("%s%s(%s)%s - %s\n", ANSI_BOLD, ANSI_YELLOW, key, ANSI_RESET, accion);
    }

    private String readLine(){
        return _scanner.nextLine();
    }

    private int readInt(){
        int result = 0;
        String line = "";
        try {
            line = _scanner.nextLine();
            result = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.printf("%sse capturo  '%s', se espera un número, intentalo de nuevo!%s\n", ANSI_RED, line, ANSI_RESET );
            result = readInt();
        }
        return result;
    }

    private void agregarEstudiante() {
        Estudiante nuevo = new Estudiante();
        System.out.print("Crear un estudiante\n");
        System.out.println("Nombre:\t");
        nuevo.setNombre(readLine());
        System.out.println("Codigo:\t");
        nuevo.setCodigo(readInt());
        System.out.println("Universidad:\t");
        nuevo.setUniversidad(readLine());
        System.out.println("Programa:\t");
        nuevo.setPrograma(readLine());
        estudiantes.add(nuevo);
    }

    private void listarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        Main app = new Main(new Scanner(System.in));
        app.menu();
    }
}
