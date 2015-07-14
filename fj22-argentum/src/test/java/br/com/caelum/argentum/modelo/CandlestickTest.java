package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 20, 20, 10, 1000, Calendar.getInstance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void dataNaoPodeSerNula() {
		new Candlestick(10, 20, 20, 30, 1000, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void valoresNaoPodemSerNegativos() {
		new Candlestick(-10, -5, 0, 0, -1000, Calendar.getInstance());
	}

	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candlestick candlestick = new Candlestick(10, 10, 20, 30, 200, Calendar.getInstance());

		assertEquals(true, candlestick.isAlta());
	}

}
