package ke.co.sombo.apps.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.score_text)
    TextView scoreText;
    @BindView (R.id.toolbar)
    Toolbar toolbar;
    @BindView (R.id.q1option1)
    RadioButton q1option1;
    @BindView (R.id.q1option2)
    RadioButton q1option2;
    @BindView (R.id.q1option3)
    RadioButton q1option3;
    @BindView (R.id.q1option4)
    RadioButton q1option4;
    @BindView (R.id.q2option1)
    CheckBox q2option1;
    @BindView (R.id.q2option2)
    CheckBox q2option2;
    @BindView (R.id.q2option3)
    CheckBox q2option3;
    @BindView (R.id.q2option4)
    CheckBox q2option4;
    @BindView (R.id.q3option)
    EditText q3option;
    @BindView (R.id.q4option1)
    RadioButton q4option1;
    @BindView (R.id.q4option2)
    RadioButton q4option2;
    @BindView (R.id.q5option1)
    CheckBox q5option1;
    @BindView (R.id.q5option2)
    CheckBox q5option2;
    private int score;


    String q3answer = "hybrid";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        score = 0;
        scoreText.setText(String.format(Locale.getDefault(), "Score: %d", score));
    }

    @OnClick (R.id.submit_button)
    public void onViewClicked () {
        if (q1option1.isChecked()) {
            incrementScore();
        }
        if (q2option1.isChecked() && q2option2.isChecked() && q2option3.isChecked()) {
            incrementScore();
        }
        if ((q3option.getText().toString().trim()).equalsIgnoreCase(q3answer)) {
            incrementScore();
        }
        if (q4option1.isChecked()) {
            incrementScore();
        }
        if (q5option1.isChecked()) {
            incrementScore();
        }
        scoreText.setText(String.format(Locale.getDefault(), "Score: %d", score));
        Toast.makeText(getApplicationContext(), "Your score is: " + score, Toast.LENGTH_SHORT).show();
    }

    public void incrementScore () {
        score += 1;
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (item.getItemId() == R.id.reset) {
            q1option1.setChecked(false);
            q1option2.setChecked(false);
            q1option3.setChecked(false);
            q1option4.setChecked(false);
            q2option1.setChecked(false);
            q2option2.setChecked(false);
            q2option3.setChecked(false);
            q2option4.setChecked(false);
            q3option.setText("");
            q4option1.setChecked(false);
            q4option2.setChecked(false);
            q5option1.setChecked(false);
            q5option2.setChecked(false);
        }
        return super.onOptionsItemSelected(item);
    }
}
