package aurelienlv.mementodesfleurs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;


public class ScoresActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Scores");
        setContentView(R.layout.activity_scores);
        ((TextView)findViewById(R.id.textView8)).setMovementMethod(new ScrollingMovementMethod());

        lireFichierScores();
        //lireFichierFleurs();
    }

    private void lireFichierFleurs() {
        String texte = "";
        FileInputStream input = null;
        try {
            String str;
            input = openFileInput("fleurs.txt");
            LineNumberReader l = new LineNumberReader(
                    new BufferedReader(new InputStreamReader(input)));
            while((str=l.readLine())!=null)
            {
                texte += str+"\n";
            }
            if(input != null)
                input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((TextView)findViewById(R.id.textView8)).setText(texte);
    }

    private void lireFichierScores() {
        String[] texte = new String[100];
        FileInputStream input = null;
        try {
            String str;
            input = openFileInput("notes.txt");
            LineNumberReader l = new LineNumberReader(
                    new BufferedReader(new InputStreamReader(input)));
            for(int i=0;((str=l.readLine())!=null);i++)
            {
                if(i < 100)
                    texte[i] = str;
            }
            if(input != null)
                input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String texte2 = "";
        for(int i=99; i>=0; i--) {
            if(texte[i]!=null)
                texte2 += texte[i] + "\n";
        }
        ((TextView)findViewById(R.id.textView8)).setText(texte2);
    }

    public void effacerScores(View view) {
        deleteFile("notes.txt");
        finish();
    }

    public void close(View view) {
        finish();
    }
}
