package edu.orangecoastcollege.cs273.tapcounter;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private Button tapButton;
    private TextView countTextView;

    // Associate the controller with the needed model
    Counter currentCount = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tapButton = (Button) findViewById(R.id.tapButton);
        countTextView = (TextView) findViewById(R.id.countTextView);

        readCount();

        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCount.AddCount();
                //Toast.makeText(MainActivity.this, "Test ClickListener", Toast.LENGTH_SHORT).show();
                countTextView.setText(String.valueOf(currentCount.getmCount()));
                saveCount(currentCount.getmCount());
            }
        });
    }

    public void saveCount(int count)
    {
        String data = String.valueOf((count));
        String fileName = "save_file";
        try{
            FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            //Toast.makeText(getApplicationContext(),"tapCount was saved.", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCount()
    {
        try{
            FileInputStream fis = openFileInput("save_file");
            InputStreamReader isr = new InputStreamReader((fis));
            BufferedReader bufferReader = new BufferedReader(isr);
            StringBuffer stringBuffer = new StringBuffer();
            String count;
            while((count = bufferReader.readLine())!= null)
            {
                stringBuffer.append(count);
                currentCount.setmCount(Integer.parseInt(stringBuffer.toString()));
                // load count from file
                //((TextView) findViewById(R.id.countTextView)).setText(count);
                countTextView.setText(count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
