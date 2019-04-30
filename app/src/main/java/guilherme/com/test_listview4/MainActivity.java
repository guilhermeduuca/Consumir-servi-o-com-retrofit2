package guilherme.com.test_listview4;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.AndroidException;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    EditText inputtext1;
    Button btnAdd, btnUpdate;

    ArrayList<String> foods = new ArrayList<String>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView1 = (ListView) findViewById(R.id.listView);
        btnAdd = (Button) findViewById(R.id.button1);
        btnUpdate = (Button) findViewById(R.id.button2);
        inputtext1 = (EditText) findViewById(R.id.editText);

        // setup listview
        foods.add("Presunto");
        foods.add("Pão");



        myAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);

        listView1.setAdapter(myAdapter1);

        // ADD Itens
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String stringval = inputtext1.getText().toString();
                for(String name : foods){
                    if(name.equals(stringval)){
                        inputtext1.setText(name);
                    }
                }

                foods.add(stringval);
                myAdapter1.notifyDataSetChanged();

                inputtext1.setText("");


            }
        });

        //Select item

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been selected";
                indexVal = i;
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();



            }
        });

        //UPDATE

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringval = inputtext1.getText().toString();
                foods.set(indexVal, stringval);
                myAdapter1.notifyDataSetChanged();


            }
        });

        //DELETE
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been deleted";
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();

                foods.remove(i);
                myAdapter1.notifyDataSetChanged();


                return ;


            }
        });


    }
}
