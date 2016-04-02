package aurelienlv.mementodesfleurs;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class ToutActivity extends ActionBarActivity {

    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tout);

        setTitle("Memento des fleurs");
        relativeLayout = (RelativeLayout) findViewById(R.id.layoutTout);

        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(this);
        GridLayout ll = new GridLayout(this);
        ll.setColumnCount(3);
        l.setY(100);
        l.addView(scrollView);
        scrollView.addView(ll);

        for(Fleur fleur : Metier.getInstance().getFleurs()) {
            LinearLayout rl = new LinearLayout(this);
            rl.setOrientation(LinearLayout.VERTICAL);
            ImageView img = new ImageView(this);
            img.setImageResource(fleur.getImage());
            img.setVisibility(View.VISIBLE);
            TextView txt = new TextView(this);
            txt.setText("Nom commun : "+fleur.getNomCommun()+"\nNom botanique : "+fleur.getNomBotanique()+"\nFamille : "+fleur.getFamille()+"\n\n\n");
            txt.setVisibility(View.VISIBLE);

            rl.addView(img);
            rl.addView(txt);
            ll.addView(rl);
        }

        TextView t = new TextView(this);
        t.setText("\n\n\n\n\n");
        ll.addView(t);

        TextView t2 = new TextView(this);
        t2.setText("\n\n\n\n\n");
        ll.addView(t2);

        TextView t3 = new TextView(this);
        t3.setText("\n\n\n\n\n");
        ll.addView(t3);

        Button boutonFermer = new Button(this);
        boutonFermer.setText("Retourner à l'accueil");
        boutonFermer.setTextSize(30);
        boutonFermer.setSingleLine(true);
        boutonFermer.setTextColor(Color.BLACK);
        boutonFermer.setVisibility(View.VISIBLE);
        boutonFermer.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        boutonFermer.setY(10);
        boutonFermer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(boutonFermer);
        relativeLayout.addView(l);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
