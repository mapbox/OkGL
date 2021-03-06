package com.mapbox.okgl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ImageFragment())
                    .commit();
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
        Fragment newFragment = null;
        switch (id) {
            case R.id.menuItemImageDemo:
                newFragment = new ImageFragment();
                break;
            case R.id.menuItemFontDemo:
                newFragment = new FontFragment();
                break;
            case R.id.menuItemStylesDemo:
                newFragment = new StylesFragment();
                break;
            case R.id.menuItemProtoBufDemo:
                newFragment = new ProtoBufFragment();
                break;
        }
        if (newFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).addToBackStack(null).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
