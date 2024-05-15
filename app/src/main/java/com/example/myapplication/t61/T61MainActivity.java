package com.example.myapplication.t61;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.ArrayList;
import java.util.List;

public class T61MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProductAdapter adapter;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t61_main);
        listView = findViewById(R.id.t61listview);
        productList=new ArrayList<>();
        adapter=new ProductAdapter(this,productList);
        listView.setAdapter(adapter);
        //get data from API
        new FetchProductsTask().execute();

    }
    private  class  FetchProductsTask extends AsyncTask<Void, Void, String> {

        //get data from API via internet
        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response=new StringBuilder();
            try {
                URL url=new URL("https://hungnttg.github.io/shopgiay.json");//url
                //open connection
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                //set method
                connection.setRequestMethod("GET");
                //create buffer for read data
                BufferedReader reader=new
                        BufferedReader(new InputStreamReader(connection.getInputStream()));
                //read data
                String line="";
                while ((line=reader.readLine())!=null)//read unril EDF
                {
                    response.append(line);
                }
                reader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return response.toString();
        }
        //return data for client
        @Override
        protected void onPostExecute(String s) {
            if (s!=null && !s.isEmpty()) {
                try {
                    JSONObject json=new JSONObject(s);
                    JSONArray productsArray=json.getJSONArray("products");//get an array for objects
                    for (int i=0;i<productsArray.length();i++) {
                        JSONObject productObject=productsArray.getJSONObject(i);
                        String styleId=productObject.getString("styleid");
                        String brand=productObject.getString("brands_filter_facet");
                        String price=productObject.getString("price");
                        String additionalInfo=productObject.getString("product_additional_info");
                        String searchImage=productObject.getString("search_image");
                        Product product=new Product(styleId,brand,price,additionalInfo,searchImage);
                        productList.add(product);
                    }
                    adapter.notifyDataSetInvalidated();//update to adapter
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                Toast.makeText(T61MainActivity.this,"Failed to fetch producs!",Toast.LENGTH_LONG).show();
            }
        }
    }
}