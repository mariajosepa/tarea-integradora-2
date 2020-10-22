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

        rating = rating/rated;

        return rating;
    }
}
