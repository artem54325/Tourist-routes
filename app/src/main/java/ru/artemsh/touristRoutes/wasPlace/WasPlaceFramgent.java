package ru.artemsh.touristRoutes.wasPlace;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.artemsh.touristRoutes.R;
import ru.artemsh.touristRoutes.adapter.PlaceAdapter;
import ru.artemsh.touristRoutes.adapter.ShowplaceAdapter;
import ru.artemsh.touristRoutes.database.IDatabase;

public class WasPlaceFramgent extends Fragment {
    private IDatabase database;
    private RecyclerView recycler = null;
    private ShowplaceAdapter adapter = null;
    private View view = null;

    public WasPlaceFramgent(IDatabase database) {
        this.database = database;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_showplaces, null);
        recycler = view.findViewById(R.id.recycler);
        adapter = new ShowplaceAdapter(getActivity(), database);
        recycler.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(mLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}