package sg.edu.rp.soi.p06_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    TextView tv1, tv2;
    Button btnreset;
    int plus = 0;
    int minus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.etNum1);
        ed2 = findViewById(R.id.etNum2);
        tv1 = findViewById(R.id.tvOperation);
        tv2 = findViewById(R.id.textView);
        btnreset = findViewById(R.id.btnReset);

        registerForContextMenu(tv1);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
                tv2.setText("");
            }
        });


    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "+");
        menu.add(0, 1, 1, "-");


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        int a = Integer.parseInt(ed1.getText().toString());
        int b = Integer.parseInt(ed2.getText().toString());

    if (id == 0) {
        plus = a + b;
        tv2.setText(plus + "");
        return true;
    } else if(id == 1){
        minus = a - b;
        tv2.setText(minus + "");
        return true;
    }
    else{
        tv2.setText("Error");
    }
    return super.onContextItemSelected(item);
    }




}