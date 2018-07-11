package com.example.jason.bradfordfactor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** how to use
     * 2 arrows buttons on the side of each text view to increase or
     * decrease the number of days/absence of work
     *
     * total button to calculate the total of days off work
     * reset button to clear the results
     */



    // final BF score
    int totalpoints =0;
    // number of days off work
    int days=0;
    // number of absences off work
    int absences =0;

   // display the amount of days off work
    TextView total_days;
    // display the amount of absences off work
    TextView total_absence;
    // this will display (total absence x total absence) x days off,
    // and display the BF score
    TextView total_points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // give all the textView's a value of zero

        total_days=(TextView)findViewById(R.id.tv_day_count);
        total_days.setText(""+0);

        total_absence=(TextView)findViewById(R.id.tv_absence_count);
        total_absence.setText(""+0);

        total_points=(TextView)findViewById(R.id.tv_total_score);
        total_points.setText(""+0);
    }
    // when the arrow up button next to the total_days textview is pressed the
    // number of days goes up one
    public void days_up(View view){
    days = days+1;
        total_days.setText(""+days);
    }
    // when the arrow down button next to the total_days textview is pressed the
    // number of days goes down one
    public void days_down(View view){
        if (days>1){
            days = days-1;
        }else{
            days =0;
        }
        total_days.setText(""+days);
    }
    // when the arrow up button next to the absence textview is pressed the
    // number of days goes up one

    public void absence_count_up(View view){
            absences = absences+1;
        total_absence.setText(""+absences);
    }
    // when the arrow down button next to the absence textview is pressed the
    // number of days goes down one
    public void absence_count_down(View view){
        if (absences>1){
            absences = absences-1;
        }else{
            absences =0;
        }
        total_absence.setText(""+absences);
    }

    // total button calculates the bradford factor score
    public void total(View view){

        total_points.setText(""+(absences * absences) * days);
    }

    // resets button resets all textviews back to zero
    public void reset(View view){
        days = 0;
        absences=0;
        totalpoints=0;
        total_days.setText(""+0);
        total_absence.setText(""+0);
        total_points.setText(""+0);
}
 @Override
 protected void onSaveInstanceState(Bundle outState){
        outState.putString("days",total_days.getText().toString());
        outState.putString("absence",total_absence.getText().toString());
        outState.putString("points",total_points.getText().toString());
        super.onSaveInstanceState(outState);

    }
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        total_days.setText( saveInstanceState.getString("days"));
        total_absence.setText( saveInstanceState.getString("absence"));
        total_points.setText( saveInstanceState.getString("points"));
    }

}
