package cz.codecamp.mvp;

import android.app.Application;

import com.facebook.stetho.Stetho;

import cz.codecamp.mvp.di.AppComponent;
import cz.codecamp.mvp.di.AppModule;
import cz.codecamp.mvp.di.DaggerAppComponent;

/**
 * Application class for app
 *
 * @author Michal Kučera [michal.kucera@ackee.cz]
 * @since {05/05/16}
 **/
public class App extends Application {
    public static final String TAG = App.class.getName();


    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
