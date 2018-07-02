package project3.abnd2018winner.android.quiz;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;
    RadioGroup q1Radio, q2Radio, q4Radio, q6Radio, q7Radio, q8Radio;
    EditText q3EditText;
    CheckBox cb1, cb2, cb3, cb4;

    //CardView
    CardView que1, que2, que3, que4, que5, que6, que7, que8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1Radio = findViewById(R.id.q1_radio);
        q2Radio = findViewById(R.id.q2_radio);
        q3EditText = findViewById(R.id.q3_edit_text);
        q4Radio = findViewById(R.id.q4_radio);
        cb1 = findViewById(R.id.q5_cb1);
        cb2 = findViewById(R.id.q5_cb2);
        cb3 = findViewById(R.id.q5_cb3);
        cb4 = findViewById(R.id.q5_cb4);
        q6Radio = findViewById(R.id.q6_radio);
        q7Radio = findViewById(R.id.q7_radio);
        q8Radio = findViewById(R.id.q8_radio);
        que1 = findViewById(R.id.q1_card_view);
        que2 = findViewById(R.id.q2_card_view);
        que3 = findViewById(R.id.q3_card_view);
        que4 = findViewById(R.id.q4_card_view);
        que5 = findViewById(R.id.q5_card_view);
        que6 = findViewById(R.id.q6_card_view);
        que7 = findViewById(R.id.q7_card_view);
        que8 = findViewById(R.id.q8_card_view);
    }

    /**
     * Reset is called when reset button is pressed and it resets the quiz.
     */

    public void Reset(View view) {
        //Question 1
        q1Radio.clearCheck();
        //Question 2
        q2Radio.clearCheck();
        //Question 3
        q3EditText.getText().clear();
        //Question 4
        q4Radio.clearCheck();
        //Question 5
        if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked()) {
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
        }
        //Question 6
        q6Radio.clearCheck();
        //Question 7
        q7Radio.clearCheck();
        //Question 8
        q8Radio.clearCheck();
        //Resetting score
        score = 0;

        que1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));
        que2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));
        que3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));
        que4.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));
        que5.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));
        que6.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));
        que7.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));
        que8.setBackgroundColor(ContextCompat.getColor(this, R.color.color_dark_one));


        //Toast when quiz is reset
        Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * Result is called when the Score button is pressed and toast the user score..
     */
    public void Result(View view) {
        score = 0; //resetting score

        EditText nameText = findViewById(R.id.user_name);
        String userName = String.valueOf(nameText.getText());

        try {
            //Question 1
            String ans1 = ((RadioButton) findViewById(q1Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans1.equals("8")) {
                score += 1;
                que1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green)); //Set green if answer is correct
            } else {
                que1.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red));  //Set red if answer is wrong
            }

            //Question 2
            String ans2 = ((RadioButton) findViewById(q2Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans2.equals("Mercury")) {
                score += 1;
                que2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green));
            } else {
                que2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red)); //Red 100
            }

            //Question 3
            if (q3EditText.getText().toString().equalsIgnoreCase("6")) {
                score += 1;
                que3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green));
            } else {
                que3.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red));
            }

            //Question 4
            String ans4 = ((RadioButton) findViewById(q4Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans4.equals("Mars and Jupiter")) {
                score += 1;
                que4.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green));
            } else {
                que4.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red));
            }

            //Question 5
            boolean q5CB1 = cb1.isChecked();
            boolean q5CB2 = cb2.isChecked();
            boolean q5CB3 = cb3.isChecked();
            boolean q5CB4 = cb4.isChecked();
            boolean rightCB = q5CB1 && q5CB2 && q5CB4;
            boolean wrongCB = q5CB3;
            if (rightCB && !wrongCB) {
                score += 1;
                que5.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green));
            } else {
                que5.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red));
            }

            //Question 6
            String ans6 = ((RadioButton) findViewById(q6Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans6.equals("Louis de Buffon")) {
                score += 1;
                que6.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green));
            } else {
                que6.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red));
            }

            //Question 7
            String ans7 = ((RadioButton) findViewById(q7Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans7.equals("5 billion years")) {
                score += 1;
                que7.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green));
            } else {
                que7.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red));
            }

            //Question 8
            String ans8 = ((RadioButton) findViewById(q8Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans8.equals("One astronomical unit")) {
                score += 1;
                que8.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green));
            } else {
                que8.setBackgroundColor(ContextCompat.getColor(this, R.color.color_red));
            }


            //Result
            Toast.makeText(MainActivity.this, userName + getString(R.string.resultScore) + score, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
        }
    }
}
