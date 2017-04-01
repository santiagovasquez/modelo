package info.androidhive.navigationdrawer;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import info.androidhive.navigationdrawer.EntityLocal.FormulasModel;


public class App extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Configuration configuration = new Configuration.Builder(this).addModelClass(FormulasModel.class).create();

        ActiveAndroid.initialize(configuration);

    }
}
