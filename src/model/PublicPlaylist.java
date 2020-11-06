package model;

public class PublicPlaylist extends Playlist{

    private double rating;
    private double rated;

    public PublicPlaylist(String name) {
        super(name);
        rating = 0;
        rated = 0;
    }


    /**
     * Adds a new rating to the playlist
     * @param rating rating (1-5) of the playlist
     */

    public void addRating(int rating){

        this.rating += rating;
        rated++;

    }

    /**
     * Returns the current rating of the playlist by averaging all ratings
     * @return total rating of the playlist
     */


    public double getRating(){

        if (rated >0) {
            rating = rating / rated;

        }
        else{

            rating = 0;
        }

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
