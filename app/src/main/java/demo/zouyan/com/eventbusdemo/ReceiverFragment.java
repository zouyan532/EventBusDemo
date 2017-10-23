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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);
        lv_receiver = view.findViewById(R.id.lv_receiver);
        list = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
        lv_receiver.setAdapter(adapter);
        //注册EventBus
        EventBus.getDefault().register(this);
        return view;
    }
    //订阅信息，post过来的信息将在这里被接收
    @Subscribe
    public void getMessage(MessageEvent event) {
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onStop() {
        super.onStop();
        //取消注册EventBus
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(priority = 1)
    public void getMessage_1(MessageEvent event) {
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }

    @Subscribe(priority = 2)
    public void getMessage_2(MessageEvent event) {
        EventBus.getDefault().cancelEventDelivery(event);
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }

    @Subscribe(priority = 3)
    public void getMessage_3(MessageEvent event) {
        list.add(event.getMessage());
        adapter.notifyDataSetChanged();
    }

    @Subscribe
    public void getMessage2(ToastEvent event) {
        Toast.makeText(getActivity(), event.getMsg(), Toast.LENGTH_SHORT).show();
    }
}