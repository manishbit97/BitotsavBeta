package com.example.manis.bitotsavbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class IntroActivity extends MaterialIntroActivity {
    private PrefManager prefManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.first_slide_background)
                        .buttonsColor(R.color.first_slide_buttons)
                        .image(R.drawable.bitotsav)
                        .title("BITOTSAV")
                        .description("Welcome to BIT Mesra Annual Cultural Festival")
                        .build()
               /* new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("We provide solutions to make you love your work");
                    }
                }, "Work with love")*/);

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.second_slide_background)
                .buttonsColor(R.color.second_slide_buttons)
                .image(R.drawable.sunidhi)
                .title("Fun Filled Nights")
                .description("Nights were dazzled by stars like DJ kerano and Progressive brothers,  GATC and Underground Authority. The last night enhanced the glamour of Bitotsav'17 with Sunidhi Chauhan's performance")
                .build());

        // addSlide(new CustomSlide());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.third_slide_background)
                .buttonsColor(R.color.third_slide_buttons)
                .image(R.drawable.img_equipment)
                .title("Full Day Packed Events!")
                .description("4-Day Continous Events !")
                .build());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.fourth_slide_background)
                .buttonsColor(R.color.fourth_slide_buttons)
                .image(R.drawable.nights)
                .title("That's it")
                .description("Join Bitotsav Extravaganza !")
                .build());
    }
    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(IntroActivity.this, MainActivity.class));
        finish();
    }
    @Override
    public void onFinish() {
        super.onFinish();
        startActivity(new Intent(IntroActivity.this, MainActivity.class));
    }
}