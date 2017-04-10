package amazon.vardaan.pwain_merchant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTPActivity extends AppCompatActivity {
    Button verifyOTP;
    EditText otpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
    }

    @Override
    protected void onStart() {
        super.onStart();
        verifyOTP = (Button) findViewById(R.id.otpVerifyButton);
        otpText = (EditText) findViewById(R.id.editOTP);
        final String ogOTP = getIntent().getExtras().getString("otp");
        final String url = getIntent().getExtras().getString("url");
        verifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredOTP = otpText.getText().toString();
                if (enteredOTP.equalsIgnoreCase(ogOTP)) {
                    Toast.makeText(getApplicationContext(), "Successful transaction", Toast.LENGTH_SHORT).show();
                    //TODO : Make call to UI for payment
                    openInWebView(url);
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect OTP", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    private void openInWebView(String url){
        Intent i = new Intent(this, CustomerWebView.class);
        Log.wtf("sending url", url);
        i.putExtra("url", url);
        startActivity(i);
    }
}