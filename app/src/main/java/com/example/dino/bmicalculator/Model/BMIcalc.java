package com.example.dino.bmicalculator.Model;

/**
 * Created by Dino on 28/04/2018.
 */

public class BMIcalc {

    float weight;
    float height;

    public BMIcalc(float weight, float height) {
        this.weight = weight;
        this.height = height;
    }

    public float calculateBMI()
    {
        float result = weight / (height*height);
        return  result;
    }
    public String getStringResult()
    {
        String resultString;
        float result = calculateBMI();
        if(result<18)
            resultString = "Underweight";
        else if(result>= 18 && result<25)
            resultString = "Normal weight";
        else if(result>=25 && result<30)
            resultString = "Overweight";
        else
            resultString = "Obese";
        return  resultString;
    }
    public String getStringDescriptionResult()
    {
        String resultDescription;
        String resultString = getStringResult();
        if(resultString.equals("Underweight"))
            resultDescription = "You are to skinny!";
        else if(resultString.equals("Normal weight"))
            resultDescription = "Your weight is normal!";
        else if(resultString.equals("Overweight"))
            resultDescription = "You are fat!";
        else
            resultDescription = "You are way to fat!";
        return resultDescription;
    }
}
