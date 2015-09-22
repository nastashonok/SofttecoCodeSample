package com.softteco.codesample.fragments;

import android.os.Bundle;

public interface FragmentListener {
	
	void replaceFragment(String fragmentName, Bundle bundle, boolean addToBackStack);

	void addFragment(String fragmentName, Bundle bundle, boolean addToBackStack);

	void removeFragment(String fragmentName);

	void showFragment(String fragmentName);

	void hideFragment(String fragmentName);
}
