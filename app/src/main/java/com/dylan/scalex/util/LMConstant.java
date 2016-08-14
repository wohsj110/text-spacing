package com.dylan.scalex.util;

import android.util.SparseArray;

/**
 * Used to define constant values
 */
public class LMConstant {

    /*PROXIMA NOVA FONT*/
    public static final int FONT_STYLE_REGULAR = 0;
    public static final int FONT_STYLE_SEMIBOLD = 1;
    public static final int FONT_STYLE_BOLD = 2;
    public static final int FONT_STYLE_LIGHT = 3;
    public static final int FONT_STYLE_BLACK = 4;
    public static final int FONT_STYLE_THIN = 5;


    public static final SparseArray<String> FONT_STYLES = new SparseArray<String>() {
        {
            append(FONT_STYLE_REGULAR, "ProximaNova-Regular.otf");
            append(FONT_STYLE_SEMIBOLD, "ProximaNova-Semibold.otf");
            append(FONT_STYLE_BOLD, "ProximaNova-Bold.otf");
            append(FONT_STYLE_LIGHT, "ProximaNova-Light.otf");
            append(FONT_STYLE_BLACK, "ProximaNova-Black.otf");
            append(FONT_STYLE_THIN, "ProximaNova-Thin.otf");
        }
    };
    // No breaking space letter
    public static final String NON_BREAKING_SPACE = "\u00A0";
    /*END PROXIMA NOVA FONT*/

    public static final String URL_IMAGE = "http://www.langitmusik.co.id/image.do?fileuid=%s";

    public static class Explore{
        public static final int MAX_DISPLAY_EVENT_PLAYLIST = 5;
        public static final int MAX_DISPLAY_SIMILAR_FAV_ARTIST = 3;
        public static final int MAX_DISPLAY_RECOMMENDED_PLAYLIST = 5;
    }
    public static class PLAYBACK {
        public static final int REPEAT_ONE = 0;
        public static final int REPEAT_ALL = 1;
        public static final int PLAY_ONE_TIME = 2;
    }
    //PLAYBACK
    public final static int PLAYBACK_DJ_STEP_TIME = 300;//in millisecond
    public final static int PLAYBACK_DJ_STEP_VIEW_SIZE = 1;//in pixel
    public final static int PLAYBACK_DJ_MIN_LAYOUT_SIZE = 90;//in pixel
    public final static int PLAYBACK_DJ_MAX_LAYOUT_SIZE = 220;//in pixel
    public static final String ACTION_PLAYING_TIME = "com.langit_musik.playing.time";
    public static final String MEDIA_PLAYER_CURRENT_TIME = "media_player_current_time";
    public static final String MEDIA_PLAYER_SONG_CHANGED = "media_player_song_changed";
    public static final String MEDIA_PLAYER_STARTED = "media_player_started";
    public static final String MEDIA_PLAYER_START_TIME = "0.00";
    public static final String NOTIFICATION_TOUCHED = "notification_touched";
    public static final String MEDIA_PLAYER_FOCUS = "media_player_focus";
    public static final String MEDIA_PLAYER_FOCUS_DATA = "media_player_focus_data";
    public static final int NOTIFY_ID = 1;
    //
    public static final String ACTION_SEND_DOWNLOAD_LIST = "com.langit.musik.action.download.list";
    public static final String DOWNLOAD_LIST = "com.langit.musik.download.list";
    public static final String ACTION_SEND_SONG_STATE = "com.langit.musik.action.song.state";
    public static final String SONG_STATE = "com.langit.musik.song.state";
    public static final String ACTION_CURRENT_PLAYING_SONG = "com.langit.musik.playing.song";
    public static final String CURRENT_PLAYING_SONG = "current.playing.song";
    public static final String CURRENT_DOWNLOAD_LIST = "current.download.list";
    public static final int BROADCAST_TIME_PERIOD = 1000;//IN MILLISECOND
    //
    public final static int PAGES = 5;
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

    public final static int COMMON_VIEW_TYPE_ARTIST = 1;
    public final static int COMMON_VIEW_TYPE_ALBUM = 2;
    public final static int COMMON_VIEW_TYPE_SONG = 3;
    public final static int COMMON_VIEW_TYPE_PLAYLIST = 4;

    public final static String ARTIST_SHARING_URL = "http://www.langitmusik.co.id/artist_detail/";
    public final static String ALBUM_SHARING_URL = "http://www.langitmusik.co.id/album_detail/";
    public final static String PLAYLIST_SHARING_URL = "http://www.langitmusik.co.id/playlist_detail/";
    public final static String SONG_SHARING_URL = "http://www.langitmusik.co.id/song/";

    public static final String FACEBOOK_APP_PACKAGE_NAME = "com.facebook.katana";
    public static final String FACEBOOK_BROWER_PACKAGE_NAME = "com.facebook.com";
    public static final String FACEBOOK_CANCEL_CODE = "4201";
    public static final String TWITTER_APP_PACKAGE_NAME = "com.twitter.android";
    public static final int FACEBOOK_PROVIDER = 111;
    public static final int TWITTER_PROVIDER = 222;

    // MAPI
    public static final String SIGN_UP_SUCCESS_CODE = "1";
    public static final String BINDED_EXISTING_MOBILE_USER_INFO = "2";
    public static final String USER_STATUS_A = "A";

    public static final String CODE_EA001 = "EA001";
    public static final String CODE_EA002 = "EA002";
    public static final String CODE_EA003 = "EA003";
    public static final String CODE_EA004 = "EA004";
    public static final String CODE_EC990 = "EC990";
    public static final String EMAIL_CONDITION = "E";
    public static final String MSISDN_CONDITION = "M";
    public static final String NICKNAME = "N";

    // Folder name
    public static final String FOLDER_APP = ".LangitOffline";
    public static final String FOLDER_IMAGE = ".Image";
    public static final String DOWNLOAD_IMAGE_NAME = "%s.jpg";
    public static final long FREE_SPACE_FOR_SONG = 1024 * 3; // 3Mbs
}