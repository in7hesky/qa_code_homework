package webdriver.icanwinandbringiton.page;

public enum PasteBinExpirationTermins {
    MINUTES_10("10 Minutes"),
    DAYS_1("1 Day");

    private final String terminToLookFor;

    PasteBinExpirationTermins(String terminToLookFor) {
        this.terminToLookFor = terminToLookFor;
    }

    public String getTermin() {
        return this.terminToLookFor;
    }
}
