public enum NotesAndCoins {
    POUND50(5000,"£50"), POUND20(2000,"£20"),POUND10(1000,"£10"),
    POUND5(500,"£5"), POUND2(200,"£2"), POUND1(100,"£1"),
    PENCE50(50,"50p"),PENCE20(20,"20p"),PENCE10(10,"10p"),
    PENCE5(5,"5p"), PENCE2(2,"2p"),PENCE1(1,"1p");

    //how many pence is each constant worth
    private int valueInP;

    //a user-friendly name for the constant
    private String name;

    //add constructors and getters for valueInP and
    NotesAndCoins(int valueInP, String name) {
        this.valueInP = valueInP;
        this.name = name;
    }

    public int getValueInP() {
        return valueInP;
    }

    public void setValueInP(int valueInP) {
        this.valueInP = valueInP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
