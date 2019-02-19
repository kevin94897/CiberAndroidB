package pe.edu.cibertec.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnYes, btnNo;
    Button btnNext, btnPrevious;
    ArrayList<Question> questions;
    TextView tvQuestion;
    int nquestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNO);
        tvQuestion = findViewById(R.id.tvQuestion);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);

        questions = new ArrayList<>();

        loadQuestions();

        nquestion = 0;

        showActualQuestion();


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifyResponse(true);

            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifyResponse(false);

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nquestion = (nquestion < questions.size() - 1)?nquestion+1:0;
                showActualQuestion();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nquestion = (nquestion > 0)?nquestion-1:questions.size()-1;
                showActualQuestion();
            }
        });

    }

    private void verifyResponse(boolean option) {
        Toast.makeText(MainActivity.this,
                (questions.get(nquestion).isResponse() == option) ? getString(R.string.msg_correct) : getString(R.string.msg_incorrect),
                Toast.LENGTH_SHORT).show();

    }

    private void showActualQuestion() {
        tvQuestion.setText(questions.get(nquestion).getName());
    }

    private void loadQuestions() {
        Question questionPeru = new Question(getString(R.string.peru_question), true);
        Question questionChile = new Question(getString(R.string.chile_question), false);
        Question questionColombia = new Question(getString(R.string.colombia_question), false);

        questions.add(questionPeru);
        questions.add(questionChile);
        questions.add(questionColombia);

    }
}