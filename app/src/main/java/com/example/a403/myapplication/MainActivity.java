package com.example.a403.myapplication;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private double totalAmount=0;
    final int pizza=16000;
    final int spagetti=11000;
    final int salad = 4000;
    EditText et1,et2,et3;
    CheckBox cb1;
    RadioGroup rg1;
    ImageView iv1;
    Button bt1;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("khw");
        setEdit();
        setCheckBox();
        setRadioGroup();
        setImageView();
        setButton();
        setTextView();
    }
    void setEdit(){
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
    }
    void setCheckBox(){
        cb1 = (CheckBox)findViewById(R.id.checkBox);
    }

    void setRadioGroup(){
        rg1 = (RadioGroup)findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton) {
                    iv1.setImageResource(R.drawable.pickle);
                    tv3.setText("피클을 선택하셨습니다");
                }
                else if(checkedId==R.id.radioButton2) {
                    iv1.setImageResource(R.drawable.hotsource);
                    tv3.setText("소스를 선택하셨습니다");
                }
            }
        });
    }
    void setImageView(){
        iv1 = (ImageView)findViewById(R.id.imageView);
    }
    void setButton(){
        bt1 = (Button)findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pizzaCount = Integer.parseInt(et1.getText().toString());
                int spagettiCount = Integer.parseInt(et2.getText().toString());
                int saladCount = Integer.parseInt(et3.getText().toString());
                totalAmount += pizza*pizzaCount;
                totalAmount += spagetti*spagettiCount;
                totalAmount += salad*saladCount;
                if(cb1.isChecked())
                    totalAmount = totalAmount*0.93;
                tv1.setText("주문개수 : "+(pizzaCount+spagettiCount+saladCount));
                String Amount= String.format("%.1f", totalAmount);
                tv2.setText("주문금액 : "+Amount);
                totalAmount = 0;
            }
        });
    }

    void setTextView(){
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        tv3.setText("피클을 선택하셨습니다");
    }
}
