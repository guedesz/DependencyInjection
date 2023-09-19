package main;

import java.util.List;

public interface Armazenamento {
	public void SetCarro(String marca, String ano, String modelo, double preco, int nPortas);
	public void SetMoto(String marca, String ano, String modelo, double preco, int cilindradas);
	
	public List<Veiculo> GetVeiculos();

}
