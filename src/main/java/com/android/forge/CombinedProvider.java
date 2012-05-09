package com.android.forge;

import java.util.ArrayList;

public interface CombinedProvider extends Provider {
	
	ArrayList<Provider> containedItems = new ArrayList<Provider>();
}
