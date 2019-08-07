package com.hridoy.info.japanembassyinterviewquestion;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class SelfIntroduction extends AppCompatActivity {


    private TextToSpeech mTTS;

    private TextView mSelfIntroText;
    private TextView mSelfIntroAnsText;

    private Button mselfInroSayBtn;
    private Button mPreEnSayBtn;



    private Button mselfInroSayAnsBtn;
    private Button mPreEnSayAnsBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Self Introduction");
        setContentView(R.layout.activity_self_introduction);

        mSelfIntroText=findViewById(R.id.selfIntroText);
        mSelfIntroAnsText=findViewById(R.id.SelfIntroAnsText);



        mselfInroSayBtn=findViewById(R.id.selfIntroBtn);
        mPreEnSayBtn=findViewById(R.id.selfIntroEnBtn);


        mselfInroSayAnsBtn=findViewById(R.id.selfIntroAnsSayBtn);
        mPreEnSayAnsBtn=findViewById(R.id.selfIntroAnsEnBtn);




        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.JAPAN);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });







        mselfInroSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelfIntroText.setText("じこしょかいをおしえてください？");
                speak();
            }
        });


        mPreEnSayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSelfIntroText.setText("self introduction please?");
            }
        });






        mselfInroSayAnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelfIntroAnsText.setText("はじめまして….私 は リドともうします。バングラデッシュ じん です.\n" +
                        "Dhakaから来ました.   2２歳です。私 学生です。父 の 名前はビショナトです。母の名前 ぷスパです。しゅみはサッカーをみることです. 6ヶ月で日本語を勉強しました。私は日本の大学で勉強したいから、日本へいきたいです. どうぞよろしくおねがいします。");
                speak1();
            }
        });


        mPreEnSayAnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSelfIntroAnsText.setText(" Nice to meet you .... I am Lido. I'm Bangladeshi.I am from Dhaka. 22 years old. I am a student.My father's name is Bishato. My mother's name is puspa. I Like to look at football. I studied Japanese in 6 months. I would like to go to Japan because I would like to study at a university in Japan.");
            }
        });



    }


    private void speak() {
        String text = mSelfIntroText.getText().toString();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    private void speak1() {
        String text1 = mSelfIntroAnsText.getText().toString();
        mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);

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
