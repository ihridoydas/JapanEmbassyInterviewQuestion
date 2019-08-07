package com.hridoy.info.japanembassyinterviewquestion;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class PreparationActivity extends AppCompatActivity {

    private TextToSpeech mTTS;

    private TextView mPreTextContent;

    private Button mPreSayBtn;
    private Button mPreBanSayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Entry Preparation");
        setContentView(R.layout.activity_preparation);



        mPreTextContent=findViewById(R.id.precontent);

        mPreSayBtn=findViewById(R.id.presayit);
        mPreBanSayBtn=findViewById(R.id.prebansayit);



        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        mPreBanSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreTextContent.setText("রুম - এ ঢুকার পূর্বে দরজা দুইবার নক করে, দরজা টান দিবেন ।দরজাটা একটু খানি ফাঁক হলে, সাথে সাথে (はいってもいですか) কথা বলে ভিতরে ঢুকবেন। দরজাটা আস্তে করে বন্ধ করবেন ,ভিতরে প্রবেশ করে (しつれいします) বলে (こんにちは) বলে সাক্ষাৎকার এর জন্য প্রস্তুত হবেন। কোন প্রশ্ন না বুঝলে (すみませんもういちどおねがいします) বলবেন । আর প্রশ্ন না পারলে (せんせいこのしつもんがわかりません) বলবেন। কানজি পড়ার সময় ,কোন কানজি না পারলে কানজি টি আঙ্গুল দিয়ে দেখিয়ে (あのせんせいこのかんじがすこしわかりません)বলবেন।  জাপানি (ありがとうございました) বলে সাক্ষাৎকার শেষ করবেন।  সাক্ষাৎকার শেষ হওয়ার সাথে সাথেই (どうもありがとうございました) বলে রুম থেকে বের হবেন ।");
            }
        });

        mPreSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreTextContent.setText("Before entering the room, the door will knock twice, pull the door. If the room is a little empty, then immediately (haittemoidesuka) will talk inside. Close the door slowly, and go inside (shitsureishimasu) to say (kon'nichiha) to be prepared for the interview. If you do not understand the question (sumimasenmouichidoonegaishimasu) And if you do not have any questions (say to- senseikonoshitsumongawakarimasen) say. At the time of Kanji study, if you can not do any Kanji, you can tell Kanji with your fingers (anosenseikonokanjigasukoshiwakarimasen). End the interview with Japanese (arigatougozaimashita). As soon as the interview ends (doumoarigatougozaimashita) will be out of the room.");


            }
        });
    }

    private void speak() {
        String text = mPreTextContent.getText().toString();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
