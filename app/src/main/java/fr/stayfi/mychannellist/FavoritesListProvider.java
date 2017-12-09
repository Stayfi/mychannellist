package fr.stayfi.mychannellist;

import java.util.ArrayList;

/**
 * Created by Stayfi on 08/12/2017.
 */

public class FavoritesListProvider {
    private ArrayList<Favorite> favoritesList = new ArrayList<>();

    public FavoritesListProvider() {
        initFavoritesList();
    }

    public ArrayList<Favorite> getFavoritesList() {
        return favoritesList;
    }

    protected void initFavoritesList() {
        ArrayList<Channel> channelsFav1 = new ArrayList<>();
        Favorite Fav1 = new Favorite("Favorite Name", channelsFav1);
        Channel channel1 = new Channel("Channel 1", "pic_channel_1", "");
        channelsFav1.add(channel1);
        favoritesList.add(Fav1);
    }
}
