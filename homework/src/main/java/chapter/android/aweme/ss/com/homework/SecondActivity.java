package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView numberView;
    private static int clickedItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("zxr-1","successful");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        numberView = findViewById(R.id.ed_say);
        Log.d("zxr-1","------------------------------");
        Intent intent = getIntent();
        clickedItemIndex = intent.getIntExtra("ItemIndex", 0);
        Log.d("zxr-1","b"+String.valueOf(clickedItemIndex));
        numberView.setText("该item的序列号是："+String.valueOf(clickedItemIndex));

    }
}
