import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class NgTest1 {
    static Widget _widget;
    static AppleWidget _appleWidget;
    private static int moneyDonated;

    @BeforeClass(groups = { "senseless"})
    public static void CreateDefaultWidget(){
        _widget = new Widget();
    }

    @BeforeClass(groups = { "senseless"})
    public static void CreateDefaultAppleWidget(){
        _appleWidget = new AppleWidget();
    }

    @Test()
    public void defaultState() {
        assertTrue(_widget.isEnabled());
    }

    /**
     * Test droping widget from 0 meters
     */
    @Test()
    public void dropFromZeroMetersNotBreaking() {
        System.out.println("Inside dropFromZeroMetersNotBreaking...............");
        if (this._widget.isBroken())
            assertTrue(true);
        else{
            this._widget.DropFromHeight(0);
            assertFalse(_widget.isBroken());
        }
    }
    /**
     * Test enabling and disabling a {@link Widget}
     */
    @Test(groups = {"useless", "senseless"})
    public void updateEnableState() {
        Widget widget = new Widget();
        widget.setEnabled(false);
        assertFalse(widget.isEnabled());
        widget.setEnabled(true);
        assertTrue(widget.isEnabled());
    }
    /**
     * Test that apple widget is still widget
     */
    @Test(groups = { "senseless"})
    public void appleWidgetIsWidget() {
        //assertThat is so outdated but no one cares about actual info
        //as much outdated and deprecated as JUnit 4
        //instanceOf is hamcrest matcher
        assertThat(_appleWidget, CoreMatchers.instanceOf(Widget.class));
    }

    /**
     * Test constructor creates something
     */
    @Test(groups = {"senseless"})
    public void ensureCreated() {
        assertNotNull(_widget);
        assertNotNull(_appleWidget);
    }
    // diff start
    @DataProvider(name = "moneyDonatedDataProvider")
    public static Object[][] credentials() {
        return new Object[][]{
                {123},
                {456},
                {789},
                {101112}
        };
    }
    // diff end
    @Test(dataProvider = "moneyDonatedDataProvider", groups = {"senseless" } )
    public void appleCompanyGetsYourMoneyParametrized(int moneyDonated) {
        _appleWidget.donate(moneyDonated);
        assertTrue(_appleWidget.GetAmountOfWastedMoney() >= moneyDonated);
    }

    @Test(groups = {"useless", "senseless" })
    public void anythingIsHamcrestAnything() {
        //anything is hamcrest matcher
        assertThat("Is this anything written by me the same as hamcrest anything?", CoreMatchers.anything());
    }

    @Parameters({ "moneyDonated" })
    @Test(groups = {"senseless" })
    public void appleCompanyGetsYourMoney(int moneyDonated) {
        _appleWidget.donate(moneyDonated);
        assertTrue(_appleWidget.GetAmountOfWastedMoney() >= moneyDonated);
    }
}
