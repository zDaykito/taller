package Controller;

import java.util.ArrayList;

import Model.Data;
import Model.Juegos;
import Model.Libros;
import Model.Peliculas;
import Model.Usuario;
import View.Menu;

public class Controlador {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Peliculas> listaPeliculas;
    private ArrayList<Libros> listaLibros;
    private ArrayList<Juegos> listaJuegos;
    private String directorioUsuarios;
    private String directorioPeliculas;
    private String directorioLibros;
    private String directorioJuegos;
    private Menu menu;
    private Data data;

    public Controlador() {
        menu = new Menu();
        data = new Data();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = menu.menuLogin();
            switch (opcion) {
                case 1:
                int opcionAdmin;
                do {
                    opcionAdmin = menu.menuAdmin();
                    switch (opcionAdmin) {
                        case 1:
                            int opcionAgregarContenido = menu.menuAgregarContenido();
                            switch (opcionAgregarContenido) {
                                case 1:
                                    data.agregarPelicula();
                                    break;
                                case 2:
                                    data.agregarLibro();
                                    break;
                                case 3:
                                    data.agregarJuego();
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                            }
                            break;
                        case 2:
                            int opcionEliminarContenido = menu.menuEliminarContenido();
                            switch (opcionEliminarContenido) {
                                case 1:
                                    data.eliminarPeliculaId(opcionAdmin);
                                    break;
                                case 2:
                                    data.eliminarLibroId(opcionAdmin);
                                    break;
                                case 3:
                                    data.eliminarJuegoId(opcionAdmin);
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                            }
                            break;
                        case 3:
                            int opcionEditarContenido = menu.menuEditarContenido();
                            switch (opcionEditarContenido) {
                                case 1:
                                    data.editarPelicula();
                                    break;
                                case 2:
                                    data.editarLibro();
                                    break;
                                case 3:
                                    data.editarJuego();
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                            }
                            break;
                        case 4:
                            int opcionBanearUsuario = menu.menuBanearUsuario();
                            switch (opcionBanearUsuario) {
                                case 1:
                                    data.banearUsuario();
                                    break;
                                case 2:
                                    data.desbanearUsuario();
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                            }
                            break;
                        case 5:
                            System.out.println("Ingrese el ID del Usuario para ver su biblioteca personal:");
                            int idUsuarioBiblioteca = sc.nextInt();
                            data.verBibliotecaPersonal(idUsuarioBiblioteca);
                            break;
                        case 6:
                            System.out.println("Volviendo al menú principal..");
                            break;
                        default:
                            System.out.println("Opción no válida. Inténtalo de nuevo.");
                    }
            
                } while (opcionAdmin != 7);
                    break;
                case 2:
                    boolean clienteAutenticado = data.autenticarCliente();
                    if (clienteAutenticado) {
                        int opcionCliente;
                        do {
                            opcionCliente = menu.menuCliente();
                            switch (opcionCliente) {
                                case 1:
                                    int opcionVerContenido = menu.menuVerContenidoCliente();
                                    switch (opcionVerContenido) {
                                        case 1:
                                            menu.mostrarPeliculas(listaPeliculas);
                                            break;
                                        case 2:
                                            data.agregarPeliculaPorNombre();
                                            break;
                                        case 3:
                                            data.agregarPeliculaPorDirector();
                                            break;
                                        case 4:
                                            menu.mostrarLibros(listaLibros);
                                            break;
                                        case 5:
                                            data.agregarLibroPorTitulo();
                                            break;
                                        case 6:
                                            data.agregarLibroPorAutor();
                                            break;
                                        case 7:
                                            menu.mostrarJuegos(listaJuegos);
                                            break;
                                        case 8:
                                            data.agregarJuegoPorNombre();
                                            break;
                                        case 9:
                                            data.agregarJuegoPorPlataforma();
                                            break;
                                        default:
                                            System.out.println("Opción no válida. Inténtalo de nuevo.");
                                    }
                                    break;
                                case 2:
                                    data.verListaAmigos(opcion);
                                    break;
                                case 3:
                                    data.verListaDeseos(opcion);
                                    break;
                                case 4:
                                    data.verListaFavoritos(opcion);
                                    break;
                                case 5:
                                    System.out.println("Volviendo al menú principal..");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                            }
                
                        } while (opcionCliente != 5);
                    } else {
                        System.out.println("Error, Verifica los datos.");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 4);
    }


}