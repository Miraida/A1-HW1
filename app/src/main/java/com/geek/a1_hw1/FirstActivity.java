package com.geek.a1_hw1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    String uriImage ;
    String textFromSecondActivity = " Hey , I'm from app A1-Hw1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.firstText);
        imageView = findViewById(R.id.firstImage);
    }


    public void transitionToSecondActivity(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) return;

        uriImage = data.getStringExtra("URI_TEXT");
        textFromSecondActivity = data.getStringExtra("EDIT_TEXT");
        imageView.setImageURI(Uri.parse(uriImage));
        textView.setText(textFromSecondActivity);
    }

    public void transitionToG_mail(View view) {
//      Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","miraidajaanbaeva@gmail.com",null));
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Any subject if you want");
//        startActivity(intent);
        Intent send = new Intent(Intent.ACTION_SENDTO);
        String uriText = "mailto:" + Uri.encode("miraidajaanbaeva@gmail.com") +
                "?subject=" + Uri.encode("G-mail Intent") +
                "&body=" + Uri.encode(textFromSecondActivity);
        Uri uri = Uri.parse(uriText);

        send.setData(uri);
        startActivity(Intent.createChooser(send, "Send mail..."));
    }
}