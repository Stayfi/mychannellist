package fr.stayfi.mychannellist;

import java.util.ArrayList;

/**
 * Created by Stayfi on 06/12/2017.
 */

public class Favorite {

    private String name;
    private ArrayList<Channel> channels;

    public Favorite(String name, ArrayList<Channel> channels) {
        setName(name);
        setChannels(channels);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }
}
