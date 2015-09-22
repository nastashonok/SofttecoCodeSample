package com.softteco.codesample.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.softteco.codesample.R;
import com.softteco.codesample.fragments.FragmentAbstract;
import com.softteco.codesample.fragments.FragmentListener;

import java.util.List;

public class ActivityMain extends AppCompatActivity implements FragmentListener {

    private static final int OPERATION_REPLACE = 1;
    private static final int OPERATION_ADD = 2;
    private static final int OPERATION_REMOVE = 3;
    private static final int OPERATION_HIDE = 4;
    private static final int OPERATION_SHOW = 5;

    private boolean isDestroyed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
//            replaceFragment(FragmentUIBuilder.class.getName(), null, false);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void replaceFragment(String fragmentName, Bundle bundle, boolean addToBackStack) {
        performFragmentOperation(fragmentName, bundle, addToBackStack, OPERATION_REPLACE);
    }

    @Override
    public void addFragment(String fragmentName, Bundle bundle, boolean addToBackStack) {
        performFragmentOperation(fragmentName, bundle, addToBackStack, OPERATION_ADD);
    }

    @Override
    public void removeFragment(String fragmentName) {
        performFragmentOperation(fragmentName, null, false, OPERATION_REMOVE);
    }

    @Override
    public void showFragment(String fragmentName) {
        performFragmentOperation(fragmentName, null, false, OPERATION_SHOW);
    }

    @Override
    public void hideFragment(String fragmentName) {
        performFragmentOperation(fragmentName, null, false, OPERATION_HIDE);
    }

    private void performFragmentOperation(String fragmentName, Bundle bundle, boolean addToBackStack, int operationId) {
        if (!isDestroyed) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (addToBackStack) {
                ft.addToBackStack(fragmentName);
            }
            switch (operationId) {
                case OPERATION_REPLACE:
                    ft.replace(R.id.fragment_container, Fragment.instantiate(this, fragmentName, bundle), fragmentName);
                    break;
                case OPERATION_ADD:
                    ft.add(R.id.fragment_container, Fragment.instantiate(this, fragmentName, bundle), fragmentName);
                    break;
                case OPERATION_REMOVE:
                    Fragment fragmentToRemove = getSupportFragmentManager().findFragmentByTag(fragmentName);
                    ft.remove(fragmentToRemove);
                    break;
                case OPERATION_SHOW:
                    Fragment fragmentToShow = getSupportFragmentManager().findFragmentByTag(fragmentName);
                    ft.show(fragmentToShow);
                    break;
                case OPERATION_HIDE:
                    Fragment fragmentToHide = getSupportFragmentManager().findFragmentByTag(fragmentName);
                    ft.hide(fragmentToHide);
                    break;
            }
            ft.commitAllowingStateLoss();
        }
    }

    @Override
    protected void onDestroy() {
        isDestroyed = true;
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        FragmentAbstract currentFragment = getCurrentFragment();
        boolean isHandledByFragment;
        if (currentFragment != null) {
            isHandledByFragment = currentFragment.onBackPressed();
            if (isHandledByFragment) {
                return;
            }
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    private FragmentAbstract getCurrentFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return (FragmentAbstract) fragment;
        }
        return null;
    }

}
