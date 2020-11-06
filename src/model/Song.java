package model;

public class Song {

    private String title;
    private String artist;
    private String releaseDate;
    private String duration;
    private Genre genre;

    public Song(String title, String artist, String releaseDate, String duration, int genre) {

        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.duration = duration;

        switch (genre) {

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

    /**
     * Returns the song's genre
     * @return genre
     */

    public Genre getGenre() {
        return genre;
    }

    /**
     * Returns the song's title
     * @return title
     */

    public String getTitle() {
        return title;
    }

    /**
     * Returns the song's duration
     * @return song
     */

    public String getDuration() {
        return duration;
    }

    /**
     * Return's the song's artist
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Displays the song's characteristics
     * @return song's characteristics
     */
    public String showContents() {

        String msg = "*************Song************* \n";
        msg += "**" + "Title: " + getTitle() + "\n";
        msg += "**" + "Duration: " + getDuration() + "\n";
        msg += "**" + "Category: " + getGenre().name() + "\n";
        msg += "*******************************";

        return msg;

    }


}
