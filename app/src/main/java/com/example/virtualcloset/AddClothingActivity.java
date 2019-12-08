package com.example.virtualcloset;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class AddClothingActivity extends AppCompatActivity {

    ImageView imagePreview;
    Button retakeButton;
    Button addClothing;
    EditText enterName;
    Closet additionCloset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothing);

        final View rootView = findViewById(android.R.id.content).getRootView();
        imagePreview = (ImageView)findViewById(R.id.clothingPreview);

        openCamera(rootView);

        enterName = (EditText) rootView.findViewById(R.id.enterName);
        enterName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length()==0){
                    addClothing.setEnabled(false);
                }else {
                    addClothing.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        additionCloset = (Closet) getIntent().getSerializableExtra("closet");

        retakeButton = (Button) rootView.findViewById(R.id.retakePhoto);
        retakeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCamera(v);
                }
            });

        addClothing = (Button) rootView.findViewById(R.id.acceptAddition);
        addClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                ((BitmapDrawable)imagePreview.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Closet.ClothingArticle newArticle = additionCloset.new ClothingArticle(enterName.getText().toString(), byteArray, "top", "Blue");
                additionCloset.addClothing(newArticle);

                Intent intent = new Intent();
                intent.putExtra("newCloset",additionCloset);
                setResult(10, intent);
                finish();
            }
        });



    }

    public void openCamera(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imagePreview.setImageBitmap(bitmap);
        }
    }


}
