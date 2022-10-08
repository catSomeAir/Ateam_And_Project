package com.example.last_project.barcode;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.SearchActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class BarcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        barcodeLauncher.launch(new ScanOptions());
    }
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(BarcodeActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(BarcodeActivity.this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                    CommonConn conn = new CommonConn(BarcodeActivity.this, "barcode");
                    conn.addParams("barcode_number", result.getContents().toString());
                    conn.executeConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            Intent intent = new Intent(BarcodeActivity.this, SearchActivity.class);
                            intent.putExtra("barcode_search_name", data );
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            });
}