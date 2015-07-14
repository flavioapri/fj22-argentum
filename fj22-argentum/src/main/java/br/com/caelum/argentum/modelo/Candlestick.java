package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		if (maximo < minimo) {
			throw new IllegalArgumentException("Preco máximo não pode ser menor que o mínimo");
		}
		if (data == null) {
			throw new IllegalArgumentException("A data não pode ser nula");
		}
		if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) {
			throw new IllegalArgumentException("Os valores não podem ser negativos");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isAlta() {
		if (abertura == fechamento) {
			return true;
		}
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(data.getTime());
		return "Abertura " + abertura + ", Fechamento " + fechamento + ", Mínimo " + minimo + ", Máximo " + maximo
				+ ", Volume " + volume + ", Data " + dataFormatada;
	}
}
