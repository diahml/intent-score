package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;
    private static final int PHOTO_REQUEST_CODE = 2;
    private EditText etHome, etAway;
    private Uri avatarImage;
    private Uri avatarAway;
    private Bitmap bitmap_home, bitmap_away;
    private ImageView home;
    private ImageView away;
    private Button btn_next;

    public void InsertPhoto(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public void InsertPhoto_away(View view) {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PHOTO_REQUEST_CODE);
    }

//    public void handleNext(View view){
//        Intent move = new Intent (MainActivity.this, MatchActivity.class);
//        startActivity(move);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home=(ImageView) findViewById(R.id.home_logo);
        away=(ImageView) findViewById(R.id.away_logo);
        etHome=findViewById(R.id.home_team);
        etAway=findViewById(R.id.away_team);
        btn_next=findViewById(R.id.next);
        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String home = etHome.getText().toString();
                String away = etAway.getText().toString();
                Intent intent = new Intent (MainActivity.this, MatchActivity.class);
                intent.putExtra("home",home);
                intent.putExtra("away",away);
                intent.putExtra("BitmapHome", avatarImage.toString());
                intent.putExtra("BitmapAway", avatarAway.toString());
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Log.d(TAG, "Pilih gambar dibatalkan");
            return;
        }
        else if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
//                    Uri imageUri = data.getData();
                    avatarImage = data.getData();
                   bitmap_home = MediaStore.Images.Media.getBitmap(this.getContentResolver(), avatarImage);
                    home.setImageBitmap(bitmap_home);

                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
        else if (requestCode == PHOTO_REQUEST_CODE) {
            if (data != null) {
                try {
//                    Uri imageUri = data.getData();
                    avatarAway = data.getData();
                    bitmap_away = MediaStore.Images.Media.getBitmap(this.getContentResolver(), avatarAway);
                    away.setImageBitmap(bitmap_away);

                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

}
