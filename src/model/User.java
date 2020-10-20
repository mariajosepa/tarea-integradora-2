package model;

public class User {

    private String userName;
    private String passWord;
    private int age;
    private Category category;

    public User(String userName, String passWord, int age){

        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.category = Category.NEWBIE;
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
/*
    public Song shareSong(){


    }

 */
}
