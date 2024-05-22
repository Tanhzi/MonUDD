package com.example.myapplication.t61;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class Tuan6DetaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan6_detai);

        //nhan du lieu tu listproduc chuyen qua
        Intent intent=getIntent();
        Product product=intent.getParcelableExtra("PRODUCT");

        //anh xa cac thanh phan len giao dien
        ImageView imgPro=findViewById(R.id.tuan6DetaiImg);
        TextView tvStyleId=findViewById(R.id.tuan6DetaiStyleId);
        TextView tvBrand=findViewById(R.id.tuan6DetaiBrand);
        TextView tvPrice=findViewById(R.id.tuan6DetaiPrice);
        TextView tvInfo=findViewById(R.id.tuan6DetaiAdditionalInfo);
        //hien thi thong tin chi tiet cua san pham
        if (product!=null) {
            Picasso.get().load(product.getSearchImage()).into(imgPro);

            tvInfo.setText("Info: "+product.getAdditionInfo());
            tvBrand.setText("Brand: "+product.getBrand());
            tvPrice.setText("Price: "+product.getPrice());
            tvStyleId.setText("StyleID: "+product.getStyleId());
        }
    }
}