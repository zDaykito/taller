package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private String directorioUsuarios;
    private String directorioPeliculas;
    private String directorioLibros;
    private String directorioJuegos;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Peliculas> listaPeliculas;
    private ArrayList<Libros> listaLibros;
    private ArrayList<Juegos> listaJuegos;

    /* CONSTRUCTOR */
    public Data() {}
    public Data(String directorioUsuarios, String directorioPeliculas, String directorioLibros, String directorioJuegos) {
        this.directorioUsuarios = directorioUsuarios;
        this.directorioPeliculas = directorioPeliculas;
        this.directorioLibros = directorioLibros;
        this.directorioJuegos = directorioJuegos;
    }

    /* GETTERS */

    public String getDirectorioUsuarios() {
        return directorioUsuarios;
    }

    public String getDirectorioPeliculas() {
        return directorioPeliculas;
    }

    public String getDirectorioLibros() {
        return directorioLibros;
    }

    public String getDirectorioJuegos() {
        return directorioJuegos;
    }

    /* SETTERS */

    public void setDirectorioPeliculas(String directorioPeliculas) {
        this.directorioPeliculas = directorioPeliculas;
    }

    public void setDirectorioLibros(String directorioLibros) {
        this.directorioLibros = directorioLibros;
    }

    public void setDirectorioJuegos(String directorioJuegos) {
        this.directorioJuegos = directorioJuegos;
    }

    public void setDirectorioUsuarios(String directorioUsuarios) {
        this.directorioUsuarios = directorioUsuarios;
    }

    /* METODOS ADMIN */

    public void agregarPelicula() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre de la Película: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el Director de la Película: ");
            String director = sc.nextLine();
            Peliculas nuevaPelicula = new Peliculas(nombre, 0, 0, director, director, 0);
            listaPeliculas.add(nuevaPelicula);
        }
        System.out.println("Película agregada");
    }

    public void agregarLibro() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Titulo del Libro: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el Autor del Libro: ");
            String autor = sc.nextLine();
            Libros nuevoLibro = new Libros(nombre, 0, 0, autor, autor, 0);
            listaLibros.add(nuevoLibro);
        }
        System.out.println("Libro agregado");
    }

    public void agregarJuego() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre del Juego: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la Plataforma del Juego: ");
            String plataforma = sc.nextLine();
            Juegos nuevoJuego = new Juegos(nombre, 0, 0, plataforma, plataforma, plataforma);
            listaJuegos.add(nuevoJuego);
        }
        System.out.println("Juego Agregado");
    }

    public void eliminarPeliculaId(int id) {
        for (int i = 0; i < this.listaPeliculas.size(); i++) {
            if (this.listaPeliculas.get(i).getId() == id) {
                this.listaPeliculas.remove(i);
                return;
            }
        }
    }

    public void eliminarLibroId(int id) {
        for (int i = 0; i < this.listaLibros.size(); i++) {
            if (this.listaLibros.get(i).getId() == id) {
                this.listaLibros.remove(i);
                return;
            }
        }
    }

    public void eliminarJuegoId(int id) {
        for (int i = 0; i < this.listaJuegos.size(); i++) {
            if (this.listaJuegos.get(i).getId() == id) {
                this.listaJuegos.remove(i);
                return;
            }
        }
    }

    public void buscarPeliculaPorNombre() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre de la película que desea buscar:");
            String nombrePelicula = sc.nextLine();
            Peliculas peliculaEncontrada = buscarPeliculaPorNombre(nombrePelicula);
            if (peliculaEncontrada != null) {
                System.out.println("Pelicula encontrada:\n" + peliculaEncontrada.toString());
            } else {
                System.out.println("No se encontró la película con ese nombre.");
            }
        }
    }
    
    private Peliculas buscarPeliculaPorNombre(String nombrePelicula) {
        for (Peliculas pelicula : listaPeliculas) {
            if (pelicula.getNombre().equalsIgnoreCase(nombrePelicula)) {
                return pelicula;
            }
        }
        return null;
    }

    public void editarPelicula() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre de la Película que desea Editar:");
            String nombrePelicula = sc.nextLine();
            Peliculas peliculaAEditar = buscarPeliculaPorNombre(nombrePelicula);
            if (peliculaAEditar != null) {
                System.out.println("Información actual de la Película:");
                System.out.println(peliculaAEditar.toString());
                System.out.println("Ingrese el Nuevo Nombre de la Película:");
                String nuevoNombre = sc.nextLine();
                peliculaAEditar.setNombre(nuevoNombre);
                System.out.println("Ingrese el Nuevo Director de la Película:");
                String nuevoDirector = sc.nextLine();
                peliculaAEditar.setDirector(nuevoDirector);
                System.out.println("Película Editada");
            } else {
                System.out.println("No se Encontró la Película con ese Nombre.");
            }
        }
    }

    public void buscarLibroPorNombre() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Titulo del Libro que desea buscar:");
            String nombreLibro = sc.nextLine();
            Libros libroEncontrada = buscarLibroPorNombre(nombreLibro);
            if (libroEncontrada != null) {
                System.out.println("Libro encontrado:\n" + libroEncontrada.toString());
            } else {
                System.out.println("No se encontró el Libro con ese nombre.");
            }
        }
    }
    
    private Libros buscarLibroPorNombre(String nombreLibro) {
        for (Libros libro : listaLibros) {
            if (libro.getNombre().equalsIgnoreCase(nombreLibro)) {
                return libro;
            }
        }
        return null;
    }

    public void editarLibro() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Titulo del Libro que desea Editar:");
            String nombreLibro = sc.nextLine();
            Libros libroAEditar = buscarLibroPorNombre(nombreLibro);
            if (libroAEditar != null) {
                System.out.println("Información actual del Libro:");
                System.out.println(libroAEditar.toString());
                System.out.println("Ingrese el Nuevo Título del Libro:");
                String nuevoTitulo = sc.nextLine();
                libroAEditar.setNombre(nuevoTitulo);
                System.out.println("Ingrese el Nuevo Autor del Libro:");
                String nuevoAutor = sc.nextLine();
                libroAEditar.setAutor(nuevoAutor);
                System.out.println("Libro Editada");
            } else {
                System.out.println("No se Encontró el Libro con ese Nombre.");
            }
        }
    }

    public void buscarJuegoPorNombre() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del Juego que desea buscar:");
            String nombreJuego = sc.nextLine();
            Juegos juegoEncontrada = buscarJuegoPorNombre(nombreJuego);
            if (juegoEncontrada != null) {
                System.out.println("Juego encontrado:\n" + juegoEncontrada.toString());
            } else {
                System.out.println("No se encontró el Juego con ese nombre.");
            }
        }
    }
    
    private Juegos buscarJuegoPorNombre(String nombreJuego) {
        for (Juegos juego : listaJuegos) {
            if (juego.getNombre().equalsIgnoreCase(nombreJuego)) {
                return juego;
            }
        }
        return null;
    }

    public void editarJuego() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre del Juego que desea Editar:");
            String nombreJuego = sc.nextLine();
            Juegos juegoAEditar = buscarJuegoPorNombre(nombreJuego);
            if (juegoAEditar != null) {
                System.out.println("Información actual del Juego:");
                System.out.println(juegoAEditar.toString());
                System.out.println("Ingrese el nuevo Nombre del Juego:");
                String nuevoNombre = sc.nextLine();
                juegoAEditar.setNombre(nuevoNombre);
                System.out.println("Ingrese la nueva Plataforma del Juego:");
                String nuevaPlataforma = sc.nextLine();
                juegoAEditar.setPlataforma(nuevaPlataforma);
                System.out.println("Juego Editada");
            } else {
                System.out.println("No se Encontró el Juego con ese Nombre.");
            }
        }
    }

    public void banearUsuario() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del Usuario que desea Banear:");
            int usuarioID = sc.nextInt();
            Usuario usuarioABanear = buscarUsuarioPorID(usuarioID);

            if (usuarioABanear != null) {
                usuarioABanear.setBaneado(true);
                System.out.println("Usuario baneado");
            } else {
                System.out.println("No se encontró al usuario con ese ID.");
            }
        }
    }

    public void desbanearUsuario() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del Usuario que desea Desbanear:");
            int usuarioID = sc.nextInt();
            Usuario usuarioADesbanear = buscarUsuarioPorID(usuarioID);

            if (usuarioADesbanear != null) {
                usuarioADesbanear.setBaneado(false);
                System.out.println("Usuario desbaneado");
            } else {
                System.out.println("No se encontró al Usuario con ese ID");
            }
        }
    }

    private Usuario buscarUsuarioPorID(int usuarioID) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == usuarioID) {
                return usuario;
            }
        }
        return null;
    }

    public void verBibliotecaPersonal(int usuarioID) {
        Usuario usuario = buscarUsuarioPorId(usuarioID);

        if (usuario != null) {
            ArrayList<Contenido> bibliotecaPersonal = usuario.getBibliotecaPersonal();
            if (bibliotecaPersonal.isEmpty()) {
                System.out.println("La Biblioteca Personal está vacía.");
            } else {
                System.out.println("Biblioteca Personal: ");
                for (Contenido contenido : bibliotecaPersonal) {
                    System.out.println(contenido.toString());
                }
            }
        } else {
            System.out.println("No se encontró al Usuario con ese ID");
        }
    }

    private Usuario buscarUsuarioPorId(int usuarioID) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == usuarioID) {
                return usuario;
            }
        }
        return null;
    }

    /* METODOS CONTENIDO */

    public void agregarPeliculaPorNombre() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre de la Película: ");
            String nombre = sc.nextLine();
            Peliculas nuevaPelicula = new Peliculas(nombre, 0, 0, nombre, nombre, 0);
            listaPeliculas.add(nuevaPelicula);
        }
        System.out.println("Película Agregada");
    }
    
    public void agregarPeliculaPorDirector() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre de la Película: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el Director de la Película: ");
            String director = sc.nextLine();
            Peliculas nuevaPelicula = new Peliculas(nombre, 0, 0, director, director, 0);
            listaPeliculas.add(nuevaPelicula);
        }
        System.out.println("Película Agregada");
    }
    
    public void agregarLibroPorTitulo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Título del Libro: ");
            String titulo = sc.nextLine();
            Libros nuevoLibro = new Libros(titulo, 0, 0, titulo, titulo, 0);
            listaLibros.add(nuevoLibro);
        }
        System.out.println("Libro Agregado");
    }
    
    public void agregarLibroPorAutor() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Título del Libro: ");
            String titulo = sc.nextLine();
            System.out.println("Ingrese el Autor del Libro: ");
            String autor = sc.nextLine();
            Libros nuevoLibro = new Libros(titulo, 0, 0, autor, autor, 0);
            listaLibros.add(nuevoLibro);
        }
        System.out.println("Libro Agregado");
    }
    
    public void agregarJuegoPorNombre() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre del Juego: ");
            String nombre = sc.nextLine();
            Juegos nuevoJuego = new Juegos(nombre, 0, 0, nombre, nombre, nombre);
            listaJuegos.add(nuevoJuego);
        }
        System.out.println("Juego Agregado");
    }
    
    public void agregarJuegoPorPlataforma() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el Nombre del Juego: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la Plataforma del Juego: ");
            String plataforma = sc.nextLine();
            Juegos nuevoJuego = new Juegos(nombre, 0, 0, plataforma, plataforma, plataforma);
            listaJuegos.add(nuevoJuego);
        }
        System.out.println("Juego Agregado");
    }

    public void verListaAmigos(int id) {
        ArrayList<Usuario> listaAmigos = obtenerListaAmigos(id);
        if (listaAmigos.isEmpty()) {
            System.out.println("No Tienes Amigos en tu Lista.");
        } else {
            System.out.println("Lista de Amigos:");
            for (Usuario amigo : listaAmigos) {
                System.out.println(amigo.toString());
            }
        }
    }

    private static ArrayList<Usuario> obtenerAmigosPorUsuario(int id) {
        return null;
    }

    private static ArrayList<Usuario> obtenerListaDeseosPorCliente(int id) {
        return null;
    }

    private static ArrayList<Usuario> obtenerListaFavoritosPorCliente(int id) {
        return null;
    }
    
    private ArrayList<Usuario> obtenerListaAmigos(int id) {
        ArrayList<Usuario> listaAmigos = new ArrayList<>();
        listaAmigos = Data.obtenerAmigosPorUsuario(id);
        return listaAmigos;
    }

    public void verListaDeseos(int id) {
        ArrayList<Usuario> listaDeseos = obtenerListaDeseos(id);
        if (listaDeseos.isEmpty()) {
            System.out.println("Tu Lista de Deseos está Vacía.");
        } else {
            System.out.println("Lista de Deseos:");
            for (Usuario deseado : listaDeseos) {
                System.out.println(deseado);
            }
        }
    }
    
    private ArrayList<Usuario> obtenerListaDeseos(int id) {
        ArrayList<Usuario> listaDeseos = new ArrayList<>();
        listaDeseos = Data.obtenerListaDeseosPorCliente(id);
        return listaDeseos;
    }

    public void verListaFavoritos(int id) {
        ArrayList<Usuario> listaFavoritos = obtenerListaFavoritos(id);
        if (listaFavoritos.isEmpty()) {
            System.out.println("Tu Lista de Favoritos está vacía.");
        } else {
            System.out.println("Lista de Favoritos:");
            for (Usuario favorito : listaFavoritos) {
                System.out.println(favorito);
            }
        }
    }
    
    private ArrayList<Usuario> obtenerListaFavoritos(int id) {
        ArrayList<Usuario> listaFavoritos = new ArrayList<>();
        listaFavoritos = Data.obtenerListaFavoritosPorCliente(id);
        return listaFavoritos;
    }
    
    /* METODOS USUARIO */

    public boolean autenticarCliente() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese su Nombre de Usuario: ");
            String nombreUsuario = sc.nextLine();
            System.out.println("Ingrese su Contraseña:");
            String contrasena = sc.nextLine();
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    System.out.println("Autenticación exitosa. Bienvenido " + nombreUsuario + "");
                    return true;
                }
            }
        }
        System.out.println("Nombre de usuario o contraseña incorrectos.");
        return false;
    }

    /* METODOS CSV */

    public void agregarUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    public void leerCSVUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(directorioUsuarios))) {
            br.readLine();
            String linea;

            while((linea = br.readLine()) != null) {
                String[] dato = linea.split(",");
                int id = Integer.valueOf(dato[0]);
                Usuario nuevoUsuario = new Usuario(id, dato[1], dato[2], dato[3]);
                agregarUsuario(nuevoUsuario);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardarCSVUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(directorioUsuarios))) {
            for (Usuario usuario : this.listaUsuarios) {
                bw.write(String.join(",", String.valueOf(usuario.getId()), usuario.getTipoUsuario(), usuario.getNombreUsuario(), usuario.getContrasena()));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void agregarPelicula(Peliculas pelicula) {
        this.listaPeliculas.add(pelicula);
    }

    public void leerCSVPeliculas() {
        try (BufferedReader br = new BufferedReader(new FileReader(directorioPeliculas))) {
            br.readLine();
            String linea;

            while((linea = br.readLine()) != null) {
                String[] dato = linea.split(",");
                int id = Integer.valueOf(dato[1]);
                int precio = Integer.valueOf(dato[2]);
                int duracion = Integer.valueOf(dato[5]);
                Peliculas nuevaPelicula = new Peliculas(dato[0], id, precio, dato[3], dato[4], duracion);
                agregarPelicula(nuevaPelicula);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardarCSVPeliculas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(directorioPeliculas))) {
            for (Peliculas pelicula : this.listaPeliculas) {
                bw.write(String.join(",", pelicula.getNombre(), String.valueOf(pelicula.getId()), String.valueOf(pelicula.getPrecio()), pelicula.getDirector(), pelicula.getGenero(), String.valueOf(pelicula.getDuracion())));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void agregarLibro(Libros libro) {
        this.listaLibros.add(libro);
    }

    public void leerCSVLibros() {
        try (BufferedReader br = new BufferedReader(new FileReader(directorioLibros))) {
            br.readLine();
            String linea;

            while((linea = br.readLine()) != null) {
                String[] dato = linea.split(",");
                int id = Integer.valueOf(dato[1]);
                int precio = Integer.valueOf(dato[2]);
                int capitulos = Integer.valueOf(dato[5]);
                Libros nuevoLibro = new Libros(dato[0], id, precio, dato[3], dato[4], capitulos);
                agregarLibro(nuevoLibro);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardarCSVLibros() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(directorioLibros))) {
            for (Libros libro : this.listaLibros) {
                bw.write(String.join(",", libro.getNombre(), String.valueOf(libro.getId()), String.valueOf(libro.getPrecio()), libro.getAutor(), libro.getCategoria(), String.valueOf(libro.getCapitulos())));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void agregarJuego(Juegos juego) {
        this.listaJuegos.add(juego);
    }

    public void leerCSVJuegos() {
        try (BufferedReader br = new BufferedReader(new FileReader(directorioJuegos))) {
            br.readLine();
            String linea;

            while((linea = br.readLine()) != null) {
                String[] dato = linea.split(",");
                int id = Integer.valueOf(dato[1]);
                int precio = Integer.valueOf(dato[2]);
                Juegos nuevoJuego = new Juegos(dato[0], id, precio, dato[3], dato[4], dato[5]);
                agregarJuego(nuevoJuego);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardarCSVJuegos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(directorioJuegos))) {
            for (Juegos juego : this.listaJuegos) {
                bw.write(String.join(",", juego.getNombre(), String.valueOf(juego.getId()), String.valueOf(juego.getPrecio()), juego.getGenero(), juego.getPlataforma(), juego.getDesarrollador()));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    /* REGISTRO */

    public void agregarUsuarioRegistro(Usuario usuario) {
        try (Scanner sc = new Scanner(System.in)) {
            int id = sc.nextInt();
            System.out.print("Ingrese Nombre de Usuario: ");
            String nombreUsuario = sc.nextLine();
            System.out.print("Ingrese Contraseña: ");
            String contrasena = sc.nextLine();
            System.out.print("Ingrese Tipo de Usuario: ");
            String tipoUsuario = sc.nextLine();

            Usuario nuevoUsuario = new Usuario(id, nombreUsuario, contrasena, tipoUsuario);
            agregarUsuario(nuevoUsuario);
        }
    }
}




