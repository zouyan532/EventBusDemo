package demo.zouyan.com.eventbusdemo;

/**
 * Created by Boosal on 2017/10/23.
 */

public class ToastEvent {
    private String msg;

    public ToastEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
