package com.example.rony.v2;

import android.app.Fragment;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rony on 5/1/2018.
 */

public class MainFragment extends Fragment {

    private Button mSend;
    private ListView mList;
    public ArrayList<Pair<String, String>> mMessagesData;
    public ArrayList<String> mMessages;
    public ArrayAdapter<String> mMessagesAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mMessagesData = new ArrayList<Pair<String, String>>();
        mSend = view.findViewById(R.id.sendMessage);
        mList = view.findViewById(R.id.messagesList);
        mMessages = new ArrayList<>();
        mMessagesAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mMessages);
        mList.setAdapter(mMessagesAdapter);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog dialog = new CustomDialog();
                dialog.show(getFragmentManager(), "CustomDialog");
            }
        });

        mList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String userData = mMessagesData.get(i).first;
                String dateData = mMessagesData.get(i).second;
                DataDialogFragment dialog = new DataDialogFragment();
                dialog.setData(userData, dateData, i);
                dialog.show(getFragmentManager(), "CurrentDialog");
                return false;
            }
        });
        return view;
    }

    public void addTextView(final String userNameInput, final String messageInput, final String sentAt) {
        Pair<String, String> currData = new Pair<>(userNameInput, sentAt);
        mMessagesData.add(currData);
        mMessages.add(messageInput);
        mMessagesAdapter.notifyDataSetChanged();
    }


}
