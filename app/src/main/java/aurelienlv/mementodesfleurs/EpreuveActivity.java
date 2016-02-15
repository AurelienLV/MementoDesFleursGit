package aurelienlv.mementodesfleurs;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.Collator;
import java.util.Locale;
import java.util.Vector;


public class EpreuveActivity extends ActionBarActivity {

    private static int nbEpreuve = 0;
    private static int noteEpreuve = 0;
    private RelativeLayout relativeLayout;
    private TextView txtNumEpreuve;
    private EditText lastEdit;
    private Metier metier;
    private Fleur fleur;
    private static Vector<Fleur> vectFleursEpreuveCourante = new Vector<Fleur>();
    private static Vector<Fleur> vectFleursFausses = new Vector<Fleur>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epreuve);
        metier = Metier.getInstance();
        txtNumEpreuve = (TextView) findViewById(R.id.textView6);
        lastEdit = (EditText) findViewById(R.id.editText3);
        lastEdit.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event){
                return true;
            }
        });

        changerDiapo();
    }

    private void changerDiapo() {
        if(nbEpreuve < 20) {
            nbEpreuve++;
            fleur = tirerFleur();
            changerImage(fleur);
            changerNumEpreuve();
        }
        else {
            setTitle("Score");
            relativeLayout = (RelativeLayout) findViewById(R.id.layoutEpreuve);
            relativeLayout.removeAllViews();

            vectFleursEpreuveCourante.removeAllElements();
            enregistrerNote();

            TextView txvTitle = new TextView(this);
            txvTitle.setText("Score : " + noteEpreuve + "/20");
            txvTitle.setTextColor(0xFF000000);
            txvTitle.setVisibility(View.VISIBLE);
            txvTitle.setTextSize(30);

            LinearLayout l = new LinearLayout(this);
            l.setOrientation(LinearLayout.VERTICAL);
            ScrollView scrollView = new ScrollView(this);
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            l.setY(300);
            l.addView(scrollView);
            scrollView.addView(ll);

            for(Fleur fleur : vectFleursFausses) {
                ImageView img = new ImageView(this);
                img.setImageResource(fleur.getImage());
                img.setVisibility(View.VISIBLE);
                TextView txt = new TextView(this);
                txt.setText("Nom commun : "+fleur.getNomCommun()+"\nNom botanique : "+fleur.getNomBotanique()+"\nFamille : "+fleur.getFamille()+"\n\n\n");
                txt.setVisibility(View.VISIBLE);

                ll.addView(img);
                ll.addView(txt);
            }
            TextView txt2 = new TextView(this);
            txt2.setMinimumHeight(300);
            ll.addView(txt2);

            Button boutonFermer = new Button(this);
            boutonFermer.setText("Retourner à l'accueil");
            boutonFermer.setTextSize(30);
            boutonFermer.setSingleLine(true);
            boutonFermer.setTextColor(Color.BLACK);
            boutonFermer.setVisibility(View.VISIBLE);
            boutonFermer.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            boutonFermer.setY(txvTitle.getY() + 100);
            boutonFermer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    nbEpreuve = 0;
                    noteEpreuve = 0;
                    finish();
                }
            });
            relativeLayout.setGravity(Gravity.CENTER);
            relativeLayout.addView(txvTitle);
            relativeLayout.addView(boutonFermer);
            relativeLayout.addView(l);

            vectFleursFausses.removeAllElements();
        }
    }

    private void changerNumEpreuve() {
        txtNumEpreuve.setText(nbEpreuve+"/20");
        setTitle("Question "+nbEpreuve+"/20");
    }

    private Fleur tirerFleur() {
        metier = Metier.getInstance();
        double random = Math.random();
        int numeroFleur;
        Fleur fleur;
        if (random < 0.8 || metier.getFleursFaites().size()==0) {
            numeroFleur = (int) (Math.random() * metier.getFleursNonFaites().size());
            fleur = metier.getFleursNonFaites().elementAt(numeroFleur);
        } else {
            numeroFleur = (int) (Math.random() * metier.getFleursFaites().size());
            fleur = metier.getFleursFaites().elementAt(numeroFleur);
            if(vectFleursEpreuveCourante.contains(fleur)) {
                fleur = tirerFleur();
            }
        }
        if(!vectFleursEpreuveCourante.contains(fleur))
            vectFleursEpreuveCourante.addElement(fleur);
        if(vectFleursEpreuveCourante.size() == metier.getFleurs().size())
            vectFleursEpreuveCourante.removeAllElements();
        if (!metier.getFleursFaites().contains(fleur)) {
            metier.getFleursFaites().add(fleur);
            metier.getFleursNonFaites().removeElement(fleur);
            stockerNumeroFleur(metier.getFleurs().indexOf(fleur));
        }
        return fleur;
    }

    private void stockerNumeroFleur(int numeroFleur) {
        FileOutputStream output = null;
        try {
            output = openFileOutput("fleurs.txt", MODE_APPEND);
            output.write((numeroFleur + "\n").getBytes());
            if(output != null)
                output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream input = null;
        int count = 0;
        try {
            input = openFileInput("fleurs.txt");
            LineNumberReader l = new LineNumberReader(
                    new BufferedReader(new InputStreamReader(input)));
            while (l.readLine()!=null)
            {
                count = l.getLineNumber();
            }
            if(input != null)
                input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(count >= metier.getFleurs().size()) {
            deleteFile("fleurs.txt");
            metier.reinitFleurs();
        }
    }

    private void changerImage(Fleur fleur) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(fleur.getImage());
    }

    public void sendMessage(View view) {
        String txtCommun = ((EditText)findViewById(R.id.editText)).getText().toString();
        String txtBotanique = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String txtFamille = ((EditText)findViewById(R.id.editText3)).getText().toString();

        Collator compareOperator = Collator.getInstance (Locale.FRENCH);
        compareOperator.setStrength (Collator.PRIMARY);


        if(compareOperator.compare(txtCommun.trim(), fleur.getNomCommun()) == 0
                && compareOperator.compare(txtBotanique.trim(), fleur.getNomBotanique()) == 0
                && compareOperator.compare(txtFamille.trim(), fleur.getFamille().toString())==0)
        {
            noteEpreuve++;
        }
        else
            vectFleursFausses.addElement(fleur);


        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void enregistrerNote() {
        String format = "dd/MM/yy H:mm:ss";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();

        FileInputStream input = null;
        int count = 0;
        try {
            input = openFileInput("notes.txt");
            LineNumberReader l = new LineNumberReader(
                    new BufferedReader(new InputStreamReader(input)));
            while (l.readLine()!=null)
            {
                count = l.getLineNumber();
            }
            if(count >= 100) {
                supprimerPremiereLigne();
            }
            if(input != null)
                input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileOutputStream output = null;
        try {
            output = openFileOutput("notes.txt", MODE_APPEND);
            output.write(((formater.format(date)).toString() + "                   "
                    + noteEpreuve + "/20\n").getBytes());
            if(output != null)
                output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void supprimerPremiereLigne() {
        String texte = "";
        FileInputStream input = null;
        int count = 0;
        try {
            input = openFileInput("notes.txt");
            LineNumberReader l = new LineNumberReader(
                    new BufferedReader(new InputStreamReader(input)));
            l.readLine(); // goto second line
            String str;
            while ((str=l.readLine())!=null)
            {
                texte += str+"\n";
            }
            if(input!=null)
                input.close();
        } catch (Exception error) {
            error.printStackTrace();
        }

        FileOutputStream output = null;
        try {
            deleteFile("notes.txt");
            output = openFileOutput("notes.txt", MODE_APPEND);
            output.write(texte.getBytes());
            if(output != null)
                output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}