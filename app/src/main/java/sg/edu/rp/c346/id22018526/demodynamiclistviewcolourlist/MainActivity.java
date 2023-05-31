package sg.edu.rp.c346.id22018526.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnUpdate;
    Button btnRemove;
    ListView lvColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextPosition);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        lvColour = findViewById(R.id.listViewColour);
        ArrayList alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter (this,android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour = etElement.getText().toString();
                String position = etIndexElement.getText().toString();
                int finalposition = Integer.parseInt(position);
                alColours.add(finalposition,newcolour);
                aaColour.notifyDataSetChanged();

            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour = etElement.getText().toString();
                String position = etIndexElement.getText().toString();
                int finalposition = Integer.parseInt(position);
                alColours.remove(finalposition);
                alColours.remove(newcolour);
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour = etElement.getText().toString();
                String position = etIndexElement.getText().toString();
                int finalposition = Integer.parseInt(position);
                alColours.set(finalposition,newcolour);
                aaColour.notifyDataSetChanged();

            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = (String) lvColour.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,colour,Toast.LENGTH_SHORT).show();

            }
        });
    }
}