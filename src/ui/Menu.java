package ui;

import model.MCS;

import java.util.Scanner;

public class Menu {

    private static Scanner input = new Scanner(System.in);
    private MCS mcs;


    public Menu(){

        mcs = new MCS();
    }

    public void showMenu(){

        System.out.println("(1) LOGIN");
        System.out.println("(2) REGISTER");
        System.out.println("(3) SHARE SONG");
        System.out.println("(4) MAKE PLAYLIST");
        System.out.println("(5) SHARE PLAYLIST");
        System.out.println("(6) RATE PLAYLIST");
        System.out.println("(7) LOGOUT");

    }

    public int readOption(){
        int choice = input.nextInt();
        input.nextLine();
        return choice;

    }


    public void login(){
        String userName;
        String passWord;
        System.out.println("Username: ");
        userName=input.next();
        System.out.println("PassWord: ");
        passWord = input.next();
        System.out.println(mcs.login(userName,passWord));

    }

    public void logOut(){

        mcs.logOut();
    }

    public void Register(){
        String userName;
        String passWord;
        int age;

        System.out.println("Ingrese Username: ");
        userName= input.next();
        System.out.println("Ingrese PassWord: ");
        passWord = input.next();
        System.out.println("Ingrese edad: ");
        age = input.nextInt();

        System.out.println(mcs.register(userName,passWord,age));

    }

    public void shareSong(){

        String title;
        String artist;
        String releaseDate;
        String duration;
        int genre;

        System.out.println("Titulo de la cancion: ");
        title = input.next();
        System.out.println("Artista: ");
        artist = input.next();
        System.out.println("Fecha de lanzamiento [dd/mm/aa]: ");
        releaseDate = input.next();
        System.out.println("Duracion [mm:ss]: ");
        duration= input.next();
        displayGenres();
        genre = readOption();

        System.out.println(mcs.addSongToPool(title,artist,releaseDate,duration,genre));
    }


    public void displayGenres(){

        System.out.println("ELIJA EL GENERO: ");
        System.out.println("(1)ROCK");
        System.out.println("(2)HIP-HOP");
        System.out.println("(3)CLASSICAL");
        System.out.println("(4)REGGAE");
        System.out.println("(5)SALSA");
        System.out.println("(6)METAL");

    }

    public void displayTypes(){

        System.out.println("(1)PRIVADA");
        System.out.println("(2)RESTRINGIDA");
        System.out.println("(3)PUBLICA");

    }

    public void makePlaylist(){

        String name;
        int type;
        System.out.println("Nombre de la playlist: ");
        name = input.next();
        displayTypes();
        type = readOption();

        System.out.println(mcs.createPlaylist(name,type));

    }

    public void editPlaylist(){

        int option;
        System.out.println("(1) COMPARTIR");
        System.out.println("(2) AGREGAR MUSICA");
        option = readOption();

        switch(option){

            case 1:
                    mcs.addUserToPlaylist();
                break;

            case 2:
                    mcs.addSongToPlaylist();
                break;


        }

    }


}
