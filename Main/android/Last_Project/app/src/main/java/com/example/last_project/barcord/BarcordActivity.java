package com.example.last_project.barcord;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 67d7b248d5491efa70614e8291fddc2859d434ca
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
<<<<<<< HEAD
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.SearchActivity;
=======
>>>>>>> 67d7b248d5491efa70614e8291fddc2859d434ca
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class BarcordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcord);

        barcodeLauncher.launch(new ScanOptions());
    }
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(BarcordActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(BarcordActivity.this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
<<<<<<< HEAD
                    CommonConn conn = new CommonConn(BarcordActivity.this, "barcord");
                    conn.addParams("barcord_number", result.getContents().toString());
                    conn.executeConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            Intent intent = new Intent(BarcordActivity.this, SearchActivity.class);
                            intent.putExtra("barcord_search_name", result.getContents() );
                            startActivity(intent);
                        }
                    });
=======
>>>>>>> 67d7b248d5491efa70614e8291fddc2859d434ca
                }
            });
}