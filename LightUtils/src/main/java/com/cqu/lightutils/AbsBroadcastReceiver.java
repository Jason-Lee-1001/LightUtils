package com.cqu.lightutils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.lang.ref.SoftReference;

/**
 * Created by A Shuai on 2015/4/29.
 * ������ΪActivity���ڲ��࣬����Ϊ��̬�ڲ��ࡣ������Ǿ�̬�ڲ�����ǵ�ȡ���㲥ע����
 */
public abstract class AbsBroadcastReceiver<T extends Activity> extends BroadcastReceiver {

    private final SoftReference<T> mActivityRef;

    public AbsBroadcastReceiver(T mActivity) {
        super();
        mActivityRef = new SoftReference<T>(mActivity);
    }

    /**
     * ���಻�ɸ�д�������
     *
     * @param context
     * @param intent
     */
    @Override
    public final void onReceive(Context context, Intent intent) {
        T mActivity = mActivityRef.get();
        if (mActivity == null)
            return;
        onReceive(mActivity, intent, intent.getExtras());
    }

    /**
     * �����踲д��������Թ㲥���д���
     *
     * @param mActivity
     * @param intent
     * @param mBundle   ��Ϊnull
     */
    public abstract void onReceive(T mActivity, Intent intent, Bundle mBundle);

}
