package ru.bratusevd.basketfeature;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import ru.bratusevd.basketfeature.ui.home.HomeFragment;
import ru.bratusevd.basketfeature.ui.profile.ProfileFragment;
import ru.bratusevd.basketfeature.ui.teams.TeamsFragment;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private TeamsFragment teamsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        teamsFragment = new TeamsFragment();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openFragment(homeFragment);
                        return true;
                    case R.id.navigation_profile:
                        openFragment(profileFragment);
                        return true;
                    case R.id.navigation_teams:
                        openFragment(teamsFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}