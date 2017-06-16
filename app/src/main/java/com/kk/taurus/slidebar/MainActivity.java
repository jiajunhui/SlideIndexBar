package com.kk.taurus.slidebar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kk.taurus.slidebar.adapter.ListAdapter;
import com.kk.taurus.slidebar.widget.SlideIndexBar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private SlideIndexBar mSlideBar;

    private TextView mSelect;

    private String[] mIndexGroup = {"↑","A","B","C","D","E","F","G","H","I","J","K","L","M"
            ,"N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#"};
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mSlideBar = (SlideIndexBar) findViewById(R.id.slide_bar);
        mSelect = (TextView) findViewById(R.id.tv_select);

        mRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mSlideBar.setIndexGroupElements(mIndexGroup);

        mSlideBar.setTextColor(Color.BLUE,Color.YELLOW);

        mSlideBar.setColor(Color.parseColor("#22000000"),Color.parseColor("#77000000"));

        mList = DataUtils.randomData(40);

        ListAdapter adapter = new ListAdapter(this, mList);

        mRecycler.setAdapter(adapter);

        mSlideBar.setOnSlideListener(new SlideIndexBar.OnSlideListener() {
            @Override
            public void onStartSlide() {
                mSelect.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSelect(String select) {
                mSelect.setText(select);
                if(select.equals("↑")){
                    scrollToPosition(0);
                }else{
                    locationPosition(select);
                }
            }

            @Override
            public void onEndSlide() {
                mSelect.setVisibility(View.GONE);

            }
        });

    }

    private void locationPosition(String select) {
        int len = mList.size();
        int index = -1;
        for(int i=0;i<len;i++){
            if(select.equalsIgnoreCase(String.valueOf(mList.get(i).charAt(0)))){
                index = i;
                break;
            }
        }
        if(index >= 0){
            scrollToPosition(index);
        }
    }

    private void scrollToPosition(int position){
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecycler.getLayoutManager();
        layoutManager.scrollToPosition(position);
    }
}
