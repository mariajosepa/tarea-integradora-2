package model;

public class RestrictedPlaylist extends Playlist {

    private static final int MAX_USERS = 5;
    private String[] accesedBy;

    public RestrictedPlaylist(String name, String owner) {
        super(name,owner);
        accesedBy = new String[MAX_USERS];
        accesedBy[0] = owner;
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
     * Returns playlist type (2)
     * @return playlist type (2) (restricted)
     */

    @Override
    public int getType(){

        return 2;
    }


    
}
