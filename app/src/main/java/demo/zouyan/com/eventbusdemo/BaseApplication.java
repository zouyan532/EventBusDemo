package demo.zouyan.com.eventbusdemo;

import android.app.Application;

import com.bandeng.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Boosal on 2017/10/23.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
