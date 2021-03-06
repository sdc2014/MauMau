package dk.unf.MauMau.network.NetPkg;

/**
 * Created by sdc on 7/15/14.
 */
public interface NetPkg {

    public static final int PKG_CONNECT = 0;
    public static final int PKG_DISCONNECT = 1;
    public static final int PKG_DRAW_CARD = 2;
    public static final int PKG_THROW_CARD = 3;
    public static final int PKG_UPDATE_PLAYER_STATS = 4;
    public static final int PKG_ALLOWED_THROWS = 5;
    public static final int PKG_FACE_CARD = 6;
    public static final int PKG_NEXT_TURN = 7;
    public static final int PKG_HANDSHAKE = 8;
    public static final int PKG_START_GAME = 9;
    public static final int PKG_MAU_MAU_SHAKE = 10;
    public static final int PKG_SET_COLOR = 11;
    public static final int PKG_WON = 12;

    public int getType();

    public String serialize();

}
