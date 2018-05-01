package com.example.rony.v2;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Rony on 5/1/2018.
 */

public class DataDialogFragment extends DialogFragment {

    private String mUser, mDate;
    private int mMessageNumber;

    public void setData(String user, String date, int i) {
        mUser = user;
        mDate = date;
        mMessageNumber = i;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data_dialog, container, false);

        TextView userTV = view.findViewById(R.id.usernameView);
        userTV.setText(mUser);
        TextView timeView = view.findViewById(R.id.timeView);
        timeView.setText(mDate);
        Button deleteButton = view.findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainFragment fragment = (MainFragment) getActivity().getFragmentManager().findFragmentByTag("MainFragment");
                fragment.mMessagesData.remove(mMessageNumber);
                fragment.mMessages.remove(mMessageNumber);
                fragment.mMessagesAdapter.notifyDataSetChanged();
                getDialog().dismiss();
            }
        });
        return view;
    }
}
