package model;

public class PublicPlaylist extends Playlist{

    private int rating;
    private int rated;

    public PublicPlaylist(String name, String owner) {
        super(name,owner);
        rating = 0;
    }


    @Override
    public int getType(){

        return 3;
    }

    public void addRating(int rating){

        this.rating += rating;
        rated++;

    }


    public int getRating(){

        if (rating >0) {
            rating = rating / rated;

        }
        else{

            rating = 0;
        }

        return rating;
    }


    @Override
    public String showContents (){

        String msg;
        msg = "**************  Playlist **************\n";
        msg += "**  Title: " + getName() + "\n";
        msg += "**  Duration: " + getDuration() + "\n";
        msg += "**  Genre: " + findGenre() + "\n";
        msg+= " **  Rating:  "+ getRating()  + "\n";
        msg += "***************************************" + "\n";

        return msg;

    }


}
