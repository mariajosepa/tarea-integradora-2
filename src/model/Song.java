package model;

public class Song {

    private String title;
    private String artist;
    private String releaseDate;
    private String duration;
    private Genre genre;

    public Song(String title, String artist, String releaseDate, String duration,int genre){

        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.duration = duration;

        switch(genre){

            case 1:
                this.genre = Genre.ROCK;
                break;
            case 2:
                this.genre = Genre.HIPHOP;
                break;
            case 3:
                this.genre = Genre.CLASSICAL;
                break;
            case 4:
                this.genre = Genre.REGGAE;
                break;
            case 5:
                this.genre = Genre.SALSA;
                break;
            case 6:
                this.genre = Genre.METAL;
                break;



        }


    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }
}
