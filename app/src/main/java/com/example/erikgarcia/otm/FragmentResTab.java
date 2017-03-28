package com.example.erikgarcia.otm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Maverick on 3/26/2017.
 */

public class FragmentResTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_menu_tab, container, false);
        TextView title = (TextView)v.findViewById(R.id.tabTitle);

        LinearLayout newGroup = (LinearLayout)v.findViewById(R.id.newGroupOnClick);
        newGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newGroup(v);

            }
        });

        switch (this.getTag()){
            case "Appetizers":
                title.setText(this.getTag());
                break;
            case "Etrees":
                title.setText(this.getTag());

                break;
            case "Desserts":
                title.setText(this.getTag());

                break;
            case "Beverages":
                title.setText(this.getTag());

                break;
            case "Kids":
                title.setText(this.getTag());

                break;
            case "Specials":
                title.setText(this.getTag());

        }

        return v;
    }

    public void newGroup(View v){

        //Layout Inflater
        final LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        //Food Group Layout
        final LinearLayout ll = (LinearLayout)v.findViewById(R.id.tabFoodGroupFrame);
        final View groupLayout = layoutInflater.inflate(R.layout.new_food_group_layout, null);
        LinearLayout newItemOnClick = (LinearLayout)groupLayout.findViewById(R.id.newItemOnClick);
        ImageView minusGroupButton = (ImageView)groupLayout.findViewById(R.id.foodGroupMinusButton);
        /*  Use groupLayout.findViewById to set up the rest of the Fields  */
        //Making sure New Item Button reads New Food Type
        TextView newItemButton = (TextView)groupLayout.findViewById(R.id.newItemTextView);
        String str = this.getTag();
        if(!str.equals("Kids")) {
            str = str.substring(0, str.length() - 1);
        }
        newItemButton.setText("New "+str);

        //Adding the Food Group View
        ll.addView(groupLayout);

        //Removing the Food Group View
        minusGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll.removeView(groupLayout);
            }
        });

        //Adding the Item View
        newItemOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //New Item Layout
                final LinearLayout itemll = (LinearLayout)groupLayout.findViewById(R.id.tabItemFrame);
                final View itemLayout = layoutInflater.inflate(R.layout.new_item_layout, null);
                ImageView minusItemButton = (ImageView)itemLayout.findViewById(R.id.newItemMinus);
                /*   Use itemLayout.findViewById to set up the rest of the Fields   */

                itemll.addView(itemLayout);

                //Removing the Item View
                minusItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemll.removeView(itemLayout);
                    }
                });
            }
        });
    }

    public void cancel(View v){
        //Delete auto save data

        getActivity().finish();
    }
}
