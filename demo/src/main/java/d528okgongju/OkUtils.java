package d528okgongju;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkUtils {

    OkHttpClient okHttpClient;

    private OkUtils(){
        Log.d("ytx","创建一次");

        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static OkUtils okUtils = new OkUtils();

    public static OkUtils newInstance(){
        return okUtils;
    }

    public void doGet(String url, final MyCallBack myCallBack){
        Request builder = new Request.Builder().get().url(url).build();

        Call call = okHttpClient.newCall(builder);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myCallBack.error(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myCallBack.success(response.body().string());
            }
        });
    }

    public void doPost(String url, final MyCallBack myCallBack, String[] keyname, String[] valuse){
        //page=1
        FormBody.Builder builder = new FormBody.Builder();
        for (int i = 0 ;i<keyname.length ; i++){
           builder.add(keyname[i], valuse[i]);
        }
        FormBody build = builder.build();
        Request build1 = new Request.Builder().post(build).url(url).build();

        Call call = okHttpClient.newCall(build1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                myCallBack.error(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myCallBack.success(response.body().string());
            }
        });
    }

//    public void dosd(String filepath,String ){
//
//    }

    interface MyCallBack{
        void error(String s);
        void success(String s);
    }

}
