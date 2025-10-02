package com.example.lap6_daothily_1150070027;

import android.os.Bundle;
import android.view.animation.*;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Image
    private ImageView ivUitLogo;

    // Buttons (XML vs CODE)
    private Button btnFadeInXml,  btnFadeInCode;
    private Button btnFadeOutXml, btnFadeOutCode;
    private Button btnBlinkXml,   btnBlinkCode;
    private Button btnZoomInXml,  btnZoomInCode;
    private Button btnZoomOutXml, btnZoomOutCode;
    private Button btnRotateXml,  btnRotateCode;
    private Button btnMoveXml,    btnMoveCode;
    private Button btnSlideUpXml, btnSlideUpCode;
    private Button btnBounceXml,  btnBounceCode;
    private Button btnCombineXml, btnCombineCode;

    private Animation.AnimationListener animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // phải có trước khi findViewById

        findViewsByIds();
        initAnimationListener();
        wireXmlAnimations();
        wireCodeAnimations();
    }

    private void findViewsByIds() {
        ivUitLogo      = findViewById(R.id.iv_uit_logo);

        btnFadeInXml   = findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode  = findViewById(R.id.btn_fade_in_code);

        btnFadeOutXml  = findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = findViewById(R.id.btn_fade_out_code);

        btnBlinkXml    = findViewById(R.id.btn_blink_xml);
        btnBlinkCode   = findViewById(R.id.btn_blink_code);

        btnZoomInXml   = findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode  = findViewById(R.id.btn_zoom_in_code);

        btnZoomOutXml  = findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = findViewById(R.id.btn_zoom_out_code);

        btnRotateXml   = findViewById(R.id.btn_rotate_xml);
        btnRotateCode  = findViewById(R.id.btn_rotate_code);

        btnMoveXml     = findViewById(R.id.btn_move_xml);
        btnMoveCode    = findViewById(R.id.btn_move_code);

        btnSlideUpXml  = findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = findViewById(R.id.btn_slide_up_code);

        btnBounceXml   = findViewById(R.id.btn_bounce_xml);
        btnBounceCode  = findViewById(R.id.btn_bounce_code);

        btnCombineXml  = findViewById(R.id.btn_combine_xml);
        btnCombineCode = findViewById(R.id.btn_combine_code);
    }

    private void initAnimationListener() {
        animationListener = new Animation.AnimationListener() {
            @Override public void onAnimationStart(Animation animation) {
                // optional: Toast.makeText(MainActivity.this,"Bắt đầu",Toast.LENGTH_SHORT).show();
            }
            @Override public void onAnimationEnd(Animation animation) {
                // optional
            }
            @Override public void onAnimationRepeat(Animation animation) { }
        };
    }

    /* ====== Gán các animation load từ XML ====== */
    private void wireXmlAnimations() {
        handleClickAnimationXml(btnFadeInXml,   R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml,  R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml,    R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml,   R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,  R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml,   R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml,     R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml,  R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml,   R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml,  R.anim.anim_combine);
    }

    /* ====== Gán các animation tạo bằng Code ====== */
    private void wireCodeAnimations() {
        // Fade In
        AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
        fadeIn.setDuration(800);
        fadeIn.setFillAfter(true);
        handleClickAnimationCode(btnFadeInCode, fadeIn);

        // Fade Out
        AlphaAnimation fadeOut = new AlphaAnimation(1f, 0f);
        fadeOut.setDuration(800);
        fadeOut.setFillAfter(true);
        handleClickAnimationCode(btnFadeOutCode, fadeOut);

        // Blink
        AlphaAnimation blink = new AlphaAnimation(0f, 1f);
        blink.setDuration(200);
        blink.setRepeatCount(5);
        blink.setRepeatMode(Animation.REVERSE);
        handleClickAnimationCode(btnBlinkCode, blink);

        // Zoom In
        ScaleAnimation zoomIn = new ScaleAnimation(
                0.5f, 1.2f, 0.5f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        zoomIn.setDuration(400);
        handleClickAnimationCode(btnZoomInCode, zoomIn);

        // Zoom Out
        ScaleAnimation zoomOut = new ScaleAnimation(
                1.2f, 0.6f, 1.2f, 0.6f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        zoomOut.setDuration(400);
        handleClickAnimationCode(btnZoomOutCode, zoomOut);

        // Rotate
        RotateAnimation rotate = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(600);
        handleClickAnimationCode(btnRotateCode, rotate);

        // Move (dịch trái → phải)
        TranslateAnimation move = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, -0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f);
        move.setDuration(600);
        handleClickAnimationCode(btnMoveCode, move);

        // Slide Up (từ dưới lên)
        TranslateAnimation slideUp = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f,
                Animation.RELATIVE_TO_SELF, 0f);
        slideUp.setDuration(500);
        slideUp.setInterpolator(new AccelerateDecelerateInterpolator());
        handleClickAnimationCode(btnSlideUpCode, slideUp);

        // Bounce
        ScaleAnimation bounce = new ScaleAnimation(
                0.7f, 1f, 0.7f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        bounce.setDuration(700);
        bounce.setInterpolator(new BounceInterpolator());
        handleClickAnimationCode(btnBounceCode, bounce);

        // Combine (zoom + rotate + fade)
        AnimationSet combine = new AnimationSet(true);
        combine.setInterpolator(new AccelerateDecelerateInterpolator());

        ScaleAnimation s = new ScaleAnimation(
                0.6f, 1.1f, 0.6f, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        s.setDuration(500);

        RotateAnimation r = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        r.setDuration(600);

        AlphaAnimation a = new AlphaAnimation(0.2f, 1f);
        a.setDuration(500);

        combine.addAnimation(s);
        combine.addAnimation(r);
        combine.addAnimation(a);

        handleClickAnimationCode(btnCombineCode, combine);
    }

    /* ========= Helpers ========= */
    private void handleClickAnimationXml(Button btn, int animResId) {
        btn.setOnClickListener(v -> {
            Animation anim = AnimationUtils.loadAnimation(MainActivity.this, animResId);
            anim.setAnimationListener(animationListener);
            ivUitLogo.startAnimation(anim);
        });
    }

    private void handleClickAnimationCode(Button btn, Animation animation) {
        btn.setOnClickListener((View v) -> {
            animation.setAnimationListener(animationListener);
            ivUitLogo.startAnimation(animation);
        });
    }
}
