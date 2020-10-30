import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests of {@link Widget} class
 */
@RunWith(Parameterized.class)
public class WidgetParametrizedTest {
    static Widget _widget;
    static AppleWidget _appleWidget;
    private static int moneyDonated;

    public WidgetParametrizedTest(int amount){
        moneyDonated = amount;
    }
    @BeforeClass
    public static void CreateDefaultWidget(){
        _widget = new Widget();
    }

    @BeforeClass
    public static void CreateDefaultAppleWidget(){
        _appleWidget = new AppleWidget();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParams(){

        Collection<Object[]> params = new ArrayList<>(0);
        params.add(new Object[] { 4 });
        params.add(new Object[] { 8 });
        params.add(new Object[] { 15 });
        params.add(new Object[] { 16 });
        params.add(new Object[] { 23 });
        params.add(new Object[] { 42 });
        params.add(new Object[] { 1000000 });
        return params;
    }
    /**
     * Test company get ur money a {@link Widget}
     */
    @Test
    public void appleCompanyGetsYourMoney() {
        _appleWidget.donate(moneyDonated);
        assertTrue(_appleWidget.GetAmountOfWastedMoney() >= moneyDonated);
    }
}