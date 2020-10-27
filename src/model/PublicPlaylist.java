package model;

public class PublicPlaylist extends Playlist{

    private double rating;
    private int rated;

    public PublicPlaylist(String name, String owner) {
        super(name,owner);
        rating = 0;
    }

    /**
     * Returns playlist type (3)
     * @return playlist type (3) (public)
     */
    @Override
    public int getType(){

        return 3;
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

        if (rating >0) {
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
