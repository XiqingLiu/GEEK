package com.alenbeyond.runoob.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.MainActivity;
import com.alenbeyond.runoob.adapter.VPCategoryAdapter;
import com.alenbeyond.runoob.fragment.base.BaseFragment;
import com.alenbeyond.runoob.greendao.bean.RunoobCategory;
import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.greendao.gen.RunoobCategoryDao;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Alen on 2016/8/16.
 */
public class RunoobFragment extends BaseFragment {

    @BindView(R.id.vp_category)
    ViewPager mVpCategory;

    @Override
    protected View setContentView() {
        return View.inflate(getContext(), R.layout.fragment_runoob, null);
    }

    @Override
    protected void loadData() {
        DaoSession daoSession = App.daoMaster.newSession();
        RunoobCategoryDao categoryDao = daoSession.getRunoobCategoryDao();
        List<RunoobCategory> categories = categoryDao.queryBuilder().list();
        mVpCategory.setAdapter(new VPCategoryAdapter(getActivity(), categories));
       setupTabs();
    }

    public void setupTabs() {
        MainActivity m = (MainActivity) getActivity();
        m.mTabs.removeAllTabs();
        m.mTabs.setupWithViewPager(mVpCategory);
    }

}
