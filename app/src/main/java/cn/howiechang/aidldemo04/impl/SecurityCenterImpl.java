package cn.howiechang.aidldemo04.impl;

import android.os.RemoteException;

import cn.howiechang.aidldemo04.ISecurityCenter;

/**
 * Created by Howie on 2017/8/29 10:03.
 * AIDL的实现
 */

public class SecurityCenterImpl extends ISecurityCenter.Stub {

    public static final int BINDER_SECURITY_CENTER = 0;
    public static final int COMPUTE = 1;

    private static final char SECRET_CODE = '^';

    @Override
    public String encrypt(String content) throws RemoteException {
        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= SECRET_CODE;

        }
        return new String(chars);
    }

    @Override
    public String decrypt(String password) throws RemoteException {
        return encrypt(password);
    }

}


