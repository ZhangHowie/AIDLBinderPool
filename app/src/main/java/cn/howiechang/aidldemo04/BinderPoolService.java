package cn.howiechang.aidldemo04;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import cn.howiechang.aidldemo04.impl.BinderPoolImpl;

/**
 * Created by Howie on 2017/8/29 10:35.
 * Binder连接池的Service
 */

public class BinderPoolService extends Service {


    private static final String TAG = "BinderPoolService0829";
    private Binder mBinderPool = new BinderPoolImpl();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind");
        return mBinderPool;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
