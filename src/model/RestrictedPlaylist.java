package model;


public class RestrictedPlaylist extends Playlist {

    private static final int MAX_USERS = 5;
    private String[] accesedBy;

    public RestrictedPlaylist(String name) {
        super(name);
        accesedBy = new String[MAX_USERS];

    }

    /**
     * Adds a user to the playlist
     * @param userName username of the user being added to the playlist
     * @return Message stating if user was added
     */

    public String addUser(String userName){

        boolean added = false;
        String msg = "Numero de usuarios excedido";

        for (int i = 0; i < MAX_USERS && !added; i++) {

            if (accesedBy[i] == null){

                accesedBy[i] = userName;
                added = true;

            }
        }

        if (added == true){
            msg = "Se ha agregado el usuario";
        }

        return msg;
    }

    /**
     * Returns users with access to the playlist
     * @return users with access to the playlist
     */

    public String getUsers(){

        String users = "";
        for (int i = 0; i < MAX_USERS; i++) {

            if (accesedBy[i] != null){

                users += accesedBy[i] + " ";

            }

        }

        return users;

    }

    /**
     * Displays the playlist's characteristics
     * @return
     */

    @Override
    public String showContents (){

        String msg;
        msg = "**************  Playlist **************\n";
        msg += "**  Title: " + getName() + "\n";
        msg += "**  Duration: " + getDuration() + "\n";
        msg += "**  Genre: " + findGenre() + "\n";
        msg+=  "**  Users:  "+ getUsers()  + "\n";
        msg += "***************************************" + "\n";

        return msg;

    }



    
}
