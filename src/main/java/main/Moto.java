package main;

public class Moto extends Veiculo {

	public int cilindradas;
	public Moto(String marca, String ano, String modelo, double preco, int cilindradas) {
		super(marca, ano, modelo, preco);
		this.cilindradas = cilindradas;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Moto: Marca: " + marca + ", Ano: " + ano + ", Modelo: " + modelo + ", Preço: " + preco + ", Cilindradas: " + cilindradas;
	}

}
