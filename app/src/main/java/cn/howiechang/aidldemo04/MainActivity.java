package cn.howiechang.aidldemo04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
//                doWork();
            }
        }).start();
    }

//    private void doWork() {
//        BinderPool binderPool = BinderPool.getInstance(MainActivity.this);
//        IBinder securityBinder = binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
//        mISecurityCenter = SecurityCenterImpl.asInterface(securityBinder);
//
//        Log.d("MainActivity0829", "Visit ISecurityCenter");
//
//        String msg = "helloWorld--Android";
//        Log.d("MainActivity0829", "content: " + msg);
//
//        try {
//            String password = mISecurityCenter.encrypt(msg);
//            Log.d("MainActivity0829", "encrypt: " + password);
//            Log.d("MainActivity0829", "decrypt: " + mISecurityCenter.decrypt(password));
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//
//        Log.d("MainActivity0829", "Visit ICompute");
//
//        IBinder computeBinder = binderPool.queryBinder(BinderPool.COMPUTE);
//        mICompute = ComputeImpl.asInterface(computeBinder);
//
//        try {
//            Log.d("MainActivity0829", "3 + 5 = " + mICompute.add(3, 5));
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }
}
