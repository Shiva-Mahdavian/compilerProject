public enum Color {
    Blue("#000080"),
    Violate("#660E7A"),
    LightBlue("#0000FF"),
    LightYellow("#808000"),
    Green("#008000"),
    Gray("#808080"),
    Black("#000000")
    ;
    private String val;

    Color(String val) {
        this.val = val;
    }

    public String getVal() {
        return this.val;
    }
}
