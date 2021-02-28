package com.geek.a1_hw1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    EditText editText;
    ImageView imageView;
    Uri uriImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.secondImage);
    }

    public void transitionToGallery(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            uriImage = data.getData();
            imageView.setImageURI(uriImage);
        }
    }
    public void transitionToFirstActivity(View view) {
        Intent intent = new Intent();
        String str , str1;
        str1 = editText.getText().toString();
        str = String.valueOf(uriImage);
        intent.putExtra("URI_TEXT",str);
        intent.putExtra("EDIT_TEXT",str1);
        setResult(RESULT_OK,intent);
        finish();
    }
}