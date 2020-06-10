package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */

public class Exercises2 extends AppCompatActivity {

    private TextView mycount;
    private static final String TAG = "zxr";
    private static int viewCount = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises2);
        mycount = findViewById(R.id.countview);
        Log.d(TAG,"1");
        final View view_layout;
        View view = this.getWindow().getDecorView();
        Log.d(TAG,"2");
        mycount.setText("页面中view的个数是"+String.valueOf(getAllChildViewCount(view)));
        //mycount.setText("1");
        Log.d(TAG,"3");
    }

    public int getAllChildViewCount(View view) {
        if (null == view) {
            Log.d(TAG,"error");
            return 0;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LinkedList<ViewGroup> linkedList = new LinkedList<>();
            linkedList.add(viewGroup);
            while (!linkedList.isEmpty()) {

                ViewGroup current = linkedList.removeFirst();
                viewCount++;
                for (int i = 0; i < current.getChildCount(); i++) {
                    if (current.getChildAt(i) instanceof ViewGroup) {
                        linkedList.addLast((ViewGroup) current.getChildAt(i));
                    } else {
                        viewCount++;
                    }
                }
            }
        }
        else {
            viewCount++;
        }
        Log.d(TAG,"correct");
        return viewCount;
   }
}

