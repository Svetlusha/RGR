package su.uunit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {

	@Test
	public void test() {
		OknoData dto = new OknoData(12,100,100,0);
		Calc cal = new Calc(dto);
		cal.ras();
		assertEquals(18000000, cal.getStoimost(), 1);
		assertEquals(10000,cal.getArea(),1);
		assertEquals(1500000, cal.getOkno(),1);
	}

}
