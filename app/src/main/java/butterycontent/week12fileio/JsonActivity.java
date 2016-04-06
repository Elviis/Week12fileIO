package butterycontent.week12fileio;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


//get json file data
    public void readJsonFile(View v){

        Resources res = getResources();
        try{

            InputStream in = res.openRawResource(R.raw.json_file);
            int c ;
            String temp = "";

            while((c = in.read()) != -1) {
                temp = temp + Character.toString((char)c);
            }

            JSONObject object = new JSONObject(temp);

            Toast.makeText(this,temp,Toast.LENGTH_LONG).show();

            JSONObject jsonObject = new JSONObject(temp);

            String name = jsonObject.getString("firstName");

            Toast.makeText(this,name,Toast.LENGTH_LONG).show();


        }catch(Exception e){

        }

    }

}
