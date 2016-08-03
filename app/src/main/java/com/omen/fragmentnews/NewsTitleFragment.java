package com.omen.fragmentnews;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter newsAdapter;
    public static final String TAG="MyNews";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newsList = getNews();
        newsAdapter = new NewsAdapter(context, R.layout.news_item, newsList);

    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setmTitle("7.0正式版要来了！Android 6.0份额继续爆发");
        news1.setmContent("现在，谷歌最新发布的Andriod系统版本构成显示，6.0的市场占有率已经从之前的13.2%，" +
                "突破至15.2%，而达到这个成绩，6.0差不多经过十个月左右。");
        newsList.add(news1);
        News news2 = new News();
        news2.setmTitle("外媒称Android 7.0当中加入了指纹手势");
        news2.setmContent("近日有外媒传出消息称今年的Nexus手机将会搭载Android 7.0系统，而系统中还新增加" +
                "指纹手势功能，同时谷歌将对以前的虚拟按键进行了重绘。根据外媒给出的消息，今年的谷歌两款" +
                "Nexus系列手机将会由HTC来代工生产，而这两款手机的型号分别为Marlin（M1）和Salifish（S1），" +
                "同时这两款设备将会延续谷歌以往的做法，将指纹识别模块放在手机背部。");
        newsList.add(news2);
        return newsList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_title, container, false);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(newsAdapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        News news = newsList.get(i);
        Log.d(TAG, "onItemClick: "+i);
        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().
                findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(news.getmTitle(), news.getmContent());
    }
}
