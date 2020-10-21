package model;

import java.util.Scanner;

public class MCS {

    private static final int MAX_USERS = 10;
    private static final int MAX_SONGS = 30;
    private static final int MAX_PLAYLISTS = 20;

    private User[] users;
    private Song[] songPool;
    private Playlist[] playlists;
    private int loggedIn;

    public MCS() {

        this.users = new User[MAX_USERS];
        this.songPool = new Song[MAX_SONGS];
        this.playlists = new Playlist[MAX_PLAYLISTS];
        loggedIn = 10;

    }

    public String register(String userName, String passWord, int age) {

        User newUser = new User(userName, passWord, age);
        boolean added = false;
        String msg = "Usuario no anadido";

        for (int i = 0; i <= MAX_USERS && !added; i++) {

            if (users[i] == null) {
                users[i] = newUser;
                added = true;
                msg = "Bienvenido a MCS: " + newUser.getUserName();

            }

        }
        return msg;
    }

    public String addSongToPool(String title, String artist, String releaseDate, String duration, int genre, String userName, String passWord) {

        Song newSong = new Song(title, artist, releaseDate, duration, genre);
        boolean added = false;
        String msg = "";
        int userIndex = loggedIn;

        if (userIndex != 10) {

            for (int i = 0; i < MAX_SONGS && !added; i++) {

                if (songPool[i] == null) {

                    songPool[i] = newSong;
                    users[userIndex].shareSong();
                    msg = "Cancion anadida al Pool";
                    added = true;

                }
            }

            if (!added) {
                msg = "Se ha llegado al maximo de canciones en el Pool";
            }

        } else {

            msg = "Usuario o contrasena incorrectos";
        }

        return msg;
    }

    public String login(String userName, String password) {

        boolean verified = false;
        loggedIn = 10;
        String msg = "Usuario no existe (Register)";

        for (int i = 0; i < MAX_USERS && !verified; i++) {

            if (users[i].getUserName().equals(userName)) {

                if (users[i].getPassWord().equals(password)) {

                    verified = true;
                    loggedIn = i;
                    msg = "Bienvenido";
                }

            }
        }
        return msg;
    }



    public void assignCategories() {

        for (int i = 0; i < MAX_USERS; i++) {

            if (users[i] != null) {

                if (users[i].getSharedSongs() > 3) {

                    users[i].setCategory(Category.LITTLE_CONTRIBUTOR);
                }

                if (users[i].getSharedSongs() >= 10) {

                    users[i].setCategory(Category.MILD_CONTRIBUTOR);
                }

                if (users[i].getSharedSongs() >= 30) {

                    users[i].setCategory(Category.STAR_CONTRIBUTOR);
                }

            }

        }
    }

    public String createPlaylist(String name, int type) {
        boolean created = false;
        Scanner input = new Scanner(System.in);
        String msg = "Se ha excedido el numero de playlists";

        if (loggedIn != 10) {
            switch (type) {

                case 1:
                    Playlist playlist = new Playlist(name);
                    users[loggedIn].createPlaylist(playlist);
                    msg = "Playlist " + name + " creada";
                    break;
                case 2:
                    RestrictedPlaylist restrictedPlaylist = new RestrictedPlaylist(name);
                    users[loggedIn].createPlaylist(restrictedPlaylist);
                    msg = "Playlist " + name + " creada";
                    break;
                case 3:
                    PublicPlaylist privatePlaylist = new PublicPlaylist(name);
                    users[loggedIn].createPlaylist(privatePlaylist);
                    msg = "Playlist " + name + " creada";
                    break;

            }
        }

        else{
            msg = "No se ha iniciado sesion";

        }
            return msg;

    }

    public void addSongToPlaylist(){

        Scanner input = new Scanner(System.in);
        String msg = "Cancion no ha sido compartida";
        boolean found = false;
        String title;

        System.out.println("Ingrese titulo de cancion que desea agregar");
        title = input.next();

        for (int i = 0; i < MAX_SONGS && !found; i++) {

            if (title.equalsIgnoreCase(songPool[i].getTitle())){

                found = true;
            }

        }

        if (found){

                

        }




    }


}
