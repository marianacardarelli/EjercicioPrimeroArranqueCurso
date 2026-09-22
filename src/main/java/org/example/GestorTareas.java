package org.example;

import java.util.*;

public class GestorTareas {

    static ArrayList<Tarea> tareas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("1. Añadir tarea");
        System.out.println("2. Ver tareas pendientes");
        System.out.println("3. Marcar tarea completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.println();
        System.out.print("Elige tu opción: ");
    }

    public static void elegirOpcion() {
        int opcion;

        do {
            mostrarMenu();
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.next();
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 5);

        switch (opcion) {
            case 1 -> anhadirTarea();
            case 2 -> tareasPendientes();
            case 3 -> tareaCompletada();
            case 4 -> eliminarTarea();
            case 5 -> salir();
        }
    }

    public static void anhadirTarea() {
        String descripcion;

        do {
            System.out.print("Introduce tu tarea: ");
            descripcion = sc.nextLine();
        } while (descripcion.isEmpty());
        int opcion;
        String prioridad;
        System.out.println("Elige la prioridad de la tarea: " + "\n"
                +"1-Baja"
                +"\n"+ "2-Media"
                +"\n"+ "3-Alta");
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1 -> prioridad = "Baja";
            case 2 -> prioridad = "Media";
            case 3 -> prioridad = "Alta";
            default -> prioridad = "Sin definir";
        }

        tareas.add(new Tarea(descripcion, false, prioridad));

        tareasPendientes();
        elegirOpcion();
    }

    public static void tareasPendientes() {
        System.out.println("--- LISTA DE TAREAS PENDIENTES ---");
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);

            if (!tarea.isCompletado()) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
        System.out.println("--------------------------------");
        elegirOpcion();
    }

    public static void mostrarTareas() {
        System.out.println("--- LISTA DE TAREAS ---");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
        System.out.println("--------------------------------");
    }

    public static void tareaCompletada() {
        int tarea;

        System.out.print("Escribe el número de tarea: ");
        tarea = sc.nextInt();
        sc.nextLine();

        try {
            tareas.get(tarea - 1).setCompletado(true);
            tareasPendientes();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe la tarea.");
            elegirOpcion();
        }
    }

    public static void eliminarTarea() {
        int tarea;

        mostrarTareas();

        System.out.print("Escribe la tarea a borrar: ");
        tarea = sc.nextInt();
        sc.nextLine();

        try {
            tareas.remove(tarea - 1);
            System.out.println("Tarea borrada correctamente");
            mostrarTareas();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe la tarea.");
            elegirOpcion();
        }
    }

    public static void salir() {
        System.exit(0);
    }
}