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
        Artist andrewBayer = new Artist("Andrew Bayer", "andrew_bayer");
        Artist ilanBluestone = new Artist("Ilan Bluestone", "ilan_bluestone");
        Artist kygo = new Artist("Kygo", "kygo_artist");
        Artist superEightAndTab = new Artist("Super8 & Tab", "super8_and_tab");
        Artist yotto = new Artist("Yotto", "yotto_artist");


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

        Album inMyLastLife = new Album("In My Last Life", andrewBayer, "in_my_last_life");
        inMyLastLife.addSong(new Song("Tidal Wave (feat. Alison May)", 497));
        inMyLastLife.addSong(new Song("Love You More (feat. Ane Brun)", 358));
        inMyLastLife.addSong(new Song("Open End Resource (feat. Alison May)", 353));
        inMyLastLife.addSong(new Song("Hold on to You (feat. Ane Brun)", 318));
        inMyLastLife.addSong(new Song("In My Last Life (feat. Alison May)", 405));
        inMyLastLife.addSong(new Song("Immortal Lover (feat. Alison May)", 364));
        inMyLastLife.addSong(new Song("Your Eyes (feat. Ane Brun)", 398));
        inMyLastLife.addSong(new Song("End of All Things (feat. Alison May)", 586));

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

        Album kidsInLove = new Album("Kids in Love (Re-release)", kygo, "kids_in_love");
        kidsInLove.addSong(new Song("Never Let You Go (feat. John Newman)", 232));
        kidsInLove.addSong(new Song("Sunrise (feat. Jason Walker)", 214));
        kidsInLove.addSong(new Song("Riding Shotgun (with Oliver Nelson feat. Bonnie McKee)", 198));
        kidsInLove.addSong(new Song("Stranger Things (feat. OneRepublic)", 221));
        kidsInLove.addSong(new Song("With You (feat. Wrabel)", 210));
        kidsInLove.addSong(new Song("Kids in Love (feat. The Night Game", 203));
        kidsInLove.addSong(new Song("Permanent (feat. J.Hart", 228));
        kidsInLove.addSong(new Song("I See You (feat. Billy Raffoul", 228));
        kidsInLove.addSong(new Song("Remind Me to Forget (feat. Miguel", 216));

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

        Album hyperfall = new Album("Hyperfall", yotto, "hyperfall_yotto");
        hyperfall.addSong(new Song("Hyperfall", 174));
        hyperfall.addSong(new Song("The One You Left Behind (feat. Vok)", 329));
        hyperfall.addSong(new Song("Kantsu", 298));
        hyperfall.addSong(new Song("Nada C", 182));
        hyperfall.addSong(new Song("Turn It Around", 272));
        hyperfall.addSong(new Song("Epilogue (feat. CAPS)", 322));
        hyperfall.addSong(new Song("Outsight", 284));
        hyperfall.addSong(new Song("Odd One Out", 204));
        hyperfall.addSong(new Song("Hyperlude", 113));
        hyperfall.addSong(new Song("Radiate", 295));
        hyperfall.addSong(new Song("Hear Me Out (feat. Sonin & Laudic)", 282));
        hyperfall.addSong(new Song("Walls", 316));
        hyperfall.addSong(new Song("Waiting Here", 103));


        aboveAndBeyond.addAlbum(commonGround);
        andrewBayer.addAlbum(inMyLastLife);
        ilanBluestone.addAlbum(scars);
        kygo.addAlbum(kidsInLove);
        superEightAndTab.addAlbum(empire);
        yotto.addAlbum(hyperfall);

        for (int i = 1; i <= COUNT; i++) {
            addItem(commonGround, aboveAndBeyond);
            addItem(inMyLastLife, andrewBayer);
            addItem(scars, ilanBluestone);
            addItem(kidsInLove, kygo);
            addItem(empire, superEightAndTab);
            addItem(hyperfall, yotto);
        }
    }

    private static void addItem(Album item, Artist artist) {
        ITEMS_ALBUMS.add(item);
        if (artist != null) {
            ITEMS_ARTISTS.add(artist);
        }
    }
}