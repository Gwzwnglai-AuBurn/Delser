package com.gg.delser;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainUi extends AppCompatActivity{

    BottomNavigationView navigation;
    FrameLayout frameLayout;

    HomeFragment homeFragment;
    FavesFragment favesFragment;
    accountFragment accountFragment;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);

        navigation = findViewById(R.id.nav_view);
        frameLayout = findViewById(R.id.nav_host_fragment);

        homeFragment = new HomeFragment();
        favesFragment = new FavesFragment();
        accountFragment = new accountFragment();

        loadFragment(homeFragment);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        loadFragment(homeFragment);
                        break;

                    case R.id.navigation_recent:
                        loadFragment(favesFragment);
                        break;

                    case R.id.navigation_account:
                        loadFragment(accountFragment);
                        break;
                }
                return true;
            }
        });
    }


    private boolean loadFragment(Fragment fragment){

        if (fragment!= null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }


//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        Fragment fragment = null;
//
//        switch (menuItem.getItemId()){
//            case R.id.navigation_home:
//                fragment = new HomeFragment();
//                break;
//
//            case R.id.navigation_recent:
//                fragment = new FavesFragment();
//                break;
//
//            case R.id.navigation_account:
//                fragment = new accountFragment();
//                break;
//        }
//
//        return loadFragment(fragment);
//    }



    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_ui);
//
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//        .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
//    }

}
