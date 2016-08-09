package co.sgupta.volley;

import android.app.Application;
import android.content.Context;

import java.security.PublicKey;

public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate(){
        super.onCreate();

        sInstance =this;
    }

    public static MyApplication getsInstance() {
        return sInstance;
    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
