package com.example.erikgarcia.otm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Maverick on 3/26/2017.
 */

public class FragmentResMenu extends Fragment {
    private FragmentTabHost mTabHost;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_new_res_menu, container, false);

        mTabHost = (FragmentTabHost)view.findViewById(R.id.resMenuTabHost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        String[] tabs = getResources().getStringArray(R.array.tab_tags);

        for(int i=0; i<tabs.length; i++){
            mTabHost.addTab(
                    mTabHost.newTabSpec(tabs[i]).setIndicator(tabs[i], null),
                    FragmentResTab.class, null);
        }

        return view;
    }
}
