package com.yawlle.kittyquotesjava.infra;

public final class QuoteConstants {
    private  QuoteConstants() {

    }

    public static final class KEY {
        public static final KEY INSTANCE = new KEY();
        public static final String USER_NAME = "USER NAME";

        private KEY() {

        }
    }

    public static final class FILTER {
        public static final FILTER INSTANCE = new FILTER();
        public static final int COMPUTER = 1;
        public static final int ANIME = 2;
        public static final int CODE = 3;

        private FILTER() {
        }
    }
}
