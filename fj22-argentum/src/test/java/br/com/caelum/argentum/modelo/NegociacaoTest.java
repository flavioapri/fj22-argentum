package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {
		// se criar um negocio no dia 15...
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao negociacao = new Negociacao(10, 5, data);

		// ainda que eu tente mudar para o dia 20...
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);

		// ele continua no dia 15.
		assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10, 5, null);
	}

	@Test
	public void mesmoMilisegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();

		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}

	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		GregorianCalendar manha = new GregorianCalendar(2015, 10, 20, 8, 30);
		GregorianCalendar tarde = new GregorianCalendar(2015, 10, 20, 15, 30);

		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		assertTrue(negociacao.isMesmoDia(tarde));
	}

	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		GregorianCalendar mes1 = new GregorianCalendar(2015, 11, 20, 8, 30);
		GregorianCalendar mes2 = new GregorianCalendar(2015, 10, 20, 15, 30);

		Negociacao negociacao = new Negociacao(40.0, 100, mes1);
		assertFalse(negociacao.isMesmoDia(mes2));
	}

	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		GregorianCalendar ano1 = new GregorianCalendar(2014, 10, 20, 8, 30);
		GregorianCalendar ano2 = new GregorianCalendar(2015, 10, 20, 15, 30);

		Negociacao negociacao = new Negociacao(40.0, 100, ano1);

		assertFalse(negociacao.isMesmoDia(ano2));
	}
}
