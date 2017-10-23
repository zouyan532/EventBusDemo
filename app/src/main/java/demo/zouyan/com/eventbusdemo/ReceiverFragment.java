package demo.zouyan.com.eventbusdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiverFragment extends Fragment {
    private ListView lv_receiver;
    private List<String> list;
    private ArrayAdapter adapter;
    public ReceiverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);
        lv_receiver = view.findViewById(R.id.lv_receiver);
        list = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list);
        lv_receiver.setAdapter(adapter);
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe
    public void getMessage(MessageEvent event){
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }

    @Subscribe(priority = 1)
    public void getMessage_1(MessageEvent event){
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }

    @Subscribe(priority = 2)
    public void getMessage_2(MessageEvent event){
        EventBus.getDefault().cancelEventDelivery(event);
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }
    @Subscribe(priority = 3)
    public void getMessage_3(MessageEvent event){
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }



    @Subscribe
    public void getMessage2(ToastEvent event){
        Toast.makeText(getActivity(), event.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
