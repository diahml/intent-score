package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    private TextView tvHome, tvAway, tvScoreHome, tvScoreAway;
    private ImageView ivHome, ivAway;
    Bitmap bitmap_home, bitmap_away;
    String home, away, g_home, g_away;
    Integer home_poin, away_poin;
    Button add1Home, add2Home, add3Home, resetHome;
    Button add1Away, add2Away, add3Away, resetAway;
    Button result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        tvHome = findViewById(R.id.txt_home);
        tvAway = findViewById(R.id.txt_away);
        tvScoreHome= findViewById(R.id.score_home);
        tvScoreAway= findViewById(R.id.score_away);
        ivHome = findViewById(R.id.home_logo);
        ivAway= findViewById(R.id.away_logo);
        add1Home =findViewById(R.id.add1_home);
        add2Home =findViewById(R.id.add2_home);
        add3Home =findViewById(R.id.add3_home);
        resetHome =findViewById(R.id.reset_home);
        add1Away =findViewById(R.id.add1_away);
        add2Away =findViewById(R.id.add2_away);
        add3Away =findViewById(R.id.add3_away);
        resetAway =findViewById(R.id.reset_away);
        tvScoreHome = findViewById(R.id.score_home);
        home_poin = Integer.parseInt(tvScoreHome.getText().toString());
        tvScoreAway = findViewById(R.id.score_away);
        away_poin = Integer.parseInt(tvScoreAway.getText().toString());
        result=findViewById(R.id.btn_result);

        Bundle bundle =getIntent().getExtras();
//        bitmap_home = (Bitmap)this.getIntent().getParcelableExtra("BitmapHome");
//        bitmap_away = (Bitmap)this.getIntent().getParcelableExtra("BitmapAway");
        g_home =bundle.getString("avatarImage");
        g_away= bundle.getString("avatarAway");
        home = bundle.getString("home");
        away = bundle.getString("away");

//        ivHome.setImageBitmap(g_home);
        ivHome.setImageURI(Uri.parse(bundle.getString("BitmapHome")));
        ivAway.setImageURI(Uri.parse(bundle.getString("BitmapAway")));
        tvHome.setText(home);
        tvAway.setText(away);

        add1Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_poin+=1;
                tvScoreHome.setText(String.valueOf(home_poin));
            }
        });

        add2Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_poin+=2;
                tvScoreHome.setText(String.valueOf(home_poin));
            }
        });

        add3Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_poin+=3;
                tvScoreHome.setText(String.valueOf(home_poin));
            }
        });

        resetHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_poin=0;
                tvScoreHome.setText(String.valueOf(home_poin));
            }
        });

        add1Away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                away_poin+=1;
                tvScoreAway.setText(String.valueOf(away_poin));
            }
        });

        add2Away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                away_poin+=2;
                tvScoreAway.setText(String.valueOf(away_poin));
            }
        });

        add3Away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                away_poin+=3;
                tvScoreAway.setText(String.valueOf(away_poin));
            }
        });

        resetAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                away_poin=0;
                tvScoreAway.setText(String.valueOf(away_poin));
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MatchActivity.this, ResultActivity.class);
                intent.putExtra("hometeam",tvHome.getText().toString());
                intent.putExtra("awayteam",tvAway.getText().toString());
                intent.putExtra("homepoin",tvScoreHome.getText().toString());
                intent.putExtra("awaypoin",tvScoreAway.getText().toString());
                startActivity(intent);
            }
        });

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
