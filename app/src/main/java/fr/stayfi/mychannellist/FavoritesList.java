package fr.stayfi.mychannellist;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Stayfi on 07/12/2017.
 */

public class FavoritesList {
    private MainActivity context;
    private ArrayList<Favorite> favoritesList = new ArrayList<>();
    private ImageButton
            favoritesPrev, favoritesNext;
    private TextView favoriteName;
    private ListView favoritesListView;
    private Integer actualFavoritePosition = 0;
    private ArrayList<Channel> actualFavList;
    private OnClickListener channelClickListener;
    private ChannelsListAdapter channelsListAdapter;

    public FavoritesList(MainActivity context) {
        this.context      = context;
        favoritesPrev     = context.findViewById(R.id.favoritesPrev);
        favoriteName      = context.findViewById(R.id.favoriteName);
        favoritesNext     = context.findViewById(R.id.favoritesNext);
        favoritesListView = context.findViewById(R.id.channelsList);

        FavoritesListProvider favoritesListProvider = new FavoritesListProvider();
        favoritesList = favoritesListProvider.getFavoritesList();

        if (favoritesList.size() > 0) {
            actualFavList = favoritesList.get(actualFavoritePosition).getChannels();
            channelsListAdapter = new ChannelsListAdapter( this.context, actualFavList);
            if (favoritesList.size() > 1) {
                initEvenements();
            } else {
                favoritesPrev.setVisibility(View.INVISIBLE);
                favoritesNext.setVisibility(View.INVISIBLE);
            }
        } else {
            channelsListAdapter = new ChannelsListAdapter( this.context, new ArrayList<Channel>());
        }
    }

    public ArrayList<Channel> getActualFavList() {
        return actualFavList;
    }

    private void initEvenements() {
        favoritesPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevFavorite();
            }
        });
        favoritesNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFavorite();
            }
        });
    }

    public void prevFavorite() {
        actualFavoritePosition -= 1;
        if (actualFavoritePosition < 0) {
            actualFavoritePosition = favoritesList.size() - 1;
        }
        updateFavoriteView();
    }

    public void nextFavorite() {
        actualFavoritePosition += 1;
        if (actualFavoritePosition >= favoritesList.size()) {
            actualFavoritePosition = 0;
        }
        updateFavoriteView();
    }

    public void updateFavoriteListAdapter() {
        if (favoritesList.size() > 0) {
            favoriteName.setText(favoritesList.get(actualFavoritePosition).getName());
            actualFavList = favoritesList.get(actualFavoritePosition).getChannels();
            channelsListAdapter.updateChannels(actualFavList);
            channelsListAdapter.setChannelClickListener(channelClickListener);
            favoritesListView.setAdapter(channelsListAdapter);
        } else {
            favoriteName.setText(R.string.no_favorites);
        }
    }

    public void updateFavoriteView() {
        updateFavoriteListAdapter();
        ((BaseAdapter) favoritesListView.getAdapter()).notifyDataSetChanged();
    }

    public void setChannelClickListener(OnClickListener channelClickListener) {
        this.channelClickListener = channelClickListener;
        updateFavoriteListAdapter();
    }
}
