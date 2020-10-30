import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Unit tests of {@link Widget} class
 */
public class WidgetTest {
    static Widget _widget;
    static AppleWidget _appleWidget;
    private static int moneyDonated;

    @BeforeClass
    public static void CreateDefaultWidget(){
        _widget = new Widget();
    }

    @BeforeClass
    public static void CreateDefaultAppleWidget(){
        _appleWidget = new AppleWidget();
    }
    /**
     * Test default enable state of {@link Widget}
     */
    @Test
    public void defaultState() {
        assertTrue(_widget.isEnabled());
    }

    /**
     * Test droping widget from 0 meters
     */
    @Test
    public void dropFromZeroMetersNotBreaking() {
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
    @Test
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
    @Test
    public void appleWidgetIsWidget() {
        //assertThat is so outdated but no one cares about actual info
        //as much outdated and deprecated as JUnit 4
        //instanceOf is hamcrest matcher
        assertThat(_appleWidget, CoreMatchers.instanceOf(Widget.class));
    }

    /**
     * Test constructor creates something
     */
    @Test
    public void ensureCreated() {
        assertNotNull(_widget);
        assertNotNull(_appleWidget);
    }
    /**
     * Test emty array is "empty by definition of Hamcrest"
     */
    @Test
    public void anythingIsHamcrestAnything() {
        //anything is hamcrest matcher
        assertThat("Is this anything written by me the same as hamcrest anything?", CoreMatchers.anything());
    }
}