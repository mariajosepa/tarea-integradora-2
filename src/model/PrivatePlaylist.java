package model;

public class PrivatePlaylist extends Playlist {

    String user;

    public PrivatePlaylist(String name, String owner){
        super(name,owner);
        user = null;
    }


    /**
     * Adds a user to the playlist
     * @param user username of the user that is being added to the playlist
     * @return Message stating if the user was added
     */
    public String addUser(String user){

        String msg = "No se pueden agregar mas usuarios";
        if(this.user == null){
            this.user = user;
            msg = "Usuario anadido";

        }

        return msg;


    }

    /**
     * Returns the playlist type (1)
     * @return playlist type (1) (private)
     */
    @Override
    public int getType(){

        return 1;
    }


}
