package model;

public class RestrictedPlaylist extends Playlist {

    private static final int MAX_USERS = 5;
    private String[] accesedBy;

    public RestrictedPlaylist(String name) {
        super(name);
    }

    public String addUser(String userName){

        boolean added = false;
        String msg = "Numero de usuarios excedido";

        for (int i = 0; i < MAX_USERS && !added; i++) {

            if (accesedBy == null){

                accesedBy[i] = userName;
                added = true;

            }
        }

        if (!added){
            msg = "Se ha agregado el usuario";
        }

        return msg;
    }

}
