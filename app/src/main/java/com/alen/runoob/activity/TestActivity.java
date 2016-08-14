package com.alen.runoob.activity;

import com.alen.runoob.R;
import com.alen.runoob.activity.base.BaseActivity;

import us.feras.mdv.MarkdownView;

public class TestActivity extends BaseActivity {

    private MarkdownView markdownView;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_test);
        markdownView = (MarkdownView) findViewById(R.id.markdownView);
    }

    @Override
    protected void loadServer() {
        markdownView.loadMarkdownFile("https://raw.githubusercontent.com/XiqingLiu/CollectSourceCode/master/ListView.md");
    }
}
