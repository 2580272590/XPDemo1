package d528okgongju;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.machenike.myapplication.R;

public class Main44Activity extends AppCompatActivity {

    Button m44btn1;
    Button m44btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main44);

        m44btn1 = findViewById(R.id.m44btn1);
        m44btn2 = findViewById(R.id.m44btn2);

        m44btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkUtils okUtils = OkUtils.newInstance();

                okUtils.doGet("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=1", new OkUtils.MyCallBack() {
                    @Override
                    public void error(String s) {
                        Log.d("GET串",s);

                    }

                    @Override
                    public void success(String s) {

                        Log.d("GET串",s);

                    }
                });
            }
        });

        m44btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkUtils okUtils = OkUtils.newInstance();

                okUtils.doPost("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10", new OkUtils.MyCallBack() {
                    @Override
                    public void error(String s) {
                        Log.d("POST串",s);
                    }

                    @Override
                    public void success(String s) {
                        Log.d("POST串",s);
                    }
                },new String[]{"page"},new String[]{"1"});
            }
        });

    }
}
