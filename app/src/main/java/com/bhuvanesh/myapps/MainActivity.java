package com.bhuvanesh.myapps;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String NEWS_KEY = "news_key";
    DrawerLayout dl;
    ListView lvLeft, lvRight;
    ArrayAdapter adapter;
    ActionBarDrawerToggle drawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout) findViewById(R.id.drawerLayout);
        lvLeft = (ListView) findViewById(R.id.lvDrawerListLeft);
        lvRight = (ListView) findViewById(R.id.lvDrawerListRight);
        lvLeft.setOnItemClickListener(this);
        adapter = ArrayAdapter.createFromResource(this, R.array.AppList, android.R.layout.simple_list_item_1);
        lvLeft.setAdapter(adapter);
        drawerListener = new ActionBarDrawerToggle(this, dl, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                lvLeft.bringToFront();
                dl.requestLayout();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //getSupportActionBar().setTitle(adapter.getItem(position).toString());
        Log.d("dl", "drawer list position "+position);
        Toast.makeText(getBaseContext(), ""+position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Settings");
        menu.add("Help");
        menu.add("About App");
        return super.onCreateOptionsMenu(menu);
    }

    public void openNewActivity(View view) {
        switch (view.getId()) {
            case R.id.btncalc:
                Intent intent = new Intent(this, CalculatorActivity.class);
                startActivity(intent);
                break;
            case R.id.btnbench:
                Intent intentBenchmark = new Intent(this, BenchmarkActivity.class);
                startActivity(intentBenchmark);
                break;
            case R.id.btnGreetUser:
                Intent intentGreetUser = new Intent(this, GreetUserActivity.class);
                startActivity(intentGreetUser);
                break;
            case R.id.btnUserRegForm:
                Intent intentUserRegForm = new Intent(this, UserRegistrationActivity.class);
                startActivity(intentUserRegForm);
                break;
            case R.id.btnFelightNews:
                Intent intentFelightNews = new Intent(this, NewsActivity.class);
                intentFelightNews.putExtra(NEWS_KEY, "Felight news get displayed on NEWS activity");
                startActivity(intentFelightNews);
                break;
            case R.id.btnGoogleNews:
                Intent intentGoogleNews = new Intent(this, NewsActivity.class);
                intentGoogleNews.putExtra(NEWS_KEY, "Google news get displayed on NEWS activity");
                startActivity(intentGoogleNews);
        }
    }


}
