package com.example.kosta.fileexam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private FileManager fileManager;

    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileManager = new FileManager(this);
        result = (EditText)findViewById(R.id.result);
    }

    public void clickEvent(View v) {
        switch(v.getId()) {
            case R.id.save:
                fileManager.save(result.getText().toString());
                result.setText("");
                break;
            case R.id.load:
                result.setText(fileManager.load());
                break;
            case R.id.delete:
                fileManager.delete();
                break;
        }
    }
}
