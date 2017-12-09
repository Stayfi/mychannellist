package fr.stayfi.mychannellist;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

/**
 * Created by Stayfi on 08/12/2017.
 */

public class ChannelView extends ConstraintLayout {
    private Integer channelPosition = 0;
    public ChannelView(Context context) {
        super(context);
    }
    public ChannelView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    public ChannelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public void setChannelPosition(Integer channelPosition) {
        this.channelPosition = channelPosition;
    }

    public Integer getChannelPosition() {
        return channelPosition;
    }
}
