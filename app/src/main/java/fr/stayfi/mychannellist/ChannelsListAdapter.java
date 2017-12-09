package fr.stayfi.mychannellist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Stayfi on 06/12/2017.
 */

public class ChannelsListAdapter extends BaseAdapter {
    private ArrayList<Channel> channels;
    private MainActivity context;
    private static LayoutInflater inflater=null;
    private OnClickListener channelClickListener;
    private Integer actualChannelPosition = 0;

    public ChannelsListAdapter(MainActivity context, ArrayList<Channel> channels) {
        this.context = context;
        actualChannelPosition = 0;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setChannels(channels);
    }

    public Integer getActualChannelPosition() {
        return actualChannelPosition;
    }

    public void updateChannels(ArrayList<Channel> channels) {
        actualChannelPosition = 0;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setChannels(channels);
    }
    @Override
    public int getCount() {
        return channels.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        actualChannelPosition = position;
        Holder holder = new Holder();
        ChannelView rowView = (ChannelView) inflater.inflate(R.layout.channel, null);
        holder.img= rowView.findViewById(R.id.channelPicon);
        holder.txt= rowView.findViewById(R.id.channelName);
        holder.txt.setText(channels.get(position).getName());
        int idPicon = context.getResources().getIdentifier(channels.get(position).getPicon(), "drawable", context.getPackageName());
        holder.img.setImageResource(idPicon);
        rowView.setChannelPosition(position);
        rowView.setOnClickListener(channelClickListener);

        return rowView;
    }


    public void setChannelClickListener(OnClickListener channelClickListener) {
        this.channelClickListener = channelClickListener;
    }
    public class Holder
    {
        ImageView img;
        TextView txt;
    }
    private void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }
}
