package ui;

import model.MCS;

import java.util.Scanner;

public class Menu {

    public static final int LOGIN = 1;
    public static final int REGISTER = 2;
    public static final int SHARE_SONG = 3;
    public static final int MAKE_PLAYLIST = 4;
    public static final int EDIT_PLAYLIST = 5;
    public static final int RATE_PLAYLIST = 6;
    public static final int SHOW_USERS = 7;
    public static final int SHOW_PLAYLISTS = 8;
    public static final int LOGOUT = 9;

    private static Scanner input = new Scanner(System.in);
    private MCS mcs;


    public Menu() {

        mcs = new MCS();
    }

    public void showMenu() {

        System.out.println("Por favor LOGIN, para identificarse");
        System.out.println("Si es un usuario nuevo, REGISTER");
        System.out.println("Para cambiar de usuario: LOGOUT, y luego LOGIN con el nuevo usuario");

        System.out.println("(1) LOGIN");
        System.out.println("(2) REGISTER");
        System.out.println("(3) COMPARTIR CANCION");
        System.out.println("(4) CREAR PLAYLIST");
        System.out.println("(5) EDITAR PLAYLIST");
        System.out.println("(6) CALIFICAR PLAYLIST");
        System.out.println("(7) MOSTRAR USUARIOS");
        System.out.println("(8) MOSTRAR PLAYLISTS");
        System.out.println("(9) LOGOUT");
        System.out.println("(10)SALIR");

    }

    public int readOption() {
        int choice = input.nextInt();
        input.nextLine();
        return choice;

    }


    public void login() {
        String userName;
        String passWord;
        System.out.println("Username: ");
        userName = input.next();
        System.out.println("PassWord: ");
        passWord = input.next();
        System.out.println(mcs.login(userName, passWord));

    }

    public void logOut() {

        mcs.logOut();
    }

    public void register() {
        String userName;
        String passWord;
        int age;

        System.out.println("Ingrese Username: ");
        userName = input.next();
        System.out.println("Ingrese PassWord: ");
        passWord = input.next();
        System.out.println("Ingrese edad: ");
        age = input.nextInt();

        System.out.println(mcs.register(userName, passWord, age));

    }

    public void shareSong() {

        String title;
        String artist;
        String releaseDate;
        String duration;
        int genre;

        System.out.println("Titulo de la cancion: ");
        title = input.next();
        System.out.println("Artista: ");
        artist = input.next();
        System.out.println("Fecha de lanzamiento [dd/mm/aa]: ");
        releaseDate = input.next();
        System.out.println("Duracion [mm:ss]: ");
        duration = input.next();
        displayGenres();
        genre = readOption();

        System.out.println(mcs.addSongToPool(title, artist, releaseDate, duration, genre));
    }


    public void displayGenres() {

        System.out.println("ELIJA EL GENERO: ");
        System.out.println("(1)ROCK");
        System.out.println("(2)HIP-HOP");
        System.out.println("(3)CLASSICAL");
        System.out.println("(4)REGGAE");
        System.out.println("(5)SALSA");
        System.out.println("(6)METAL");

    }

    public void displayTypes() {

        System.out.println("(1)PRIVADA");
        System.out.println("(2)RESTRINGIDA");
        System.out.println("(3)PUBLICA");

    }

    public void makePlaylist() {

        String name;
        int type;
        System.out.println("Nombre de la playlist: ");
        name = input.next();
        displayTypes();
        type = readOption();

        System.out.println(mcs.createPlaylist(name, type));

    }

    public void editPlaylist() {

        int option;
        System.out.println("(1) COMPARTIR PLAYLIST");
        System.out.println("(2) AGREGAR MUSICA A PLAYLIST");
        option = readOption();

        switch (option) {

            case 1:

                System.out.println("Ingrese nombre de la Playlist");
                String playlistTitle = input.next();
                System.out.println("Ingrese nombre del usuario a agregar");
                String userName = input.next();

                System.out.println("PlayLists disponibles para compartir:");

                System.out.println(mcs.addUserToPlaylist(playlistTitle, userName));
                break;

            case 2:
                System.out.println("Ingrese nombre de la cancion a agregar");
                String songTitle = input.next();
                System.out.println("Ingrese nombre de la playlist a editar");
                String playlistName = input.next();
                System.out.println(mcs.addSongToPlaylist(songTitle, playlistName));
                break;


        }

    }

    public void ratePlaylist() {


        System.out.println("Ingrese nombre de la playlist a calificar");
        String playlistName = input.next();
        System.out.println("Ingrese calificacion [1-5]");
        int rating = input.nextInt();

        System.out.println(mcs.ratePlaylist(playlistName, rating));

    }


    public void displayUsers() {

        System.out.println(mcs.displayUsers());


    }

    public void doOperation(int option) {

        switch (option) {

            case LOGIN:
                login();
                break;
            case REGISTER:
                register();
                break;
            case SHARE_SONG:
                shareSong();
                break;
            case MAKE_PLAYLIST:
                makePlaylist();
                break;
            case EDIT_PLAYLIST:
                editPlaylist();
                break;
            case RATE_PLAYLIST:
                ratePlaylist();
                break;
            case SHOW_USERS:
                displayUsers();
                break;
            case SHOW_PLAYLISTS:
                mcs.displayPlaylists();
                break;
            case LOGOUT:
                logOut();
                break;


        }


    }


    public void startProgram(){

        int choice;

        do{
            showMenu();
            choice = readOption();
            doOperation(choice);


        }while(choice != 10);

    }



}
