package model;

public class PrivatePlaylist extends Playlist {

    String user;

    public PrivatePlaylist(String name){
        super(name);
        user = "";
    }


    /**
     * Adds a user to the playlist
     * @param user username of the user that is being added to the playlist
     * @return Message stating if the user was added
     */
    public String addUser(String user){

        String msg = "No se pueden agregar mas usuarios";

            this.user = user;
            msg = "Usuario anadido";

        return msg;

    }

    /**
     * Returns user with access to the playlist
     * @return Only user with access to the playlist
     */

    public String getUser(){

        return user;

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
        msg+=  "**  User:  "+ getUser()  + "\n";
        msg += "***************************************" + "\n";

        return msg;

    }



}
