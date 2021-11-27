package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
int scoreTeamA=0;
int scoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    -------------------------------------------------
                    //    Team A
    public void add3ForTeamA(View v){
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }
    public void add2ForTeamA(View v){
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }
    public void add1ForTeamA(View v){
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }
    public void displayForTeamA(int points){
//        MainActivity.points=points;
        TextView pointsView= findViewById(R.id.teamAPoints);
        pointsView.setText(scoreTeamA+"");
    }

//    --------------------------------------------------

                    //    Team B
    public void add3ForTeamB(View v){
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    public void add2ForTeamB(View v){
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }
    public void add1ForTeamB(View v){
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }
    public void displayForTeamB(int points){
//        MainActivity.points=points;
        TextView pointsView= findViewById(R.id.teamBPoints);
        pointsView.setText(scoreTeamB+"");
    }

public void reset(View v){
        scoreTeamB=0;
        scoreTeamA=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
}
}