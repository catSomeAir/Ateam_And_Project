package com.example.last_project.model.detail.writng;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class WriteSpaceActivity extends AppCompatActivity {
    EditText edt_writing;
    RadioGroup radiogroup_writting;
    RadioButton radio_all, radio_opinion, radio_qna;
    LinearLayout ln_write_commit; //등록버튼
    View space_background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_space);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        edt_writing = findViewById(R.id.edt_writing);

        space_background = findViewById(R.id.space_background);
        //백그라운드 터치시 종료시키기
        space_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(edt_writing.getWindowToken(), 0);
                finish();
            }
        });

        ln_write_commit = findViewById(R.id.ln_write_commit);


        edt_writing.requestFocus();
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        edt_writing.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edt_writing.getText().length() == 0){
                    ln_write_commit.setVisibility(View.GONE);
                }else{
                    ln_write_commit.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //버튼
        radiogroup_writting = findViewById(R.id.radiogroup_writting);
        radio_all = findViewById(R.id.radio_all);
        radio_opinion = findViewById(R.id.radio_opinion);
        radio_qna = findViewById(R.id.radio_qna);
        radiogroup_writting.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getCheckedRadioButtonId() == R.id.radio_all) {

                } else if (group.getCheckedRadioButtonId() == R.id.radio_opinion) {

                } else if (group.getCheckedRadioButtonId() == R.id.radio_qna) {

                }
            }
        });

        //
    }
}