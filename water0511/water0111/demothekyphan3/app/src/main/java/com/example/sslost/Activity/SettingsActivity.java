package com.example.sslost.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sslost.Activity.View.UI.RatingDialog;
import com.example.sslost.R;

import java.util.Calendar;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private View rlProfile, rlEditPlan, rlReminder, rlLanguage, rlReason, ivSwitch, ivVibrationSwitch, ivVoiceSwitch;
    ImageView ivTip;
    LinearLayout ll_vibration, ll_voice;
    RelativeLayout rlTitle, rlRate, rlFeedback;
    RecyclerView rcvReminder;
    TextView tvTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        rlProfile = findViewById(R.id.rl_profile);
        rlEditPlan = findViewById(R.id.rl_plan);
        rlReminder = findViewById(R.id.rl_reminder);
        rlLanguage = findViewById(R.id.rl_language);
        rlReason = findViewById(R.id.rl_reason);
        ivSwitch = findViewById(R.id.iv_title_switch);

        rlTitle = findViewById(R.id.rl_title);
        rlRate = findViewById(R.id.rl_rate);
        rlFeedback = findViewById(R.id.rl_feedback);
        rcvReminder = findViewById(R.id.rcv_reminder);
        tvTip = findViewById(R.id.tv_tip);
        ivTip = findViewById(R.id.iv_tip);

        rlReminder.setOnClickListener(this);
        rlEditPlan.setOnClickListener(this);
        rlProfile.setOnClickListener(this);
        rlLanguage.setOnClickListener(this);
        rlReason.setOnClickListener(this);
        rlRate.setOnClickListener(this);
        rlFeedback.setOnClickListener(this);


//        rcvReminder.setAdapter(mRcvAdapterReminder);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        rcvReminder.setLayoutManager(gridLayoutManager);

        checkEnableReminder();
        rlTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ivSwitch.isSelected()) ivSwitch.setSelected(false);
                else ivSwitch.setSelected(true);
                checkEnableReminder();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.rl_profile:
//                Intent it = new Intent(this, EditProfileActivity.class);
//                startActivity(it);
//                break;
//            case R.id.rl_plan:
//                Intent it1 = new Intent(this, EditPlanActivity.class);
//                startActivity(it1);
//                break;
//            case R.id.rl_reminder:
//                showBottomSheetAddReminder();
//                break;
//            case R.id.rl_language:
//                Intent it3 = new Intent(this, LanguageActivity.class);
//                startActivity(it3);
//                break;
//            case R.id.rl_reason:
//                showBottomSheetRemoveAds();
//                break;
            case R.id.rl_rate:
                final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                        .icon(getResources().getDrawable(R.drawable.salad))
                        .session(0)
                        .threshold(4)
                        .title("How was your experience with us?")
                        .titleTextColor(R.color.black)
                        .positiveButtonText("Send")
                        .negativeButtonText("Never")
                        .positiveButtonTextColor(R.color.black)
                        .negativeButtonTextColor(R.color.black)
                        .formTitle("Submit Feedback")
                        .formHint("Tell us where we can improve")
                        .formSubmitText("Submit")
                        .formCancelText("Cancel")
                        .ratingBarColor(R.color.black)
                        .playstoreUrl("market://details?id=com.samsung.android.app.notes")
                        .onRatingChanged(new RatingDialog.Builder.RatingDialogListener() {
                            @Override
                            public void onRatingSelected(float rating, boolean thresholdCleared) {

                            }
                        })
                        .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                            @Override
                            public void onFormSubmitted(String feedback) {
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("message/rfc822");
                                intent.setPackage("com.google.android.gm");
                                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback 30DayChallenger App");
                                intent.putExtra(Intent.EXTRA_TEXT, feedback);
                                try {
                                    startActivity(Intent.createChooser(intent, "Feedback to Dev..."));
                                } catch (android.content.ActivityNotFoundException ex) {
                                    Toast.makeText(SettingsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).build();

                ratingDialog.show();
                break;
            case R.id.rl_feedback:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.setPackage("com.google.android.gm");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback 30DayChallenger App");

                try {
                    startActivity(Intent.createChooser(i, "Feedback to Dev..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SettingsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

//    public void showBottomSheetAddReminder() {
//        AlertDialogFragment alertDialogFragment = AlertDialogFragment.newInstance();
//        alertDialogFragment.setOnSaveReminder(new AlertDialogFragment.onSaveReminder() {
//            @Override
//            public void save(Alarm alarm) {
//                boolean check = checkAlarm(alarm);
//                if (!check) {
//                    // add alarm to adapter
//                    mRcvAdapterReminder.add(alarm);
//                    // refresh adapter
//                    mRcvAdapterReminder.notifyDataSetChanged();
//                    // add it to database
//                    dataBaseManager.insert(alarm);
//                    // set new PendingIntent
//                    setAlarm(alarm, 0);
//                }
//            }
//        });
//        alertDialogFragment.show(this.getSupportFragmentManager(), AlertDialogFragment.TAG);
//    }

//    public void showBottomSheetRemoveAds() {
//        RemoveAdsDialogFragment removeAdsDialogFragment = RemoveAdsDialogFragment.newInstance();
//        removeAdsDialogFragment.show(this.getSupportFragmentManager(), RemoveAdsDialogFragment.TAG);
//    }

    public void checkEnableReminder() {
        if (!ivSwitch.isSelected()) {
//            cancelAllAlarm();
            rcvReminder.setAlpha(0.3f);
            rcvReminder.setClickable(false);
            tvTip.setAlpha(0.3f);
            ivTip.setAlpha(0.3f);
            rlReminder.setAlpha(0.3f);
            rlReminder.setClickable(false);
        } else {
//            startAllAlarm();
            rcvReminder.setAlpha(1.0f);
            tvTip.setAlpha(1.0f);
            ivTip.setAlpha(1.0f);
            rcvReminder.setClickable(true);
            rlReminder.setAlpha(1.0f);
            rlReminder.setClickable(true);

        }
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }


}