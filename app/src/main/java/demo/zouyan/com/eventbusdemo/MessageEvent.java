package demo.zouyan.com.eventbusdemo;

/**
 * Created by Boosal on 2017/10/23.
 */

public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
