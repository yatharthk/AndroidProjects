package android.example.firstmediaplayer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
MediaPlayer player ;
int vol=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player=MediaPlayer.create(this,R.raw.song2);
        player.setVolume(vol,vol);

    }

    public void playSong(View v){
        Toast.makeText(this,"Playing",Toast.LENGTH_SHORT).show();
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this,"I am done",Toast.LENGTH_SHORT).show();
            }
        });

        MediaPlayer.OnCompletionListener

    }

    public void pauseSong(View v){
        player.pause();
        Toast.makeText(this,"Paused",Toast.LENGTH_SHORT).show();
    }

    public void seekBackwards(View v){

        Toast.makeText(this,"-5 sec",Toast.LENGTH_SHORT).show();
        player.seekTo(-5000);
    }

    public void seekForward(View v)
    {
        Toast.makeText(this,"+5 sec ",Toast.LENGTH_SHORT).show();
        player.seekTo(5000);
    }

    public void volumeUp(View v){
        vol+=1;
        player.setVolume(vol,vol);
        Toast.makeText(this,"Volume Up",Toast.LENGTH_SHORT).show();
    }

    public void volumeDown(View v){
        vol-=1;
        player.setVolume(vol,vol);
        Toast.makeText(this,"Volume Down",Toast.LENGTH_SHORT).show();
    }


}