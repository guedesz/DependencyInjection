package main;
import java.util.List;
public class Main {

	public static void main(String[] args) {

		DB.CreateDB DB = new DB.CreateDB();

		ArquivoArmazenamento arquivoA = new ArquivoArmazenamento("arquivo");
		BancoArmazenamento bancoB = new BancoArmazenamento();

		Concessionaria c = new Concessionaria(arquivoA);
		
		c.SetCarro("test","2023" , "test2", 124, 4);
		c.SetMoto("Test", "2022", "Test2", 100, 300);

		List<Veiculo> lista = c.GetVeiculos();

	}

}
