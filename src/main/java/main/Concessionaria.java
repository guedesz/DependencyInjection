package main;

import java.util.List;

public class Concessionaria {

	private Armazenamento armazenamento;
	
	public Concessionaria(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public List<Veiculo> GetVeiculos() {
		return this.armazenamento.GetVeiculos();
	}
	
	public void SetCarro(String marca, String ano, String modelo, double preco, int nPortas) {
		this.armazenamento.SetCarro(marca, ano, modelo, preco, nPortas);
	}
	
	public void SetMoto(String marca, String ano, String modelo, double preco, int cilindradas) {
		this.armazenamento.SetMoto(marca, ano, modelo, preco, cilindradas);
	}
	
	
	
}
