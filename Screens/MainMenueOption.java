package Screens;

public enum MainMenueOption {

    USER_MENUE((short)1),MECHANIC_MENUE((short) 2),
    CUSTOMER_MENUE((short)3),
    VEHICLE_MENUE((short)4),ORDER_MENUE((short)5),LOGOUT((short)6);

    private final short enumOptionValue;

    MainMenueOption(short enumOptionValue) {
        this.enumOptionValue = enumOptionValue;
    }

    public short getEnumOptionValue() {
        return enumOptionValue;
    }
}
