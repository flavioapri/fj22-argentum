package br.com.caelum.argentum.reader;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carreagaXMLComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list> <negociacao> <preco>43.5</preco> <quantidade>1000</quantidade> "
				+ "<data> <time>1322233344455</time> </data> </negociacao> </list>";
		LeitorXML leitor = new LeitorXML();
		ByteArrayInputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);

		assertEquals(1, negociacoes.size());
		assertEquals(43.5, negociacoes.get(0).getPreco(), 0.00001);
		assertEquals(1000, negociacoes.get(0).getQuantidade());
	}

	@Test
	public void carregaXMLComZeroNegociacoes() {
		String xmlDeTeste = "<list> </list>";
		LeitorXML leitor = new LeitorXML();
		ByteArrayInputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);

		assertEquals(0, negociacoes.size());
	}

	@Test
	public void carregaXMLComPrecoQuantidadeFaltando() {
		String xmlDeTeste = "<list> <negociacao> <data> <time>1322233344455</time> </data> </negociacao></list>";
		LeitorXML leitor = new LeitorXML();
		ByteArrayInputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);

		assertEquals(0, negociacoes.get(0).getPreco(), 0.00001);
		assertEquals(0, negociacoes.get(0).getQuantidade());
	}

	@Test
	public void carregaXMLComMaisDeUmaNegociacao() {
		String xmlDeTeste = "<list> <negociacao> <preco>43.5</preco> <quantidade>1000</quantidade> "
				+ "<data> <time>1322233344455</time> </data> </negociacao> <negociacao> <preco>43.5</preco> <quantidade>1000</quantidade> "
				+ "<data> <time>1322233344455</time> </data> </negociacao> <negociacao> <preco>43.5</preco> <quantidade>1000</quantidade> "
				+ "<data> <time>1322233344455</time> </data> </negociacao> <negociacao> <preco>43.5</preco> <quantidade>1000</quantidade> "
				+ "<data> <time>1322233344455</time> </data> </negociacao> </list>";
		LeitorXML leitor = new LeitorXML();
		ByteArrayInputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);

		assertEquals(4, negociacoes.size());
	}
}
