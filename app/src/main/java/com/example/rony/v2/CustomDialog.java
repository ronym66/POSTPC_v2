package com.example.rony.v2;

import android.app.DialogFragment;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Rony on 5/1/2018.
 */

public class CustomDialog extends DialogFragment {

    private EditText mMessage, mUsername;
    private Button mSend, mCancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_custom, container, false);
        mMessage = view.findViewById(R.id.messageInput);
        mUsername = view.findViewById(R.id.usernameInput);
        mSend = view.findViewById(R.id.sendButton);
        mCancel = view.findViewById(R.id.cancelButton);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageInput = mMessage.getText().toString();
                final String userNameInput = mUsername.getText().toString();
                if (!messageInput.equals("") && !userNameInput.equals("")) {
                    final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

                    MainFragment fragment = (MainFragment) getActivity().getFragmentManager().findFragmentByTag("MainFragment");
                    fragment.addTextView(userNameInput, messageInput, currentDateTimeString);
                }
                getDialog().dismiss();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        return view;
    }
}
