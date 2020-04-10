package com.example.uiprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean isOpen = false;
    private ConstraintSet layout1, layout2;
    private ConstraintLayout constraintLayout;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        layout1 = new ConstraintSet();
        layout2 = new ConstraintSet();
        image = findViewById(R.id.image_cover);
        constraintLayout = findViewById(R.id.constraint_layout);
        layout2.clone(this, R.layout.profile_expand);
        layout1.clone(constraintLayout);

        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!isOpen)
                {
                    isOpen = !isOpen;
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout2.applyTo(constraintLayout);
                }
                else
                {
                    isOpen = !isOpen;
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout1.applyTo(constraintLayout);
                }
            }
        });
    }
}
