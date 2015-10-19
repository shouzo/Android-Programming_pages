package shouzo.app_20151019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_2 extends AppCompatActivity {
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        if (getIntent().getExtras() != null) {
            String name = getIntent().getExtras().getString("name");
            textView.setText("Hello, " + name);
        }

        if (savedInstanceState != null) {
            String name = savedInstanceState.getString("name");
            textView.setText(name);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", editText.getText().toString());
    }
}
