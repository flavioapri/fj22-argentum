package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected = IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		new CandleBuilder().comData(Calendar.getInstance()).geraCandle();
	}

}
