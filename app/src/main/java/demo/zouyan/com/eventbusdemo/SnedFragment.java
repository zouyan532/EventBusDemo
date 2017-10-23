package demo.zouyan.com.eventbusdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class SnedFragment extends Fragment {

    public SnedFragment() {
        // Required empty public constructor
    }

    private int count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sned, container, false);
        view.findViewById(R.id.btn_send_lv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                EventBus.getDefault().post(new MessageEvent(getString(R.string.text_msg_content,count)));

            }
        });
        view.findViewById(R.id.btn_send_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ToastEvent(getString(R.string.text_msg_content,count)));
            }
        });

        view.findViewById(R.id.btn_send_sticky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new StickyMessgae(getString(R.string.text_msg_content,count)));
            }
        });
        view.findViewById(R.id.btn_start_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SecondActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
