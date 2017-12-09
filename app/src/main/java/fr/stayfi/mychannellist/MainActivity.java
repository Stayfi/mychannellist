package fr.stayfi.mychannellist;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FavoritesList favoritesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_main);

        favoritesList = new FavoritesList(this);
        favoritesList.setChannelClickListener(channelClickListener);
    }

    private OnClickListener channelClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer channelPosition = ((ChannelView) v).getChannelPosition();
            ArrayList<Channel> actualFavList = favoritesList.getActualFavList();
            Channel actualChannel = actualFavList.get(channelPosition);
            Toast.makeText(
                    MainActivity.this,
                    "Name: " + actualChannel.getName() +
                            "\nPicon: " + actualChannel.getPicon() +
                            "\nURI: " + actualChannel.getURI()
                    , Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setTitle(R.string.quit)
                    .setMessage(R.string.really_quit)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                       @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton(R.string.no, null)
                    .show();

            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
