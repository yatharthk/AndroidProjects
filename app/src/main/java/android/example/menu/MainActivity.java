package android.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        Log.i(this.getClass().getName(),"Menu is");
        // Find first menu item TextView and print the text to the logs
        TextView t1= (TextView) findViewById(R.id.menu_item_1);
        Log.i(this.getClass().getName(),t1.getText().toString());
        // Find second menu item TextView and print the text to the logs
        t1= (TextView) findViewById(R.id.menu_item_2);
        Log.i(this.getClass().getName(),t1.getText().toString());
        // Find third menu item TextView and print the text to the logs
        t1= (TextView) findViewById(R.id.menu_item_3);
        Log.i(this.getClass().getName(),t1.getText().toString());
    }
}