package cn.howiechang.clientapp;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewConfiguration;

import cn.howiechang.aidldemo04.ICompute;
import cn.howiechang.aidldemo04.ISecurityCenter;

public class MainActivity extends AppCompatActivity {

    private ISecurityCenter mISecurityCenter = null;
    private ICompute mICompute = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }).start();

        ViewConfiguration.get(this).getScaledTouchSlop();
    }


    private void doWork() {
        BinderPool binderPool = BinderPool.getInstance(MainActivity.this);
        IBinder securityBinder = binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
        mISecurityCenter = ISecurityCenter.Stub.asInterface(securityBinder);

        Log.d("MainActivity0829-Client", "Visit ISecurityCenter");

        String msg = "helloWorld--Android";
        Log.d("MainActivity0829-Client", "content: " + msg);

        try {
            String password = mISecurityCenter.encrypt(msg);
            Log.d("MainActivity0829-Client", "encrypt: " + password);
            Log.d("MainActivity0829-Client", "decrypt: " + mISecurityCenter.decrypt(password));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Log.d("MainActivity0829-Client", "Visit ICompute");

        IBinder computeBinder = binderPool.queryBinder(BinderPool.COMPUTE);
        mICompute = ICompute.Stub.asInterface(computeBinder);

        try {
            Log.d("MainActivity0829-Client", "3 + 5 = " + mICompute.add(3, 5));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
