package mobotech.stuffs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<String> nameList = new ArrayList<>();
    CustomListWithCheckboxAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        initializeArrayNameList();
        adapter = new CustomListWithCheckboxAdapter(this , nameList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private void initializeArrayNameList(){

        for (int i = 0 ; i < 10 ; i++){
            nameList.add("name: "+ i);
        }

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this , "Clicked at: "+ i , Toast.LENGTH_SHORT).show();

    }

}
