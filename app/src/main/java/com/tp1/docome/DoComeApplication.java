package com.tp1.docome;


    import android.app.Activity;
    import android.app.Application;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.preference.PreferenceManager;


    public class DoComeApplication extends Application implements Application.ActivityLifecycleCallbacks {

        @Override
        public void onCreate() {
            super.onCreate();

            registerActivityLifecycleCallbacks(this);

        }

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (activity instanceof RegisterActivity) //si activity est de même type que RegisterActivity
            {}
            else {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this); // on va comparer la mémoire d'une variable locale du téléphone à une mémoire de l'applacation
                String username = pref.getString("username",null); // on prend la valeur string de username dans la variable username
                if (username == null) // si il n'y a rien dans username alors on renvoi a register
                {
                    Intent Intent = new Intent (this,RegisterActivity.class);
                    startActivity(Intent);
                }
                else {
                    Intent Intent = new Intent (this,MainActivity.class);
                    startActivity(Intent);
                }
            }
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }

