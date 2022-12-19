package id.ac.umn.dotapp;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity  {
    Button bt1,bt2;
    EditText et1,et2;

    TextView tv1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt1 = (Button)findViewById(R.id.button);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);

        bt2 = (Button)findViewById(R.id.button2);
        tv1 = (TextView)findViewById(R.id.textView3);
        tv1.setVisibility(View.GONE);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().equals("admin") &&
                        et2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                            tv1.setVisibility(View.VISIBLE);
                    tv1.setBackgroundColor(Color.RED);
                    counter--;
                    tv1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        bt1.setEnabled(false);
                    }
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}