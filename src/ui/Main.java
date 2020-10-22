package ui;

import model.*;
public class Main {

    public static void main (String [] args){


        MCS mcs = new MCS();
        mcs.register("majito","1234",18);
        mcs.register("jorge","1234",13);
        mcs.login("majito","1234");

        mcs.addSongToPool("jeje","20/20/20","0/0","0:0",1);


        mcs.createPlaylist("hole",2);
        mcs.createPlaylist("holi",3);

        System.out.print(mcs.addSongToPlaylist());
        mcs.addUserToPlaylist();
        System.out.println(mcs.logOut());

        System.out.println(mcs.login("jorge","1234"));
        System.out.print(mcs.addSongToPlaylist());
        mcs.ratePlaylist();



    }
}
