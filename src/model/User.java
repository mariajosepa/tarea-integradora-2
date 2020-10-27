package model;

public class User {

    //private static final int MAX_PLAYLISTS = 20;
    private String userName;
    private String passWord;
    private int age;
    private Category category;
    private int sharedSongs;
    //private Playlist[] playlists;

    public User(String userName, String passWord, int age){

        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        category = Category.NEWBIE;
        sharedSongs = 0;
        //playlists = new Playlist[MAX_PLAYLISTS];

    }

    public String getUserName() {

        return userName;
    }


    public String getPassWord() {

        return passWord;
    }


    public int getAge() {

        return age;
    }

    /**
     * Adds +1 shared songs to the user's shared song count
     * @return Message stating that the song has been shared
     */

    public String shareSong(){
        String msg = "Cancion compartida";

        sharedSongs+=1;

        return msg;

    }

    public int getSharedSongs() {

        return sharedSongs;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Displays general info about the user
     * @return general infor of the user
     */
    public String displayUser(){
        String msg = "*************User************* \n";
        msg += "**"+"UserName: "+getUserName()+"\n";
        msg += "**"+"Age: " +getAge()+"\n";
        msg += "**"+"Category: " +getCategory().name()+"\n";
        msg += "*******************************";

        return msg;

    }
}
