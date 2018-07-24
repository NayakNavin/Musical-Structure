package com.example.android.musicalstructure.ui.sample;

import com.example.android.musicalstructure.ui.models.Album;
import com.example.android.musicalstructure.ui.models.Artist;
import com.example.android.musicalstructure.ui.models.Song;

import java.util.ArrayList;
import java.util.List;

public class SampleContent {

    public static final List<Album> ITEMS_ALBUMS = new ArrayList<>();
    public static final List<Artist> ITEMS_ARTISTS = new ArrayList<>();


    private static final int COUNT = 1;


    static {

        Artist aboveAndBeyond = new Artist("Above & Beyond", "above_and_beyond");
        Artist ilanBluestone = new Artist("Ilan Bluestone", "ilan_bluestone");
        Artist superEightAndTab = new Artist("Super8 & Tab", "super8_and_tab");


        Album commonGround = new Album("Common Ground", aboveAndBeyond, "common_ground");
        commonGround.addSong(new Song("The Inconsistency Principle", 196));
        commonGround.addSong(new Song("My Own Hymn (feat. Zoë Johnston)", 228));
        commonGround.addSong(new Song("Northern Soul (feat. Richard Bedford)", 335));
        commonGround.addSong(new Song("Naked (feat. Justine Suissa)", 323));
        commonGround.addSong(new Song("Sahara Love (feat. Zoë Johnston)", 307));
        commonGround.addSong(new Song("Happiness Amplified (feat. Richard Bedford)", 332));
        commonGround.addSong(new Song("Is It Love (1001)", 344));
        commonGround.addSong(new Song("Cold Feet (featuring Justine Suissa)", 335));
        commonGround.addSong(new Song("Tightrope (featuring Marty Longstaff)", 204));
        commonGround.addSong(new Song("Alright Now (feat. Justine Suissa)", 337));
        commonGround.addSong(new Song("Bittersweet & Blue (feat. Richard Bedford)", 326));
        commonGround.addSong(new Song("Always (feat. Zoë Johnston)", 250));
        commonGround.addSong(new Song("Common Ground", 212));


        Album scars = new Album("Scars", ilanBluestone, "scars_ilan");
        scars.addSong(new Song("Scars (feat. Giuseppe De Luca)", 295));
        scars.addSong(new Song("Frozen Ground (feat. Giuseppe De Luca)", 222));
        scars.addSong(new Song("Everybody (with Maor Levi)", 330));
        scars.addSong(new Song("Rival (feat. Ellen Smith)", 260));
        scars.addSong(new Song("Noa", 258));
        scars.addSong(new Song("Guru", 215));
        scars.addSong(new Song("Let Me Know (feat. Giuseppe De Luca)", 230));
        scars.addSong(new Song("Will We Remain? (with Maor Levi feat. EL Waves)", 308));
        scars.addSong(new Song("I Believe (feat. Giuseppe De Luca)", 205));
        scars.addSong(new Song("43+86=129 (with Sunny Lax)", 247));
        scars.addSong(new Song("Not Alone", 322));
        scars.addSong(new Song("Cosmic Feeling (feat. Giuseppe De Luca)", 236));
        scars.addSong(new Song("Another Lover (feat. Koven)", 213));
        scars.addSong(new Song("Blue Angel", 359));
        scars.addSong(new Song("Eclipse", 230));

        Album empire = new Album("Empire (Bonus Track Version)", superEightAndTab, "empire_super8_tab");
        empire.addSong(new Song("Slow to Learn (feat. Jan Burton)", 410));
        empire.addSong(new Song("Empire (feat. Jan Burton)", 401));
        empire.addSong(new Song("Black Is the New Yellow (feat. Anton Sonin)", 409));
        empire.addSong(new Song("My Enemy (feat. Julie Thompson)", 346));
        empire.addSong(new Song("Perfect Day (feat. Alyna)", 313));
        empire.addSong(new Song("Eternal Sequence", 351));
        empire.addSong(new Song("Good Times (feat. Betsie Larkin)", 411));
        empire.addSong(new Song("Mercy (feat. Jan Burton)", 450));
        empire.addSong(new Song("Irufushi", 350));
        empire.addSong(new Song("Bliss", 246));
        empire.addSong(new Song("Free Love (feat. Jan Burton)", 245));
        empire.addSong(new Song("Helektra (Bonus Track)", 582));


        aboveAndBeyond.addAlbum(commonGround);
        ilanBluestone.addAlbum(scars);
        superEightAndTab.addAlbum(empire);


        for (int i = 1; i <= COUNT; i++) {
            addItem(commonGround, aboveAndBeyond);
            addItem(scars, ilanBluestone);
            addItem(empire, superEightAndTab);

        }
    }

    private static void addItem(Album item, Artist artist) {
        ITEMS_ALBUMS.add(item);
        if (artist != null) {
            ITEMS_ARTISTS.add(artist);
        }
    }
}