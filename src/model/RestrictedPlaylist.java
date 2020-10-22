package model;

public class RestrictedPlaylist extends Playlist {

    private static final int MAX_USERS = 5;
    private String[] accesedBy;

    public RestrictedPlaylist(String name, String owner) {
        super(name,owner);
        accesedBy = new String[MAX_USERS];
        accesedBy[0] = owner;
    }

    public void addUser(String userName){

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

        System.out.println(msg);
    }

    @Override
    public int getType(){

        return 2;
    }

    public String[] getAccesedBy(){

        return accesedBy;

    }
    
}
