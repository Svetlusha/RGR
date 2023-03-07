package su.uunit;

import static org.junit.Assert.*;
import org.junit.Test;

public class OknoDataTest {

    @Test
    public void equalsStingTest() {
        OknoData str = new OknoData(10,5,5,0);
        String str2 = str.toString();
        String str1 = "Количество окон = 10\n"
        + "Дополнительная плата = 0.0 руб.\n"
        + "Высота окон = 5.0 м.\n"
        + "Ширина окон = 5.0м.\n\n";
        assertEquals(str1, str2);
    }
}