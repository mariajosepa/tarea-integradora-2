package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Playlist {

    private static final int MAX_GENRES = 6;
    private static final int MAX_SONGS = 10;

    private String name;
    private String duration;
    private Genre[] genres;
    private Song[] songs;
    private String owner;

    public Playlist(String name,String owner){
        this.name = name;
        duration = "0:0";
        genres = new Genre[MAX_GENRES];
        songs = new Song[MAX_SONGS];
        this.owner = owner ;
    }

    public int getType(){

        return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {

        int hours;
        int minutes;
        int seconds;
        double totalSeconds = 0;

        String[]splitTime;
        int songCounter=0;

        for (int i = 0; i < MAX_SONGS; i++) {

            if (songs[i] != null){
                songCounter++;
            }

        }

        String[] times = new String[songCounter];

        for (int i = 0; i < songCounter; i++) {

            times[i] = songs[i].getDuration();
        }



        for (int i = 0; i < times.length; i++) {

                if(times[i]!=null){
                    splitTime = times[i].split(":");

                    minutes = Integer.parseInt(splitTime[0]);
                    seconds = Integer.parseInt(splitTime[1]);

                    totalSeconds += minutes *60;
                    totalSeconds += seconds;

                }
        }

        hours = (int) (totalSeconds/3600);
        minutes = (int) (totalSeconds%3600/60);
        seconds= (int) (totalSeconds%60);


        if (hours>0){

            duration = (hours + ":" + minutes + ":" + seconds);

        }

        else{

            duration = (minutes + ":" + seconds);
        }


        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String findGenre(){
        boolean added = false;
        int songsCount = 0;

        for (int i = 0; i < MAX_SONGS; i++) {

            if(songs[i] != null){
                songsCount++;
            }

        }
        Genre[] genres1 = new Genre[songsCount];

        for (int i = 0; i < songsCount; i++) {

            genres1[i] = songs[i].getGenre();
        }

        Set<Genre> set = new HashSet<Genre>();

        for (Genre x : genres1){

            set.add(x);
        }

        Object[] array =  set.toArray();
        return Arrays.toString(array);

        }


    public void addSong (Song song){

        boolean added = false;
        for (int i = 0; i < MAX_SONGS&&!added; i++) {

            if (songs[i] == null){

                songs[i] = song;
                added = true;
            }
        }

    }

    public void getSongs(){

        for (int i = 0; i < MAX_SONGS; i++) {

            if(songs[i] != null){

                System.out.println(songs[i].getTitle());
            }

        }

    }

    public String getOwner() {
        return owner;
    }

    public void showContents(){

        String msg;
        msg = "**************  Playlist **************\n";
        msg += "**  Title: " + getName() + "\n";
        msg += "**  Duration: " + getDuration() + "\n";
        msg += "**  Genre: " +findGenre() + "\n";
        msg += "***************************************" + "\n";

        System.out.println(msg);


    }

}


