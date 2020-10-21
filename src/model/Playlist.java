package model;

public class Playlist {

    private static final int MAX_GENRES = 6;
    private static final int MAX_SONGS = 10;

    private String name;
    private String duration;
    private String[] genres;
    private Song[] songs;

    public Playlist(String name){
        this.name = name;
        duration = "0:0";
        genres = null;
        songs = null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void findGenre(){

        for (int i = 0; i < MAX_SONGS; i++) {

            if(songs[i] != null){

                genres[i] = songs[i].getGenre().name() + " ";
            }

        }

    }

}


