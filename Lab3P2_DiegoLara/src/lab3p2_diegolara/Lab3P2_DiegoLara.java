package lab3p2_diegolara;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3P2_DiegoLara {

    static Scanner cinq = new Scanner(System.in);
    static Scanner cordes = new Scanner(System.in);
    static ArrayList<Aplicaciones> app = new ArrayList();

    public static void main(String[] args) {
        boolean menuP = true;
        while (menuP) {
            System.out.println("1. Administrador");
            System.out.println("2. Usuario");
            System.out.println("3. Salir");
            int opP = cinq.nextInt();
            switch (opP) {
                case 1 -> {
                    boolean menuA = true;
                    while (menuA) {
                        System.out.println("1. Agregar Aplicacion");
                        System.out.println("2. Biblioteca");
                        System.out.println("3. Actualizacion");
                        System.out.println("4. Eliminar Aplicacion");
                        System.out.println("5. Estadisticas de Desarrollador");
                        System.out.println("6. Salir");
                        int opA = cinq.nextInt();
                        switch (opA) {
                            case 1 -> {
                                boolean menuAdd = true;
                                while (menuAdd) {
                                    System.out.println("1. Applicacion de juego");
                                    System.out.println("2. Aplicacion de utilidad");
                                    System.out.println("3. Salir");
                                    int opAdd = cinq.nextInt();

                                    switch (opAdd) {
                                        case 1 -> {
                                            addAppJuego();
                                        }
                                        case 2 -> {
                                            addAppUtilidad();
                                        }
                                        case 3 -> {
                                            menuAdd = false;
                                        }
                                        default -> {
                                            System.out.println("Opcion Invalida");
                                        }
                                    }
                                }
                            }
                            case 2 -> {
                                Biblioteca();
                            }
                            case 3 -> {
                                if (app.isEmpty()) {
                                    System.out.println("No hay aplicaciones al momento");
                                } else {
                                    Biblioteca();
                                    System.out.println("Ingrese el numero del app que desea actualizar: ");
                                    int act = cinq.nextInt() - 1;
                                    Actualizar(act);
                                }
                            }
                            case 4 -> {
                                if (app.isEmpty()) {
                                    System.out.println("No hay aplicaciones al momento");
                                } else {
                                    Biblioteca();
                                    System.out.println("Ingrese el app que desea eliminar: ");
                                    int elim = cinq.nextInt() - 1;
                                    app.remove(elim);
                                }
                            }
                            case 5 -> {
                                for (Aplicaciones a : app) {
                                    System.out.println("Nombre: " + a.getNombre() + "Descargas: " + a.getDescargas() + "Rating: " + a.getRating());
                                }
                            }
                            case 6 -> {
                                menuA = false;
                            }
                            default -> {
                                System.out.println("Opcion Invalida");
                            }
                        }
                    }
                }
                case 2 -> {
                    boolean menuU = true;
                    while (menuU) {
                        System.out.println("1. Buscar por nombre");
                        System.out.println("2. Buscar por Categoria");
                        System.out.println("3. Biblioteca");
                        System.out.println("4. Mostrar Descargas");
                        System.out.println("5. Eliminar Descargar");
                        System.out.println("6. Calificar Aplicacion");
                        System.out.println("7. Salir");
                        int opU = cinq.nextInt();
                        
                        switch (opU) {
                            case 1 -> {
                                if (app.isEmpty()) {
                                    System.out.println("No hay apps");
                                } else {
                                    BuscarPorNombre();
                                }
                            }
                            case 2 -> {
                                if (app.isEmpty()) {
                                    System.out.println("No hay apps");
                                } else {
                                    BuscarPorCategoria();
                                }
                            }
                            case 3 -> {
                                Biblioteca();
                            }
                            case 4 -> {
                                printDesc();
                            }
                            case 5 -> {
                                eliminarDesc();
                            }
                            case 6 -> {
                                Calificar();
                            }
                            case 7 -> {
                                menuU = false;
                            }
                            default -> {
                                System.out.println("Opcion Invalida");
                            }
                        }
                    }
                }
                case 3 -> {
                    menuP = false;
                }
                default -> {
                    System.out.println("Opcion Invalida");
                }
            }
        }
    }

    public static void addAppJuego() {
        System.out.println("Ingrese el nombre de la aplicacion: ");
        String nombre = cordes.next();
        System.out.println("Ingrese el desarrollador: ");
        String desarrollador = cordes.next();
        System.out.println("Ingrese el precio: ");
        double precio = cinq.nextDouble();
        ValidarDouble(precio);
        System.out.println("Ingrese la edad recomendada: ");
        int edad = cinq.nextInt();
        ValidarInt(edad);
        app.add(new Juegos(nombre, desarrollador, precio, edad));
        System.out.println("Agregado exitosamente");
    }

    public static void addAppUtilidad() {
        System.out.println("Ingrese el nombre de la aplicacion: ");
        String nombre = cordes.next();
        System.out.println("Ingrese la categoria: ");
        String categoria = cordes.next();
        System.out.println("Ingrese el desarrollador: ");
        String desarrollador = cordes.next();
        System.out.println("Ingrese el precio: ");
        double precio = cinq.nextDouble();
        ValidarDouble(precio);
        app.add(new Utilidad(nombre, desarrollador, precio, categoria));
        System.out.println("Agregado exitosamente");
    }

    public static void Biblioteca() {
        boolean hay = false;
        boolean hay2 = false;
        for (Aplicaciones a : app) {
            if (a instanceof Utilidad) {
                hay = true;
                break;
            }
        }
        if (!hay) {
            System.out.println("No hay applicaciones de esta categoria");
        } else {
            System.out.println("Apps de Utilidad");
            for (Aplicaciones a : app) {
                if (a instanceof Utilidad) {
                    System.out.println("App: " + (app.indexOf(a) + 1));
                    System.out.println(a);
                }
            }
        }
        for (Aplicaciones a : app) {
            if (a instanceof Juegos) {
                hay2 = true;
                break;
            }
        }
        if (!hay2) {
            System.out.println("No hay aplicaciones en esta categoria");
        } else {
            System.out.println("Apps de Juegos");
            for (Aplicaciones a : app) {
                if (a instanceof Juegos) {
                    System.out.println("App: " + (app.indexOf(a) + 1));
                    System.out.println(a);
                }
            }
        }
    }

    public static void Actualizar(int id) {
        boolean menuAU = true;
        while (menuAU) {
            System.out.println("Que desea cambiar");
            System.out.println("1. Actualizar nombre");
            System.out.println("2. Actualizar desarrollador");
            System.out.println("3. Actualizar precio");
            System.out.println("4. Salir");
            int ac = cinq.nextInt();
            switch (ac) {
                case 1 -> {
                    System.out.println("Ingrese el nuevo nombre: ");
                    String nombreN = cordes.next();
                    app.get(id).setNombre(nombreN);

                    System.out.println("Se ha actualizado exitosamente");
                }
                case 2 -> {
                    System.out.println("Ingrese el nuevo desarrollador: ");
                    String desarrolladorN = cordes.next();
                    app.get(id).setDesarrollador(desarrolladorN);
                    System.out.println("Se ha actualizado exitosamente");
                }
                case 3 -> {
                    System.out.println("Ingrese el nuevo precio: ");
                    double precioN = cinq.nextDouble();
                    ValidarDouble(precioN);
                    app.get(id).setPrecio(precioN);
                    System.out.println("Se ha actualizado exitosamente");
                }
                case 4 -> {
                    menuAU = false;
                }
            }
        }

    }

    public static void BuscarPorNombre() {
        System.out.println("Ingrese el nombre del app: ");
        String nombreB = cordes.next();
        for (Aplicaciones a : app) {
            if (nombreB.equals(a.getNombre())) {
                System.out.println("Aplicacion encontrada. Para descargar presione 1, en caso de no descargar precione 2");
                int desc = cinq.nextInt();
                switch (desc) {
                    case 1 -> {
                        a.setDescargas(a.getDescargas() + 1);
                        a.setEstado("Descargado");
                        System.out.println("Aplicacion Descargada exitosamente");
                    }
                    case 2 -> {
                        a.setEstado("No Descargado");
                    }
                    default -> {
                        System.out.println("Opcion Invalida");
                    }
                }

            } else {
                System.out.println("No se encontro la aplicacion");
            }
        }
    }

    public static void BuscarPorCategoria() {
        for (Aplicaciones a : app) {
            if (a instanceof Utilidad) {
                System.out.println((app.indexOf(a) + 1) + "Categoria: " + ((Utilidad) a).getCategoria());
            }
        }
        System.out.println("Ingrese el indice de la categoria del app: ");
        int nombreG = cinq.nextInt() - 1;
        ValidarInt(nombreG);
        for (Aplicaciones a : app) {
            if (a instanceof Utilidad) {
                if (((Utilidad) a).getCategoria().equals(((Utilidad) app.get(nombreG)).getCategoria())) {
                    System.out.println("App " + (app.indexOf(a) + 1) + ": " + a);
                    System.out.println("Categoria encontrada. Para descargar presione 1, en caso de no descargar precione 2");
                    int desc = cinq.nextInt();
                    switch (desc) {
                        case 1 -> {
                            a.setDescargas(a.getDescargas() + 1);
                            a.setEstado("Descargado");
                            System.out.println("Aplicacion Descargada exitosamente");
                        }
                        case 2 -> {
                            a.setEstado("No descargado");
                        }
                        default -> {
                            System.out.println("Opcion Invalida");
                        }
                    }
                } else {
                    System.out.println("La categoria no es igual");
                }
            } else {
                System.out.println("No se encontro la aplicacion de utilidad");
            }
        }
    }

    public static void printDesc() {
        for (Aplicaciones a : app) {
            if (a.getEstado().equals("Descargado")) {
                System.out.println("Descargadas: " + (app.indexOf(a) + 1) + ": " + a);
            }
        }
    }

    public static void eliminarDesc() {
        printDesc();
        System.out.println("Ingrese el indice del app que desea desinstalar: ");
        int elim = cinq.nextInt() - 1;
        ValidarInt(elim);
        app.get(elim).setEstado("No descargado");
        System.out.println("App desinstalado exitosamente");
    }

    public static void Calificar() {
        for (Aplicaciones a : app) {
            if (a.getEstado().equals("Descargado")) {
                System.out.println("Descargadas: " + (app.indexOf(a) + 1) + ": " + a);
            }
        }
        System.out.println("Ingrese el indice del que desee calificar: ");
        int cal = cinq.nextInt() - 1;
        ValidarInt(cal);
        System.out.println("Ingrese el rating que desea ponerle(0 a 5)");
        int rating = cinq.nextInt();
        while (rating < 0 && rating > 6) {
            System.out.println("Ingrese el rating que se le pide: ");
            rating = cinq.nextInt();
        }
        app.get(cal).setRating(rating);

    }

    public static void ValidarInt(int n) {
        if (n <= 0) {
            System.out.println("Ingrese numeros mayores a 0");
            n = cinq.nextInt();
        }
    }

    public static void ValidarDouble(double n) {
        if (n <= 0) {
            System.out.println("Ingrese numeros mayores a 0");
            n = cinq.nextInt();
        }
    }

}
