package com.example.clonemessenger.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonemessenger.Adapter.ActiveAdapter;
import com.example.clonemessenger.Model.Friend;
import com.example.clonemessenger.Model.User;
import com.example.clonemessenger.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentActive extends Fragment {
    public FragmentActive()
    {

    }
    Context mContext;
    RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = container.getContext();
        View v = inflater.inflate(R.layout.active_fragment, container, false);
        rv = (RecyclerView) v.findViewById(R.id.rv_active);
        Friend friend = new Friend();
        List<User> list = friend.getUserList();
        ActiveAdapter adapter = new ActiveAdapter(mContext, list);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
}
