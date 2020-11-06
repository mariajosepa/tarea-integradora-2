package model;

public class PublicPlaylist extends Playlist{

    private double rating;
    private double ratingTotal;
    private int rated;

    public PublicPlaylist(String name) {
        super(name);
        rating = 0.0;
        ratingTotal = 0;
        rated = 0;
    }


    /**
     * Adds a new rating to the playlist
     * @param rating rating (1-5) of the playlist
     */

    public void addRating(int rating){

        System.out.println(this.rating);
        System.out.println(rated);

        ratingTotal += rating;
        rated++;

        this.rating = ratingTotal / rated;

        System.out.println(this.rating);
        System.out.println(rated);

    }


    /**
     * Return's the playlist's rating
     * @return current playlist rating
     */

    public double getRating(){

        return rating;

    }


    /**
     * Displays information about the playlist
     * @return information about the playlist
     */
    @Override
    public String showContents (){

        String msg;
        msg = "**************  Playlist **************\n";
        msg += "**  Title: " + getName() + "\n";
        msg += "**  Duration: " + getDuration() + "\n";
        msg += "**  Genre: " + findGenre() + "\n";
        msg+=  "**  Rating:  "+ getRating()  + "\n";
        msg += "***************************************" + "\n";

        return msg;

    }


}
