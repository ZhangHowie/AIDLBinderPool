package cn.howiechang.aidldemo04.impl;

import android.os.RemoteException;

import cn.howiechang.aidldemo04.ICompute;

/**
 * Created by Howie on 2017/8/29 10:17.
 * ComputeImpl实现类
 */

public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
