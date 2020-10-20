package model;

public class MCS {

    private static final int MAX_USERS = 10;
    private static final int MAX_SONGS = 30;
    private static final int MAX_PLAYLISTS = 20;

    private User[] users;
    private Song[] songPool;
    private PlayList[] playlists;

    public MCS(){

        this.users = new User[MAX_USERS];
        this.songPool = new Song[MAX_SONGS];
        this.playlists= new PlayList[MAX_PLAYLISTS];

    }

    public String addUser(String userName, String passWord, int age){

        User newUser = new User (userName,passWord,age);
        boolean added = false;
        String msg = "Usuario no anadido";

        for (int i = 0; i <= MAX_USERS && !added; i++) {

            if(users[i]==null){
                users[i] = newUser;
                added = true;
                msg = "Bienvenido a MCS: "+newUser.getUserName();

            }

        }
            return msg;
    }


}
