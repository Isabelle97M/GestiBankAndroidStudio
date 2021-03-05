package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sip.gestibank.models.Currency;
import com.sip.gestibank.remote.ApiUtils;
import com.sip.gestibank.remote.CurrencyService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyConverter extends AppCompatActivity {

    CurrencyService currencyService;
    double monetaryCourse;
    double input;
    double result;

    EditText myInput;
    TextView myResult;

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        currencyService = ApiUtils.getCurrencyService();

        myInput = (EditText) findViewById(R.id.editInput);
        myResult = (TextView) findViewById(R.id.viewResult);
        radioGroup = (RadioGroup) findViewById(R.id.radioGrp);

    }

    public void callGoBackHomeCreation(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void getCurrency(View v){

        input = Double.parseDouble(myInput.getText().toString());

        int radioButtonID = radioGroup.getCheckedRadioButtonId();

        radioButton = radioGroup.findViewById(radioButtonID);
        String to = (String) radioButton.getText();

        String rul = "live?access_key=eb0266e2105bab6851fd6d23635f04e4&currencies="+to+"&format=1/";
        Call<Currency> call = currencyService.getData(rul);
        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                if(response.isSuccessful()){
                    String quotes = response.body().getQuotes().toString();
                    // récupération du cours
                    String rate = quotes.substring(quotes.indexOf("=")+1,quotes.indexOf("}"));
                    monetaryCourse = Double.parseDouble(rate);
                    result = monetaryCourse*input;
                    result = (double)((int)(result*100))/100;
                    myResult.setText(Double.valueOf(result).toString());
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.e("Problem: ", t.getMessage());
            }
        });

    }




}