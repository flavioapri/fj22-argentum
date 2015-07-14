package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	private boolean aberturaDefinida;
	private boolean fechamentoDefinido;
	private boolean minimoDefinido;
	private boolean maximoDefinido;
	private boolean volumeDefinido;
	private boolean dataDefinida;

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		aberturaDefinida = true;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		fechamentoDefinido = true;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		minimoDefinido = true;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		maximoDefinido = true;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		volumeDefinido = true;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		dataDefinida = true;
		return this;
	}

	public Candlestick geraCandle() {
		if (!aberturaDefinida || fechamentoDefinido || minimoDefinido || maximoDefinido || volumeDefinido
				|| dataDefinida) {
			throw new IllegalStateException("Todos os métodos do builder devem ser invocados para gerar um candle");
		}
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
