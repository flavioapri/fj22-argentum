package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao implements Comparable<Negociacao> {
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("Data nao pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public double getVolume() {
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar outraData) {
		return data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH)
				&& data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH)
				&& data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}

	@Override
	public int compareTo(Negociacao o) {
		if (this.getData().after(o.getData()))
			return 1;

		if (this.getData().before(o.getData()))
			return -1;
		return 0;
	}

}
