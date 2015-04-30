package com.cqu.lightutils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by A Shuai on 2015/4/29.
 * ���������ΪActivity���ڲ��࣬����ʹ�þ�̬�ڲ��࣬
 * ��дonMessageExecute�������д�����Ϣ����
 */
public abstract class AbsHandler<T extends Activity> extends Handler {

    private final WeakReference<T> mActivityRef;

    public AbsHandler(T mActivity) {
        mActivityRef = new WeakReference<T>(mActivity);
    }

    @Override
    public final void handleMessage(Message msg) {
        T mActivity = mActivityRef.get();
        if (mActivity == null) {
            return;
        }
        handleMessage(mActivity, msg, msg.getData());
    }

    /**
     * ��Ҫ����Ϣ�����߼�
     *
     * @param mActivity
     * @param msg
     * @param mBundle   ����Ϊnull
     */
    protected abstract void handleMessage(T mActivity, Message msg, Bundle mBundle);


}
