package enumtest;

public enum YesOrNo {
    YES("y", "1", true),
    NO("n", "0", false);

    private String value1;
    private String value2;
    private boolean value3;

    YesOrNo(String value1, String value2, boolean value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public boolean isValue3() {
        return value3;
    }
}
