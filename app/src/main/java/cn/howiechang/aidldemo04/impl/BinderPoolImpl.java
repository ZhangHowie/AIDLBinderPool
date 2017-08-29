package cn.howiechang.aidldemo04.impl;

import android.os.IBinder;
import android.os.RemoteException;

import cn.howiechang.aidldemo04.IBinderPool;

/**
 * Created by Howie on 2017/8/29 15:14.
 * Binder实现类
 */

public class BinderPoolImpl extends IBinderPool.Stub {

    public static final int BINDER_SECURITY_CENTER = 0;
    public static final int COMPUTE = 1;


    public BinderPoolImpl() {
        super();
    }

    @Override
    public IBinder queryBinder(int binderCode) throws RemoteException {
        IBinder iBinder = null;
        switch (binderCode) {
            case BINDER_SECURITY_CENTER:
                iBinder = new SecurityCenterImpl();
                break;
            case COMPUTE:
                iBinder = new ComputeImpl();
                break;
            default:
                break;
        }

        return iBinder;
    }
}
