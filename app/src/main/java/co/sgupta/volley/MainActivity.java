package co.sgupta.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private JSONObject mString;
    private VolleySingleton mVolleySingleton;
    private RequestQueue mRequestQueue;
    //private final static String mUrl = "https://api.forecast.io/forecast/8b04c37e3f08583bd73945a12d076988/37.8267,-122.423";
    //private final static String sUrl = "http://delhimaker.space/index.php?route=api/order/single";
    //private final static String sUrl = "http://delhimaker.space/index.php?route=api/order/categories";
    private final static String sUrl = "http://delhimaker.space/index.php?route=api/order/getProductsByCategory";
    private JSONObject mJSONObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        try {
            mJSONObject = new JSONObject("{\"id\":\"258\"}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //without using singleton class

        /*RequestQueue requestQueue  = VolleySingleton.getInstance().getRequestQueue();

        StringRequest request  =new StringRequest(Request.Method.GET, "https://api.forecast.io/forecast/8b04c37e3f08583bd73945a12d076988/37.8267,-122.423", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("DATA :",response);
                try {
                    mString = new JSONObject(response);
                    mTextView.setText(mString.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("ERROR : ",error.toString());
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);*/

        //using singleton class

        /*mVolleySingleton = VolleySingleton.getInstance();
        mRequestQueue = mVolleySingleton.getRequestQueue();

        StringRequest request  =new StringRequest(Request.Method.GET, sUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("DATA :",response);
                try {
                    mString = new JSONObject(response);
                    mTextView.setText(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                mTextView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("ERROR : ",error.toString());
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(request);*/


       //using singleton class accepting json object

        /*mVolleySingleton = VolleySingleton.getInstance();
        mRequestQueue = mVolleySingleton.getRequestQueue();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                sUrl,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mTextView.setText(response.toString());
                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("ERROR VOLLEY TEST: ",error.toString());
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(request);*/

        //post request without using singleton class

        /*StringRequest stringRequest = new StringRequest(Request.Method.POST, sUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                        mTextView.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                        Log.d("ERROR : ",error.toString());
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("id","258");
                //params.put(KEY_PASSWORD,password);
                //params.put(KEY_EMAIL, email);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);*/

        //post request using singleton class

       mVolleySingleton = VolleySingleton.getInstance();
        mRequestQueue = mVolleySingleton.getRequestQueue();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, sUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                        mTextView.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                        Log.d("ERROR : ",error.toString());
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("category_id","63");
                //params.put(KEY_PASSWORD,password);
                //params.put(KEY_EMAIL, email);
                return params;
            }

        };
        mRequestQueue.add(stringRequest);

        //JSONObjectRequest using post request using singleton class

        /*mVolleySingleton = VolleySingleton.getInstance();
        mRequestQueue = mVolleySingleton.getRequestQueue();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST, sUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                        mTextView.setText(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                        Log.d("ERROR : ",error.toString());
                    }
                })
        {
            @Override
            protected Map<String,String> getParams() {
                Map<String,String> params = new HashMap<String, String>();
                params.put("id","258");
                return params;
            }


        };
        mRequestQueue.add(request);*/

        //using http client

        /*final OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("", p_id)
                .build();

        final Request request = new Request.Builder()
                .url("http://delhimaker.space/index.php?route=api/order/single")
                .post(formBody)
                .build();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();

                    // Do something with the response.
                    mProduct = new JSONObject(response.body().string());
                    Log.d("JSON DATA : ",mProduct.toString());
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();*/

    }
}
