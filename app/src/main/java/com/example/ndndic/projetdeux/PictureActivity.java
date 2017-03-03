package com.example.ndndic.projetdeux;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {
    Button btnTakePhoto;
    ImageView imgTakenPhoto;
    private static final int CAM_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        btnTakePhoto =(Button) findViewById(R.id.button1);
        imgTakenPhoto = (ImageView) findViewById(R.id.imageview1);
        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST ){
            Bitmap thumbnail=(Bitmap) data.getExtras().get("data");
            imgTakenPhoto.setImageBitmap(thumbnail);
        }
    }

    class btnTakePhotoClicker implements Button.OnClickListener {

        public void onClick(View v){
            Intent cameraintent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraintent, CAM_REQUEST);
        }



    }
}
