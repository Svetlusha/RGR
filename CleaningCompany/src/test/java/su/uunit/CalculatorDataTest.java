package su.uunit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorDataTest {

	@Test
	public void test() {
		
		OknoData example = new OknoData(10,12,12,0);
		example.setDopolnenieRUB(44);
		
		assertEquals(44,example.getDopolnenieRUB(),1);
	}
}