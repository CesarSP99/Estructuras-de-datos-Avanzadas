import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.silentsoft.pushbullet.api.Push;
import org.silentsoft.pushbullet.api.PushbulletAPI;

import java.io.IOException;

public class Main {
    public static String token = "o.hbKF6KLr5rYxpQ8VmXmTGM7U60LQS8Iq";
    public static void main(String[] args) {
        Mensajes ms = new Mensajes();
        Thread thread = new Thread(ms);
        thread.run();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
