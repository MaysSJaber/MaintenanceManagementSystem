package Core;

public enum Permissions {

ALL((short)-1),USER_SCREEN((short)1),MECHANIC_SCREEN((short)2),
    CUSTOMER_SCREEN((short)4),VEHICLE_SCREEN((short)8)
,ORDER_SCREEN((short)16);

    private final short enumOptionValue;


    Permissions(short enumOptionValue) {
        this.enumOptionValue = enumOptionValue;
    }

    public int getEnumOptionValue() {
        return enumOptionValue;
    }
}
