import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.silentsoft.pushbullet.api.Push;
import org.silentsoft.pushbullet.api.PushbulletAPI;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;

public class Mensajes implements Runnable {

    public void run() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                //sendPushbullet("Advertencia", "Elliot estuvo cerca de Angela");
                sendToArduino("Elliot estuvo cerca de Angela");
            }
        });
    }

    private static void sendToArduino(String mensaje) {
        //Creando Trust Manager que no verifique certificados

        final TrustManager[] trustAllCerts = new TrustManager[]{

                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException;
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.0.17/data/?mensaje=" + mensaje)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendPushbullet(String titulo, String cuerpo) {
        try {
            String iden = PushbulletAPI.getDevices(Constantes.tokenPushbullet).get(0).getIden();
            //System.out.println(iden);
            Push push = PushbulletAPI.sendNote(Constantes.tokenPushbullet, PushbulletAPI.TargetType.device_iden, iden, titulo, cuerpo);
            //System.out.println(push.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
