package aurelienlv.mementodesfleurs;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Memento des fleurs");
        TextView tview = (TextView) findViewById(R.id.textView);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/DancingScript-Regular.ttf");
        tview.setTypeface(type);
        remplirFleursFaites();
        remplirFleursNonFaites();
    }

    private void remplirFleursNonFaites() {
        Metier metier = Metier.getInstance();
        for(int i=0; i<metier.getFleurs().size(); i++) {
            if(!metier.getFleursFaites().contains(metier.getFleurs().elementAt(i))) {
                metier.getFleursNonFaites().addElement(metier.getFleurs().elementAt(i));
            }
        }
    }

    public void remplirFleursFaites() {
        FileInputStream input = null;
        String numeroFleur;
        try {
            input = openFileInput("fleurs.txt");
            LineNumberReader l = new LineNumberReader(
                    new BufferedReader(new InputStreamReader(input)));
            while ((numeroFleur=l.readLine()) != null) {
                Metier metier = Metier.getInstance();
                metier.getFleursFaites().addElement(metier.getFleurs().elementAt(Integer.parseInt(numeroFleur)));
            }

            if (input != null)
                input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(View view) {
        Intent epView = new Intent(MainActivity.this, EpreuveActivity.class);
        startActivity(epView);
    }

    public void close(View view) {
        finish();
    }

    public void ouvrirScores(View view) {
        Intent epView = new Intent(MainActivity.this, ScoresActivity.class);
        startActivity(epView);
    }

    public void ouvrirTout(View view) {
        Intent epView = new Intent(MainActivity.this, ToutActivity.class);
        startActivity(epView);
    }
}
