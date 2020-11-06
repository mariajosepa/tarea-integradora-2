package model;

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

    /**
     * Method for adding new users into the application
     * @param userName New User's username
     * @param passWord New User's password
     * @param age      New User's Age
     * @return         Message stating if user was successfully registered
     */

    public String register(String userName, String passWord, int age) {

        User newUser = new User(userName, passWord, age);
        boolean added = false;
        String msg = "Usuario no anadido" + "\n";

        for (int i = 0; i <= MAX_USERS && !added; i++) {

            if (users[i] == null) {
                users[i] = newUser;
                added = true;
                msg = "Bienvenido a MCS: " + newUser.getUserName() + "\n";

            }

        }
        return msg;
    }

    /**
     * Method that adds a new song to the song pool
     * @param title title of the song
     * @param artist artist or band of the song
     * @param releaseDate date song was released
     * @param duration duration of the song in format mm/ss
     * @param genre    genre of the song [1-6]
     * @return  Message stating if the song was added or not to the song pool
     */

    public String addSongToPool(String title, String artist, String releaseDate, String duration, int genre, String username) {

        Song newSong = new Song(title, artist, releaseDate, duration, genre);
        boolean added = false;
        String msg = "";
        int userIndex = 100;

        boolean verified = false;

        for (int i = 0; i < MAX_USERS && !verified; i++) {

            if (users[i] != null) {
                if (users[i].getUserName().equals(username)) {

                        verified = true;
                        userIndex = i;

                }
            }
        }

        if (verified && userIndex != 100) {

            for (int i = 0; i < MAX_SONGS && !added; i++) {

                if (songPool[i] == null) {

                    songPool[i] = newSong;
                    users[userIndex].shareSong();
                    msg = "Cancion anadida al Pool" + "\n";
                    added = true;

                }
            }

            if (!added) {
                msg = "Se ha llegado al maximo de canciones en el Pool" + "\n";
            }

        } else {

            msg = "No existe ese usuario" + "\n";
        }

        return msg;
    }

    /**
     * Method that verifies how many songs each registered user has shared, and assigns a category accordingly
     */

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

    /**
     * Method that allows a new playlist to be created and added into the application's playlists
     * @param name Name of the new playlist
     * @param type  Type [1-3] of playlist
     * @return Message stating if the new playlist has been created
     */

    public String createPlaylist(String name, int type) {
        boolean added = false;
        String msg = "Se ha excedido el numero de playlists" + "\n";

            switch (type) {

                case 1:
                    PrivatePlaylist playlist = new PrivatePlaylist(name);


                    for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {
                        if (playlists[i] == null) {

                            playlists[i] = playlist;
                            msg = "Playlist " + name + " creada" + "\n";
                            added = true;

                        }
                    }

                    break;
                case 2:
                    RestrictedPlaylist restrictedPlaylist = new RestrictedPlaylist(name);

                    for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {
                        if (playlists[i] == null) {

                            playlists[i] = restrictedPlaylist;
                            msg = "Playlist " + name + " creada" + "\n";
                            added = true;

                        }
                    }

                    break;
                case 3:
                    PublicPlaylist publicPlaylist = new PublicPlaylist(name);


                    for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {
                        if (playlists[i] == null) {

                            playlists[i] = publicPlaylist;
                            msg = "Playlist " + name + " creada" + "\n";
                            added = true;

                        }
                    }
                    break;
            }

        return msg;
    }

    /**
     * Methods that adds a song to an existing playlist
     * There has to be at least one playlist created
     * @param songTitle title of a shared song
     * @param playlistTitle title of an existing playlist
     * @return Message stating if the song was successfully added
     */

    public String addSongToPlaylist(String songTitle, String playlistTitle) {

        String msg = "Cancion no ha sido compartida" + "\n";
        boolean found = false;
        int songIndex = 0;


            for (int i = 0; i < MAX_SONGS && !found; i++) {

                if (songPool[i] != null) {

                    if (songTitle.equalsIgnoreCase(songPool[i].getTitle())) {

                        found = true;
                        songIndex = i;
                        msg = "Cancion encontrada";
                    }

                }
            }
            if (found) {

                found = false;
                displayPlaylists();

                for (int i = 0; i < MAX_PLAYLISTS && !found; i++) {

                    if (playlists[i] != null) {

                        if (playlistTitle.equalsIgnoreCase(playlists[i].getName())) {

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

            else{

                msg = "Cancion no encontrada";

            }


        return msg;

    }

    /**
     * Displays all the playlists that have been created
     * @return Playlists that have been created
     */

    public String displayPlaylists() {

        String msg = "";

        msg += "PLAYLISTS PUBLICAS: " + "\n";

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null) {

                if (playlists[i] instanceof PublicPlaylist ) {

                    msg += playlists[i].showContents();


                }
            }

        }
        msg += "PLAYLISTS PRIVADAS: " + "\n";

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null) {
                if (playlists[i] instanceof PrivatePlaylist) {

                       msg+= playlists[i].showContents();

                }

            }

        }


       msg += "PLAYLISTS RESTRINGIDAS: " + "\n";

        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null) {

                if (playlists[i] instanceof RestrictedPlaylist) {

                            msg += playlists[i].showContents();
                }
            }


        }

            return msg;
    }

    /**
     * Adds a user to a playlist
     * The only playlists who allow user sharing are Private and Restricted playlists
     * @param playlistTitle
     * @param userName
     * @return Message stating if the user was success fully added
     */

    public String addUserToPlaylist(String playlistTitle, String userName) {

        String msg = "HOLA";
        boolean added = false;
        boolean playlistFound = false;
        boolean userFound = false;


           for (int i = 0; i < MAX_PLAYLISTS; i++) {

                if (playlists[i] != null) {
                    if (playlists[i].getName().equals(playlistTitle)) {
                        playlistFound = true;
                    }
                }

            }



            for (int i = 0; i < MAX_USERS && !userFound; i++) {

                if (users[i] != null) {
                    if (users[i].getUserName().equals(userName)) {
                        userFound = true;
                    }
                }
            }


            if (userFound == true && playlistFound == true) {

                for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {

                    if (playlists[i] != null && playlists[i].getName().equals(playlistTitle) && playlists[i] instanceof RestrictedPlaylist) {

                        msg = ((RestrictedPlaylist) playlists[i]).addUser(userName);
                        added = true;

                    }

                    if (playlists[i] != null && playlists[i].getName().equals(playlistTitle) && playlists[i] instanceof PrivatePlaylist) {

                        msg = ((PrivatePlaylist) playlists[i]).addUser(userName);

                        added = true;

                    }

                    if(playlists[i] != null && playlists[i] instanceof PublicPlaylist && playlists[i].equals(playlistTitle)){

                        msg = "No se pueden agregar usuarios a una playlist publica";


                    }

                }

            } else {

                msg = "Usuario o playlist no encontrado" + "\n";

            }

        return msg;

    }

    /**
     * Adds a rating  to a public playlist
     * At least one public playlist has to be created
     * @param playlistName public playlist name
     * @param rating playlist rating
     * @return Message stating if the rating was successfully added
     */

    public String ratePlaylist(String playlistName, int rating, String username) {

        boolean found = false;
        String msg = "No hay playlists para calificar" + "\n";

        boolean verified = false;

        for (int i = 0; i < MAX_USERS && !verified; i++) {

            if (users[i] != null) {
                if (users[i].getUserName().equals(username)) {

                    verified = true;

                }
            }
        }


        if (verified){

            if (rating >= 1 && rating <= 5) {
                for (int i = 0; i < MAX_PLAYLISTS && !found; i++) {

                    if (playlists[i] != null && playlists[i].getName().equalsIgnoreCase(playlistName) && playlists[i] instanceof PublicPlaylist) {

                        ((PublicPlaylist) playlists[i]).addRating(rating);
                        msg = "Calificacion anadida" + "\n";
                        found = true;

                    }

                }

                if (!found) {

                    msg = "No hay playlists calificables con ese nombre";

                }


            } else {

                msg = "Calificacion invalida";

            }

        }
        else{

            msg = "No se encontro el usuario";

        }



        return msg;





    }

    /**
     * Displays all registered users in the application
     * @return All registered users in the application
     */

    public String displayUsers(){
        String msg = "";
        assignCategories();

        for (int i = 0; i < MAX_USERS; i++) {

            if(users[i] != null){

                msg+= users[i].displayUser() + "\n";

            }

        }

        return msg;

    }

    /**
     * Displays all created public playlists
     * @return All public playlists
     */

    public String displayPublicPlaylists(){

        String msg = "";
        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null && playlists[i] instanceof PublicPlaylist) {

                msg += playlists[i].showContents();

            }
        }
        return msg;

    }

    /**
     * Displays all created private playlists
     * @return All private playlists
     */

    public String displayPrivatePlaylists(){

        String msg = "";
        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null && playlists[i] instanceof PrivatePlaylist) {

                msg += playlists[i].showContents();

            }
        }
        return msg;

    }

    /**
     * Displays all created restricted playlists
     * @return All restricted playlists
     */

    public String displayRestrictedPlaylists(){

        String msg = "";
        for (int i = 0; i < MAX_PLAYLISTS; i++) {

            if (playlists[i] != null && playlists[i] instanceof RestrictedPlaylist) {

                msg += playlists[i].showContents();

            }
        }
        return msg;

    }

    /**
     * Displays all shared songs in the song pool
     * @return all shared songs in the song pool with their characteristics
     */

    public String displaySongs(){

        String msg = "";

        for (int i = 0; i < MAX_SONGS ; i++) {

            if(songPool[i] != null){

                msg += songPool[i].showContents() + "\n";

            }

        }

        return msg;

    }



    }









