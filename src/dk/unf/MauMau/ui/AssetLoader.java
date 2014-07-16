package dk.unf.MauMau.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import dk.unf.MauMau.Card;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdc on 7/15/14.
 */
public class AssetLoader {

    public final static int HEARTS_ID = 0;
    public final static int CLUBS_ID = 1;
    public final static int SPADES_ID = 2;
    public final static int DIAMONDS_ID = 3;
    private Map<Integer, Bitmap> heartsBitmaps = new HashMap<Integer, Bitmap>();
    private Map<Integer, Bitmap> clubsBitmaps = new HashMap<Integer, Bitmap>();
    private Map<Integer, Bitmap> spadesBitmaps = new HashMap<Integer, Bitmap>();
    private Map<Integer, Bitmap> diamondsBitmaps = new HashMap<Integer, Bitmap>();

    public void load(Context context) {
        for (int j = 6; j < 13; j++) {
            for (int k = 0; k < 4; k++) {
                Bitmap bitmap = getBitmapFromAsset(context,  "c" + j + getLetter(k)+".png");
                System.out.println("c" + j + getLetter(k)+".png");
                bitmap = scaleDown(bitmap, 200, true);
                switch (k) {
                    case HEARTS_ID:
                        heartsBitmaps.put(j, bitmap);
                        break;
                    case CLUBS_ID:
                        clubsBitmaps.put(j, bitmap);
                        break;
                    case SPADES_ID:
                        spadesBitmaps.put(j, bitmap);
                        break;
                    case DIAMONDS_ID:
                        diamondsBitmaps.put(j, bitmap);
                        break;
                }
            }
        }

    }


    public Bitmap getCard(int cardValue, int cardColor) {
        switch (cardColor) {
            case HEARTS_ID:
                return heartsBitmaps.get(cardValue);
            case CLUBS_ID:
                return clubsBitmaps.get(cardValue);
            case SPADES_ID:
                return spadesBitmaps.get(cardValue);
            case DIAMONDS_ID:
                return diamondsBitmaps.get(cardValue);
            default:
                Log.e("Mau", "Something went very wrong");
                return null;
        }
    }


    private static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            // handle exception
        }

        return bitmap;
    }

    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                maxImageSize / realImage.getWidth(),
                maxImageSize / realImage.getHeight());
        int width = Math.round(ratio * realImage.getWidth());
        int height = Math.round(ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }

    private char getLetter(int index) {
        switch (index) {
            case HEARTS_ID:
                return 'h';
            case CLUBS_ID:
                return 'c';
            case SPADES_ID:
                return 's';
            case DIAMONDS_ID:
                return 'd';
            default:
                Log.e("Mau", "Something went very wrong");
                return 'F';
        }
    }
}
