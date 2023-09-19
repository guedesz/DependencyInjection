package main;

public class Carro extends Veiculo {

	public int nPortas;
	
	public Carro(String marca, String ano, String modelo, double preco, int nPortas) {
		super(marca, ano, modelo, preco);
		this.nPortas = nPortas;
	}

	public String toString() {
		return "Carro: Marca: " + marca + ", Ano: " + ano + ", Modelo: " + modelo + ", Preço: " + preco + ", Numero de Portas: " + nPortas;
	}
}
