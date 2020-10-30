import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeTest;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class SettingsProviderTest {
    private static Widget widget;
    @Mock
    private ISettingsProvider mockedProvider;
    @Spy
    private SettingsProvider spiedProvider;
    @BeforeClass
    public static void CreateDefaultInstance(){
        widget = new Widget();
    }

    @Before
    public void InjectProvider(){
        MockitoAnnotations.initMocks(this);
        widget.setSettingsProvider(mockedProvider);
        spiedProvider = new SettingsProvider();
    }
    @Test
    public void test1() throws Exception{
        Mockito.when(mockedProvider.getMinimumAllowedReleaseDate()).thenReturn(new Date(0));
        Mockito.doThrow(NullPointerException.class).when(mockedProvider).getReleaseDate();
        Mockito.when(mockedProvider.setDeviceName("IPhone XXS")).thenReturn("IPhone XXS");
        mockedProvider.SetDeviceId(2);
        Mockito.verify(mockedProvider, Mockito.atLeastOnce()).SetDeviceId(2);
        spiedProvider.resetSettings();
        assertEquals(spiedProvider.getReleaseDate(), new Date(0));
    }
    // Mockito позволяет создать объект-заглушку для интерфейса или класса. В случае Mock-объекта, единственное,
    // что будут делать все методы такого объекта, если не определять их поведение, –
    // возвращать значения

    //Помимо этого, Mockito позволяет «шпионить» за реальными объектами. В случае Spy-объекта,
    // по-умолчанию будет исполняться оригинальное поведение методов объекта.
    @Test
    public void test2()throws Exception{
        mockedProvider.resetSettings();
        Mockito.when(mockedProvider.getReleaseDate()).thenReturn( new Date(0));
        Mockito.doThrow(NullPointerException.class).when(mockedProvider).SetDateAsDeviceName();
    }
}
