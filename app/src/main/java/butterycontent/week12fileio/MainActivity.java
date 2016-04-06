package butterycontent.week12fileio;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        JSONObject json = createJSONObject();
        //read json file
        try {
            String name = json.getString("name");


        } catch (JSONException e) {

            e.printStackTrace();

        }

        Log.d("JSON", json.toString());
    }

    private JSONObject createJSONObject()
    {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {

            jsonObject.put("name","Tim");
            jsonObject.put("age",24);
            jsonObject2.put("name","Steve");
            jsonObject2.put("age","32");

            jsonArray.put(jsonObject);
            jsonArray.put(jsonObject2);

            Log.d("JSONarray", jsonArray.toString());



        } catch (JSONException e) {

            e.printStackTrace();

        }

        return jsonObject;
    }



    //function to save a file for the save button click listener
    public void saveToFile(View v){

        EditText editText = (EditText) findViewById(R.id.etxtTextEntry);
        String text = editText.getText().toString();
        Log.d("Tag", text);

        try{

           FileOutputStream in = openFileOutput("testIOFile", Context.MODE_PRIVATE);
            in.write(text.getBytes());
            in.close();
            Toast.makeText(this, "done", Toast.LENGTH_LONG).show();
            editText.setText("");

        }catch(Exception e){

            e.printStackTrace();

        }

    }


    public void readFromFile(View v){

        try{

            FileInputStream in = openFileInput("testIOFile");
            int c;
            String temp = "";

            while((c = in.read()) != -1){

                temp = temp + Character.toString((char)c);

            }

            Toast.makeText(this, temp , Toast.LENGTH_LONG ).show();

        }catch(Exception e){

        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            Intent intent = new Intent(this, JsonActivity.class);
            startActivity(intent);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
