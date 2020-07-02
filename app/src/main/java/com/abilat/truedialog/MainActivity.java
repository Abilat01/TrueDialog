package com.abilat.truedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog = (Button) findViewById(R.id.btb_dialog);
        btnDialog.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btb_dialog:
                createTwoButtonsAlertDialog("Вы в чем то уверенны?", "Все в этой жизни" +
                        "лишь страдание и хаус, нет смысла противиться смерти");
                break;
        }

    }

    private void createTwoButtonsAlertDialog(String title,String content){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                showMessage("Вы нажали нет");
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                showMessage("Вы нажали ОК");
            }
        });
        builder.show();
    }

    // вспомогательный метод для вывода всплывающих сообщений
    private void showMessage(String textInMessage) {
        Toast.makeText(getApplicationContext(), textInMessage, Toast.LENGTH_LONG).show();
    }



}

