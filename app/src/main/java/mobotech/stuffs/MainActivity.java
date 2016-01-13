package mobotech.stuffs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mobotech.stuffs.adapter.RecyclerViewAdapter;
import mobotech.stuffs.model.Person;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.rv)
    RecyclerView recyclerView;

    @InjectView(R.id.listView)
    ListView listView;

    @InjectView(R.id.listView2)
    ListView listView2;

    private List<Person> persons;

    private String[] myListViewList = {"Bpn" , "Amn" , "Ktm" , "Btl" , "eee" , "ttt" , "uuu" , "iii" , "999" , "qqq" , "www" , "rrr" , "ttt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initializeData();

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myListViewList));
        listView2.setAdapter(new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , myListViewList));

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new RecyclerViewAdapter(persons));
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
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
