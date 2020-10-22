package model;

import java.util.Arrays;
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
        String msg = "Usuario no anadido" + "\n";

        for (int i = 0; i <= MAX_USERS && !added; i++) {

            if (users[i] == null) {
                users[i] = newUser;
                added = true;
                msg = "Bienvenido a MCS: " + newUser.getUserName();

            }

        }
        return msg;
    }

    public String addSongToPool(String title, String artist, String releaseDate, String duration, int genre) {

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
                msg = "Se ha llegado al maximo de canciones en el Pool" + "\n";
            }

        } else {

            msg = "No se ha iniciado sesion" + "\n";
        }

        return msg;
    }

    public String login(String userName, String password) {

        boolean verified = false;
        String msg = "Usuario no existe (Register)" + "\n";

        for (int i = 0; i < MAX_USERS && !verified; i++) {

            if (users[i] != null) {
                if (users[i].getUserName().equals(userName)) {

                    if (users[i].getPassWord().equals(password)) {

                        verified = true;
                        loggedIn = i;
                        msg = "Bienvenido " + users[loggedIn].getUserName() + "\n";
                    }

                }
            }
        }

        return msg;
    }

    public String logOut() {

        loggedIn = 10;
        return "¡Hasta pronto!";

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
        boolean added = false;
        Scanner input = new Scanner(System.in);
        String msg = "Se ha excedido el numero de playlists" + "\n";

        if (loggedIn != 10) {
            switch (type) {

                case 1:
                    Playlist playlist = new Playlist(name, users[loggedIn].getUserName());
                    users[loggedIn].createPlaylist(playlist);

                    for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {
                        if (playlists[i] == null) {

                            playlists[i] = playlist;
                            added = true;

                        }
                    }

                    msg = "Playlist " + name + " creada" + "\n";
                    break;
                case 2:
                    RestrictedPlaylist restrictedPlaylist = new RestrictedPlaylist(name, users[loggedIn].getUserName());
                    users[loggedIn].createPlaylist(restrictedPlaylist);

                    for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {
                        if (playlists[i] == null) {

                            playlists[i] = restrictedPlaylist;
                            added = true;

                        }
                    }
                    msg = "Playlist " + name + " creada" + "\n";
                    break;
                case 3:
                    PublicPlaylist publicPlaylist = new PublicPlaylist(name, users[loggedIn].getUserName());
                    users[loggedIn].createPlaylist(publicPlaylist);

                    for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {
                        if (playlists[i] == null) {

                            playlists[i] = publicPlaylist;
                            added = true;

                        }
                    }

                    msg = "Playlist " + name + " creada" + "\n";
                    break;

            }
        } else {
            msg = "No se ha iniciado sesion" + "\n";
        }
        return msg;
    }

    public String addSongToPlaylist() {

        Scanner input = new Scanner(System.in);
        String msg = "Cancion no ha sido compartida" + "\n";
        boolean found = false;
        int songIndex = 0;
        String title;

        if (loggedIn != 10) {
            System.out.println("Ingrese titulo de cancion que desea agregar");
            title = input.next();

            for (int i = 0; i < MAX_SONGS && !found; i++) {

                if (songPool[i] != null) {

                    if (title.equalsIgnoreCase(songPool[i].getTitle())) {

                        found = true;
                        songIndex = i;
                    }

                }
            }
            if (found) {

                found = false;
                displayPlaylists();
                System.out.println("Ingrese nombre de la playlist a la que desea agregar");
                title = input.next();

                for (int i = 0; i < MAX_PLAYLISTS && !found; i++) {

                    if (playlists[i] != null) {

                        if (title.equalsIgnoreCase(playlists[i].getName())) {

                            playlists[i].addSong(songPool[songIndex]);
                            msg = "Cancion agregada a " + playlists[i].getName() + "\n";
                            found = true;


                        }
                    }
                }


                if (!found) {

                    msg = "No existe esa PlayList" + "\n";
                }
            }
        } else {
            msg = "No se ha iniciado sesion";
        }

        return msg;

    }


    public void displayPlaylists() {

        String msg;
        System.out.println("PLAYLISTS PUBLICAS: ");

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null) {
                if (playlists[i].getType() == 3) {

                    playlists[i].showContents();


                }
            }

        }
        System.out.println("PLAYLISTS PRIVADAS: ");

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null) {
                if (playlists[i].getType() == 1) {

                    System.out.println(users[loggedIn].getUserName());

                    if (users[loggedIn].getUserName() == playlists[i].getOwner()) ;
                    {

                        playlists[i].showContents();

                    }

                }

            }

        }


        System.out.println("PLAYLISTS RESTRINGIDAS: ");
        boolean verified = false;

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null) {

                if (playlists[i].getType() == 2) {

                    String[] accesedBy = ((RestrictedPlaylist) playlists[i]).getAccesedBy();

                    for (int j = 0; j < 5; j++) {

                        if (users[loggedIn].getUserName().equals(accesedBy[j])) {

                            playlists[i].showContents();


                        }

                    }
                }
            }


        }

    }

    public void addUserToPlaylist() {

        String msg;
        Scanner input = new Scanner(System.in);
        String playlistTitle;
        String username;
        System.out.println("PLAYLISTS RESTRINGIDAS: ");
        boolean verified = false;

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null && playlists[i].getType() == 2) {

                String[] accesedBy = ((RestrictedPlaylist) playlists[i]).getAccesedBy();

                for (int j = 0; j < 5; j++) {

                    if (users[loggedIn].getUserName().equals(accesedBy[j])) {

                        playlists[i].showContents();
                        verified = true;


                    }

                }

            }

        }

        if (verified) {

            boolean added = false;
            boolean playlistFound = false;
            boolean userFound = false;

            System.out.println("Ingrese nombre de la Playlist a la que desea agregar un usuario: " + "\n");
            playlistTitle = input.next();
            System.out.println("Ingrese nombre del usuario a agregar: " + "\n");
            username = input.next();



            for (int i = 0; i < MAX_PLAYLISTS; i++) {

                if(playlists[i] != null) {
                    if (playlists[i].getName().equals(playlistTitle)) {
                        playlistFound = true;
                    }
                }

            }

            for (int i = 0; i < MAX_USERS; i++) {

              if(users[i] != null) {
                  if (users[i].getUserName().equals(username)) {
                      userFound = true;
                  }
              }
            }

            if (userFound == true && playlistFound == true){

                for (int i = 0; i < MAX_PLAYLISTS; i++) {

                    if (playlists[i] != null && playlists[i].getType() == 2) {

                        ((RestrictedPlaylist) playlists[i]).addUser(username);
                        added = true;

                    }

                }

            if (!added) {

                System.out.println("Numero de usuarios excedido" + "\n");

                }

            }

            else{

                System.out.println("Usuario o playlist no encontrados" + "\n");

            }



        }

    }

    public void ratePlaylist(){

        Scanner input = new Scanner(System.in);
        String name;
        int rating;
        boolean found = false;
        String msg = "No hay playlists para calificar"+"\n";

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if(playlists[i]!=null && playlists[i].getType()==3){

                playlists[i].showContents();

                //((PublicPlaylist)playlists[i]).addRating(rating);

            }

        }

        System.out.println("Ingrese nombre de la playlist a calificar");
        name = input.next();
        System.out.println("Ingrese calificacion [1-5]");
        rating = input.nextInt();

    if(rating >= 1 && rating <= 5) {
        for (int i = 0; i < MAX_PLAYLISTS && !found; i++) {

            if (playlists[i] != null && playlists[i].getName().equals(name)) {

                ((PublicPlaylist) playlists[i]).addRating(rating);
                msg= "Calificacion anadida" +"\n";
                found = true;

            }

        }
    }

    else{

        System.out.println("Calificacion invalida");

    }

    if (found = false){

        System.out.println("Playlist no existe");

    }

        System.out.println(msg);





    }


}
