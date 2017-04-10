package com.hazfutbol.hfapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hazfutbol.hfapp.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class CarouselPresentationActivity extends Activity {

    private static final int LAST_CAROUSEL_IMAGE = 3;

    private CarouselView carouselView;
    private int[] images = {R.drawable.carousel_presentation_1,
            R.drawable.carousel_presentation_2, R.drawable.carousel_presentation_3, R.drawable.carousel_presentation_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_presentation);
        carouselView = (CarouselView) findViewById(R.id.carouselPresentation);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(final int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == LAST_CAROUSEL_IMAGE) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    };
}
