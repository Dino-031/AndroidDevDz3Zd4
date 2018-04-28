package com.example.dino.bmicalculator;

import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dino.bmicalculator.Model.BMIcalc;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_height)
    EditText etHeight;
    @BindView(R.id.et_weight)
    EditText etWeight;

    @BindView(R.id.tv_resultNumeric)
    TextView tvResultNumeric;
    @BindView(R.id.tv_resultString)
    TextView tvResultString;
    @BindView(R.id.tv_ResultStringDescription)
    TextView tvResultStringDescription;

    @BindView(R.id.iv_weight)
    ImageView ivWeight;

    @BindView(R.id.btn_calculate)
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_calculate)
    public void Calculate()
    {
        if(etHeight.getText().toString().equals("") || etWeight.getText().toString().equals(""))
        {
            Toast.makeText(this, R.string.string_empty_fields_text,Toast.LENGTH_SHORT).show();
        }
        else if(Float.valueOf((etHeight.getText().toString()))<= 0 || Float.valueOf((etHeight.getText().toString())) >2.5)
            Toast.makeText(this, R.string.string_invalid_height_text,Toast.LENGTH_SHORT).show();
        else if(Float.valueOf(etWeight.getText().toString()) <= 0 || Float.valueOf(etWeight.getText().toString()) >= 350)
            Toast.makeText(this, R.string.string_invalid_weight_text,Toast.LENGTH_LONG).show();
        else
        {
            BMIcalc bmIcalc= new BMIcalc(Float.parseFloat(etWeight.getText().toString()),Float.parseFloat(etHeight.getText().toString()));

            tvResultNumeric.setText(String.valueOf(bmIcalc.calculateBMI()));
            tvResultString.setText(bmIcalc.getStringResult());
            tvResultStringDescription.setText(bmIcalc.getStringDescriptionResult());

            ivWeight.setBackgroundResource(0);

            switch(bmIcalc.getStringResult())
            {
                case "Underweight":
                    ivWeight.setBackgroundResource(R.mipmap.underweight);
                    break;
                case "Normal weight":
                    ivWeight.setBackgroundResource(R.mipmap.normalweight);
                    break;
                case "Overweight":
                    ivWeight.setBackgroundResource(R.mipmap.overweight);
                    break;
                case "Obese":
                    ivWeight.setBackgroundResource(R.mipmap.obese);
                    break;
            }
        }


    }
}
