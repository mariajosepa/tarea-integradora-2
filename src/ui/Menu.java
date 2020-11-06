package ui;

import model.MCS;

import java.util.Scanner;

public class Menu {

    public static final int REGISTER = 1;
    public static final int SHARE_SONG = 2;
    public static final int MAKE_PLAYLIST = 3;
    public static final int EDIT_PLAYLIST = 4;
    public static final int SHOW_USERS = 5;
    public static final int SHOW_PLAYLISTS = 6;
    public static final int SHOW_SONGS = 7;
    public static final int EXIT = 8;


    private static Scanner input = new Scanner(System.in);
    private MCS mcs;


    public Menu() {

        mcs = new MCS();
    }

    /**
     * Displays all menu options
     */

    public void showMenu() {

        System.out.println("Para Registrar un usuario nuevo REGISTER");

        System.out.println("(1) REGISTER");
        System.out.println("(2) COMPARTIR CANCION");
        System.out.println("(3) CREAR PLAYLIST");
        System.out.println("(4) EDITAR PLAYLIST");
        System.out.println("(5) MOSTRAR USUARIOS");
        System.out.println("(6) MOSTRAR PLAYLISTS");
        System.out.println("(7) MOSTRAR CANCIONES");
        System.out.println("(8)SALIR");

    }


    /**
     * Returns user's chosen option from the menu
     * @return User's Option
     */

    public int readOption() {
        int choice = input.nextInt();
        input.nextLine();
        return choice;

    }

    /**
     * Register's a new user
     */

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


    /**
     * Shares a new song
     */

    public void shareSong() {
        String username;
        String title;
        String artist;
        String releaseDate;
        String duration;
        int genre;

        System.out.println("Ingrese nombre de usuario: ");
        username = input.next();
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

        System.out.println(mcs.addSongToPool(title, artist, releaseDate, duration, genre,username));
    }

    /**
     * Displays genres
     */

    public void displayGenres() {

        System.out.println("ELIJA EL GENERO: ");
        System.out.println("(1)ROCK");
        System.out.println("(2)HIP-HOP");
        System.out.println("(3)CLASSICAL");
        System.out.println("(4)REGGAE");
        System.out.println("(5)SALSA");
        System.out.println("(6)METAL");

    }

    /**
     * Displays available types of playlists
     */
    public void displayTypes() {

        System.out.println("(1)PRIVADA");
        System.out.println("(2)RESTRINGIDA");
        System.out.println("(3)PUBLICA");

    }

    /**
     * Creates a new playlist
     */

    public void makePlaylist() {

        String name;
        int type;
        System.out.println("Nombre de la playlist: ");
        name = input.next();
        displayTypes();
        type = readOption();

        System.out.println(mcs.createPlaylist(name, type));

    }

    /**
     * Displays and executes the different options of editing a playlist (adding users, adding music to a playlist)
     */

    public void editPlaylist() {

        int option;
        System.out.println("(1) AREGAR USUARIO A PLAYLIST");
        System.out.println("(2) AGREGAR MUSICA A PLAYLIST");
        System.out.println("(3) CALIFICAR PLAYLIST");
        option = readOption();

        switch (option) {

            case 1:

                System.out.println("PlayLists disponibles para agregar usuarios: ");
                System.out.println("Playlists privadas: ");
                System.out.println(mcs.displayPrivatePlaylists());
                System.out.println("Playlists restringidas: ");
                System.out.println(mcs.displayRestrictedPlaylists());

                System.out.println("Ingrese nombre de la Playlist");
                String playlistTitle = input.next();
                System.out.println("Ingrese nombre del usuario a agregar");
                String userName = input.next();


                System.out.println(mcs.addUserToPlaylist(playlistTitle, userName));
                break;

            case 2:
                System.out.println("Canciones Compartidas: ");
                System.out.println(mcs.displaySongs());
                System.out.println("Ingrese nombre de la cancion a agregar");
                String songTitle = input.next();
                System.out.println("Playlists creadas: ");
                System.out.println(mcs.displayPlaylists());
                System.out.println("Ingrese nombre de la playlist a editar");
                String playlistName = input.next();
                System.out.println(mcs.addSongToPlaylist(songTitle, playlistName));
                break;

            case 3:

                System.out.println("Playlists publicas: ");
                System.out.println(mcs.displayPublicPlaylists());


                System.out.println("Ingrese nombre de la playlist a calificar");
                String playlistName1 = input.next();
                System.out.println("Ingrese calificacion [1-5]");
                int rating = input.nextInt();
                System.out.println("Ingrese nombre de usuario");
                String username = input.next();

                System.out.println(mcs.ratePlaylist(playlistName1, rating, username));
                break;



        }

    }

    /**
     * Displays all registered users
     */

    public void displayUsers() {

        System.out.println(mcs.displayUsers());


    }

    /**
     * Takes the user's menu option and launches the corresponding operation
     * @param option
     */

    public void doOperation(int option) {

            switch (option) {

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
                case SHOW_USERS:
                    displayUsers();
                    break;
                case SHOW_PLAYLISTS:
                    displayPlaylists();
                    break;
                case SHOW_SONGS:
                    displaySongs();
                    break;

            }

    }

    /**
     * Initializes the menu
     */

    public void startProgram(){

        int choice;

        do{
            showMenu();
            choice = readOption();
            doOperation(choice);


        }while(choice != 8);

    }

    /**
     * Displays all created playlists
     */
    public void displayPlaylists(){

        System.out.println(mcs.displayPlaylists());


    }

    /**
     * Displays all shared songs
     */
    public void displaySongs(){
        System.out.println(mcs.displaySongs());
    }

}
