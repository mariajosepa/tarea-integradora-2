package model;

public class User {

    private String userName;
    private String passWord;
    private int age;
    private Category category;
    private int sharedSongs;


    public User(String userName, String passWord, int age){

        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        category = Category.NEWBIE;
        sharedSongs = 0;


    }

    /**
     * Returns user's username
     * @return username
     */

    public String getUserName() {

        return userName;
    }
    /**
     * Returns user's password
     * @return password
     */
    public String getPassWord() {

        return passWord;
    }

    /**
     * returns user's age
     * @return age
     */
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

    /**
     * Returns number of songs the user has shared
     * @return number of shared songs
     */

    public int getSharedSongs() {

        return sharedSongs;
    }

    /**
     * Returns the assigned user category
     * @return user's category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Assings a category to the user
     * @param category
     */

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
