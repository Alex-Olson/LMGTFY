package com.example.angel.lmgtfy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.net.*;
import android.view.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //nothing before super.onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //start stuff here
        Button b = (Button)findViewById(R.id.clickbutton);
        b.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText searchBox = (EditText)findViewById(R.id.string_to_search);
                String searchString = searchBox.getText().toString();
                TextView tv = (TextView) findViewById(R.id.show_search_text);
                tv.setText("Searching for " + searchString);
                //toast
                Toast t = Toast.makeText(MainActivity.this, searchString, Toast.LENGTH_LONG);
                t.show();
                //intent
                String search = "http://google.com/search?q=" + searchString;
                Uri searchUri = Uri.parse(search);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, searchUri);
                startActivity(browserIntent);
            }
        });

        //try out geocoding
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
