package lucasfscr.com.somdosbichos;import android.app.Activity;import android.media.MediaPlayer;import android.os.Bundle;import android.view.View;import android.widget.ImageView;import butterknife.BindView;import butterknife.ButterKnife;public class MainActivity extends Activity implements View.OnClickListener{    @BindView(R.id.imgDog)    ImageView imgDog;    @BindView(R.id.imgCat)    ImageView imgCat;    @BindView(R.id.imgLion)    ImageView imgLion;    @BindView(R.id.imgMonkey)    ImageView imgMonkey;    @BindView(R.id.imgSheep)    ImageView imgSheep;    @BindView(R.id.imgCow)    ImageView imgCow;    MediaPlayer mediaPlayer;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        ButterKnife.bind(this);        imgDog.setOnClickListener(this);        imgCat.setOnClickListener(this);        imgLion.setOnClickListener(this);        imgMonkey.setOnClickListener(this);        imgSheep.setOnClickListener(this);        imgCow.setOnClickListener(this);    }    @Override    public void onClick(View view) {        switch (view.getId()){            case R.id.imgDog:                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.dog);                playMusic();                break;            case R.id.imgCat:                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cat);                playMusic();                break;            case R.id.imgLion:                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.lion);                playMusic();                break;            case R.id.imgMonkey:                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.monkey);                playMusic();                break;            case R.id.imgSheep:                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sheep);                playMusic();                break;            case R.id.imgCow:                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cow);                playMusic();                break;        }    }    private void playMusic() {        if(mediaPlayer != null){            mediaPlayer.start();        }    }    @Override    protected void onDestroy() {        if(mediaPlayer != null){            mediaPlayer.release();            mediaPlayer = null;        }        super.onDestroy();    }}