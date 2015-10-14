package shouzo.app_20151012_picture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText h, w;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = (EditText) findViewById(R.id.h);
        w = (EditText) findViewById(R.id.w);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    float h1 = Integer.parseInt(h.getText().toString());
                    float w1 = Integer.parseInt(h.getText().toString());

                    textView.setText(Float.toString(((float) w1 / (h1 /100) / (h1 / 100))));
                }
        });
    }
}
