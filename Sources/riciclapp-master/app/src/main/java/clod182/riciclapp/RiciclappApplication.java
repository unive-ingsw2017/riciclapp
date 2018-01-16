package clod182.riciclapp;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;


public class RiciclappApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
