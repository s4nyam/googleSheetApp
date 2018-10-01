package androidlabs.gsheets2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidlabs.gsheets2.Post.PostData;

/**
 * Created by sanyam on 10/1/2018.
 *
 /$$
 | $$
 /$$$$$$$  /$$$$$$  /$$$$$$$  /$$   /$$  /$$$$$$  /$$$$$$/$$$$        /$$  /$$  /$$  /$$$$$$   /$$$$$$$      | $$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$
 /$$_____/ |____  $$| $$__  $$| $$  | $$ |____  $$| $$_  $$_  $$      | $$ | $$ | $$ |____  $$ /$$_____/      | $$__  $$ /$$__  $$ /$$__  $$ /$$__  $$
 |  $$$$$$   /$$$$$$$| $$  \ $$| $$  | $$  /$$$$$$$| $$ \ $$ \ $$      | $$ | $$ | $$  /$$$$$$$|  $$$$$$       | $$  \ $$| $$$$$$$$| $$  \__/| $$$$$$$$
 \____  $$ /$$__  $$| $$  | $$| $$  | $$ /$$__  $$| $$ | $$ | $$      | $$ | $$ | $$ /$$__  $$ \____  $$      | $$  | $$| $$_____/| $$      | $$_____/
 /$$$$$$$/|  $$$$$$$| $$  | $$|  $$$$$$$|  $$$$$$$| $$ | $$ | $$      |  $$$$$/$$$$/|  $$$$$$$ /$$$$$$$/      | $$  | $$|  $$$$$$$| $$      |  $$$$$$$
 |_______/  \_______/|__/  |__/ \____  $$ \_______/|__/ |__/ |__/       \_____/\___/  \_______/|_______/       |__/  |__/ \_______/|__/       \_______/
 /$$  | $$
 |  $$$$$$/
 \______/

 *
 *
 */




public class MainPage extends AppCompatActivity{

    Button getData;
    Button sendData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        sendData=(Button)findViewById(R.id.insertUser);
        getData=(Button)findViewById(R.id.viewUser);

        getData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), UserList.class);
                startActivity(intent);

            }

        });
        sendData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), PostData.class);
                    startActivity(intent);
            }

        });


    };



    }

