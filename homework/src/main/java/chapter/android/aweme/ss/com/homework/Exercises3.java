package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.PullParser;
import chapter.android.aweme.ss.com.homework.model.Message;

/**
 * 大作业:实现一个抖音消息页面,
 * 1、所需的data数据放在assets下面的data.xml这里，使用PullParser这个工具类进行xml解析即可
 * <p>如何读取assets目录下的资源，可以参考如下代码</p>
 * <pre class="prettyprint">
 *
 *         @Override
 *     protected void onCreate(@Nullable Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.activity_xml);
 *         //load data from assets/data.xml
 *         try {
 *             InputStream assetInput = getAssets().open("data.xml");
 *             List<Message> messages = PullParser.pull2xml(assetInput);
 *             for (Message message : messages) {
 *
 *             }
 *         } catch (Exception exception) {
 *             exception.printStackTrace();
 *         }
 *     }
 * </pre>
 * 2、所需UI资源已放在res/drawable-xxhdpi下面
 *
 * 3、作业中的会用到圆形的ImageView,可以参考 widget/CircleImageView.java
 */
public class Exercises3 extends AppCompatActivity implements GreenAdapter.ListItemClickListener{

    private RecyclerView mNumbersListView;
    private GreenAdapter mAdapter;
    private static  int NUM_LIST_ITEMS = 0;

    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> hashtag = new ArrayList<>();
    private ArrayList<String> time = new ArrayList<>();
    private ArrayList<String> icon = new ArrayList<>();
    private ArrayList<Boolean> isOfficial = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises3);
        mNumbersListView = findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNumbersListView.setLayoutManager(layoutManager);
        Log.d("zxr","EXERCISES3");
         try {
             Log.d("zxr","try begin");
             InputStream assetInput = getAssets().open("data.xml");
              List<Message> messages = PullParser.pull2xml(assetInput);
              for (Message message : messages){
                  Log.d("zxr","for_loop begin");
                  title.add(NUM_LIST_ITEMS,message.getTitle());
                  hashtag.add(NUM_LIST_ITEMS,message.getDescription());
                  time.add(NUM_LIST_ITEMS,message.getTime());
                  icon.add(NUM_LIST_ITEMS,message.getIcon());
                  isOfficial.add(NUM_LIST_ITEMS,message.isOfficial());
                  NUM_LIST_ITEMS++;
                  Log.d("zxr","我爬了，你呢");
                  Log.d("zxr",message.toString());
              }
         } catch (Exception exception) {
             exception.printStackTrace();
          }

         mAdapter = new GreenAdapter(NUM_LIST_ITEMS,this,title,hashtag,time,icon,isOfficial);
         mNumbersListView.setAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("ItemIndex",clickedItemIndex);
        Log.d("zxr-1","a"+String.valueOf(clickedItemIndex));
        startActivity(intent);
    }

}
