package aurelienlv.mementodesfleurs;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Aurélien on 11/10/2015.
 */
public class Fleur {

    private String nomCommun;
    private String nomBotanique;
    private EnumFleurs famille;
    private int image;

    public Fleur(String nomCommun, String nomBotanique, EnumFleurs famille, int image) {
        this.nomCommun = nomCommun;
        this.nomBotanique = nomBotanique;
        this.famille = famille;
        this.image = image;
    }

    public String getNomCommun() {
        return nomCommun;
    }

    public String getNomBotanique() {
        return nomBotanique;
    }

    public EnumFleurs getFamille() {
        return famille;
    }

    public int getImage() {
        return image;
    }
}
