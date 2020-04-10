package com.example.clonemessenger.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonemessenger.Adapter.BoardAdapter;
import com.example.clonemessenger.Model.BoardItem;
import com.example.clonemessenger.Model.Friend;
import com.example.clonemessenger.Model.User;
import com.example.clonemessenger.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FragmentBoard extends Fragment {
    public FragmentBoard()
    {
    }
    Context mContext;
    RecyclerView rv_board;
    List<BoardItem> list = new ArrayList<>();
    BoardAdapter adapter;
    int positionOfRes = 0;
    List<Integer> listsOfImage = new ArrayList<>(
            Arrays.asList(R.drawable.umbrella,
                    R.drawable.ninja,
                    R.drawable.blossom,
                    R.drawable.butterfly,
                    R.drawable.rainbow,
                    R.drawable.spring,
                    R.drawable.water,
                    R.drawable.wink,
                    R.drawable.mermaid,
                    R.drawable.bee,
                    R.drawable.clothes,
                    R.drawable.clothestwo,
                    R.drawable.houses,
                    R.drawable.illustration,
                    R.drawable.illustrationtwo,
                    R.drawable.paint,
                    R.drawable.paint2)
    );
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = container.getContext();
        View v = inflater.inflate(R.layout.board_fragment, container, false);
        // init fragment
        initBoardItem(list);
        adapter = new BoardAdapter(mContext, list);
        rv_board = v.findViewById(R.id.rv_board);
        rv_board.setAdapter(adapter);
        rv_board.setLayoutManager(new GridLayoutManager(mContext, 2));
        return v;
    }

    private void initBoardItem(List<BoardItem> list)
    {
        Friend friend = new Friend();
        for (int i = 0; i < friend.getUserList().size(); i++)
        {
            int img_res = initRandomBackgroundImage();
            list.add(new BoardItem(friend.getUser(i), initRandomBackgroundImage()));
        }
    }

    private int initRandomBackgroundImage()
    {
        if (positionOfRes >= listsOfImage.size())
        {
            positionOfRes = 0;
        }
        int position = positionOfRes;
        positionOfRes++;
        return listsOfImage.get(position);
    }
}
