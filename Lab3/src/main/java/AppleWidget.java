
/**
 * Simple wigdet class that can be enabled or disabled
 */
public class AppleWidget extends Widget {
    private int moneyDonated;

    public boolean apply() {
        return false;
    }

    public AppleWidget(){
        super();
        moneyDonated = 0;
    }

    public AppleWidget donate(int amount){
        this.moneyDonated += amount;
        return this;
    }
    public int GetAmountOfWastedMoney(){
        return moneyDonated;
    }
}