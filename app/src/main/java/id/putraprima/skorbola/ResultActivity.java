package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView result, skor;
    String skor_home, skor_away, home_team, away_team;
    Integer home_score, away_score;

    public void handleBack(View view){
        Intent move = new Intent (ResultActivity.this, MainActivity.class);
        startActivity(move);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        skor = findViewById(R.id.tvskor);
        result = findViewById(R.id.tvteam);

        Bundle bundle =getIntent().getExtras();
        skor_home = bundle.getString("homepoin");
        skor_away = bundle.getString("awaypoin");
        home_team = bundle.getString("hometeam");
        away_team = bundle.getString("awayteam");
        home_score = Integer.parseInt(skor_home);
        away_score = Integer.parseInt(skor_away);

        if(home_score>away_score){
            result.setText(home_team);
            skor.setText(String.valueOf(skor_home));
        }else if(away_score>home_score){
            result.setText(away_team);
            skor.setText(String.valueOf(skor_away));
        }
    }

}
