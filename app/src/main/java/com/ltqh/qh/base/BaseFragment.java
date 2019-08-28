package com.ltqh.qh.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltqh.qh.entity.LoginEntity;
import com.ltqh.qh.operation.entity.OMineEntity;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 10998 on 2017/5/21 /13:32
 * com.ddzl.lottery251.base
 */

public abstract class BaseFragment extends Fragment {
    private FragmentManager fragmentManager;
    private Fragment showFragment;
    public View mView;
    private ProgressDialog mProgressDialog;
    public Bundle mSavedBundle;
    private Unbinder unbinder;

    private View mContentView;
    private Timer mTimer;








    protected void startScheduleJob(final Handler handler, long delay, long interval) {
        if (mTimer != null) cancelTimer();

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (handler != null) {
                    handler.sendEmptyMessage(0);
                }
            }
        }, delay, interval);
    }

    protected void startScheduleJob(final Handler handler, long delay, long interval,int what) {
        if (mTimer != null) cancelTimer();

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (handler != null) {
                    handler.sendEmptyMessage(what);
                }
            }
        }, delay, interval);
    }

    protected void cancelTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        intPresenter();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(setLayoutResourceID(), container, false);
        unbinder = ButterKnife.bind(this, mContentView);
        mProgressDialog = new ProgressDialog(getActivity());
        fragmentManager = getChildFragmentManager();
        initView(mContentView);
        initData();

        return mContentView;

    }

    protected abstract void initView(View view);

    protected abstract int setLayoutResourceID();

    public View getmContentView() {
        return mContentView;
    }

    protected boolean isLogin() {
        return LoginEntity.getInstance().isLogin();
    }

    protected boolean isMineLogin() {
        return OMineEntity.getInstance().isMineLogin();
    }


    public void showToast(String msg) {
//        Looper.prepare();
//        Looper mlooper=Looper.myLooper();
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
//        mlooper.quit();
//        Looper.loop();
    }


    protected abstract void intPresenter();


    protected abstract void initData();


    public void showProgressDialog() {
        if (mProgressDialog != null)
            mProgressDialog.show();
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null)
            mProgressDialog.dismiss();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }

    /**
     * 展示Fragment
     */
    protected void showFragment(int resid, BaseFragment fragment, String key, Object object) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //隐藏正在暂时的Fragment
        if (showFragment != null) {
            fragmentTransaction.hide(showFragment);
        }

        //展示需要显示的Fragment对象
        Fragment mFragment = fragmentManager.findFragmentByTag(fragment.getClass().getName());
        if (mFragment != null) {
            fragmentTransaction.show(mFragment);
            showFragment = (BaseFragment) mFragment;
        } else {
            fragmentTransaction.add(resid, fragment, fragment.getClass().getName());
            showFragment = fragment;
        }

        Bundle bundle = new Bundle();
        // bundle.putString(key,value);
        bundle.putSerializable(key, (Serializable) object);
        fragment.setArguments(bundle);
        fragmentTransaction.commit();

    }


}
