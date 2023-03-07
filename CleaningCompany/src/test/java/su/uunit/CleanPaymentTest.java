package su.uunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;



public class CleanPaymentTest {

	@Test
	public void onlyNumberTextFieldTest() {
		JFXPanel fxPanel = new JFXPanel();
		TextField tf = new TextField();
		CleanPayment.onlyNumberTextField(tf);
		tf.setText("1");
		tf.setText("s");
		tf.setText("!");
		tf.setText("ь");
		tf.setText("/");
		assertEquals("1", tf.getText());
	}

}
