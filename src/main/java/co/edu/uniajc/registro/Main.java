/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniajc.registro;

import co.edu.uniajc.registro.datos.Estudiante;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author estudiante101
 */
public class Main {
    private static List<Estudiante> estudiantes;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        estudiantes = new ArrayList<>();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu\n");
            System.out.println("(1) - crear estudiante");
            System.out.println("(2) - listar estudiantes");
            System.out.println("(0) - salir");

            System.out.print("Haga su seleccion:\t");
            String selection = scanner.nextLine();
            if (selection.equals("1")) {
                agregarEstudiante();
            } else if (selection.equals("2")) {
                listarEstudiantes();
            } else if (selection.equals("0")) {
                break;
            }
        }
    }

    private static void agregarEstudiante() {
        Estudiante nuevo = new Estudiante();
        System.out.print("Crear un estudiante\n");
        String valor = "";
        System.out.println("Nombre:\t");
        valor = scanner.nextLine();
        nuevo.setNombre(valor);
        System.out.println("Codigo:\t");
        valor = scanner.nextLine();
        nuevo.setCodigo(Integer.parseInt(valor));
        System.out.println("Universidad:\t");
        valor = scanner.nextLine();
        nuevo.setUniversidad(valor);
        System.out.println("Programa:\t");
        valor = scanner.nextLine();
        nuevo.setPrograma(valor);
        System.out.println(nuevo);
        estudiantes.add(nuevo);
    }

    private static void listarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
