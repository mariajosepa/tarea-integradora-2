package model;

public class User {

    private static final int MAX_PLAYLISTS = 20;
    private String userName;
    private String passWord;
    private int age;
    private Category category;
    private int sharedSongs;
    private Playlist[] playlists;

    public User(String userName, String passWord, int age){

        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        category = Category.NEWBIE;
        sharedSongs = 0;
        playlists = new Playlist[MAX_PLAYLISTS];

    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPassWord() {

        return passWord;
    }

    public void setPassWord(String passWord) {

        this.passWord = passWord;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String shareSong(){
        String msg = "Cancion compartida";

        sharedSongs+=1;

        return msg;

    }

    public int getSharedSongs() {

        return sharedSongs;
    }

    public String createPlaylist(Playlist playlist){

        boolean added = false;
        String msg = "Se ha excedido el numero de playlists";

        for (int i = 0; i < MAX_PLAYLISTS && !added; i++) {

            if (playlists[i]==null){

                playlists[i] = playlist;
                 msg = "Playlist Creada";
                 added = true;
            }
        }


        return msg;

    }

    public String grantAccessToPlaylist(String userName){



    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String displayUser(){
        String msg = "*************User************* \n";
        msg += "**"+"UserName: "+getUserName()+"\n";
        msg += "**"+"Age: " +getAge()+"\n";
        msg += "**"+"Category: " +getCategory().name()+"\n";
        msg += "********************************";

        return msg;

    }
}
