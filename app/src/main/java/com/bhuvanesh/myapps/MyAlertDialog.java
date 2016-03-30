package com.bhuvanesh.myapps;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAlertDialog extends DialogFragment {


    Communicator communicator;
    AlertDialog.Builder builder;
    ArrayList<Integer> selectedIems;
    //int id;

    public MyAlertDialog () {}

    /*public MyAlertDialog(int id) {
        // Required empty public constructor
        this.id = id;
    }*/

    public static MyAlertDialog newInstance(int someInt) {
        MyAlertDialog dialog = new MyAlertDialog();

        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        dialog.setArguments(args);

        return dialog;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
        selectedIems = new ArrayList();
         switch (getArguments().getInt("someInt", 0)) {
             case 1:  return complexityDialog();
             case 2:  return algorithmDialog();
             default: return null;
         }
    }


    public Dialog complexityDialog() {

        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Complexity");

        builder.setSingleChoiceItems(R.array.complexity, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //communicator.chooseComplexity(which);
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                communicator.generateArray(which);
            }
        });
        return builder.create();
    }



    public Dialog algorithmDialog() {
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Algorithm");

        builder.setMultiChoiceItems(R.array.algorithms, null, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                selectedIems.add(which);
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                communicator.benchMark(selectedIems);
                dialog.dismiss();
            }
        });

        return builder.create();
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_alert_dialog, container, false);
    }*/

}
