package main;

import java.io.*;
import java.util.*;

public class ArquivoArmazenamento implements Armazenamento {

	private String nomeArquivo;
	private List<Veiculo> lista = new ArrayList<>();
	public ArquivoArmazenamento(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public List<Veiculo> GetVeiculos() {
		// TODO Auto-generated method stub
		List<Veiculo> veiculos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;

			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(": ");
				if (partes.length == 2) {
					String tipoVeiculo = partes[0];
					String[] atributos = partes[1].split(", ");

					if (tipoVeiculo.equals("Carro")) {
						String marca = atributos[0];
						String ano = atributos[1];
						String modelo = atributos[2];
						double preco = Double.parseDouble(atributos[3]);
						int nPortas = Integer.parseInt(atributos[4]);

						Carro carro = new Carro(marca, ano, modelo, preco, nPortas);
						veiculos.add(carro);
					} else if (tipoVeiculo.equals("Moto")) {
						String marca = atributos[0];
						String ano = atributos[1];
						String modelo = atributos[2];
						double preco = Double.parseDouble(atributos[3]);
						int cilindradas = Integer.parseInt(atributos[4]);

						Moto moto = new Moto(marca, ano, modelo, preco, cilindradas);
						veiculos.add(moto);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error getting veiculos");
		}

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.toString());
		}

		return veiculos;
	}

	@Override
	public void SetCarro(String marca, String ano, String modelo, double preco, int nPortas) {
		// TODO Auto-generated method stub
		
		Carro newCarro = new Carro(marca, ano, modelo, preco, nPortas);

		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(this.nomeArquivo, true));
		    writer.write( "Carro: " + newCarro.marca + ", " + newCarro.ano + ", " + newCarro.modelo + ", " + newCarro.preco + ", " + newCarro.nPortas);
		    writer.newLine();
		    writer.flush();
		    System.out.println("Nova instância adicionada em um arquivo!");
		} catch (IOException e) {
		    System.out.println("Error");
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.print("Error inserting new entry");
			}
		}
	}
	@Override
	public void SetMoto(String marca, String ano, String modelo, double preco, int cilindradas) {
		// TODO Auto-generated method stub
		
		Moto newMoto = new Moto(marca, ano, modelo, preco, cilindradas);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(this.nomeArquivo, true));
			writer.write( "Moto: " + newMoto.marca + ", " + newMoto.ano + ", " + newMoto.modelo + ", " + newMoto.preco + ", " + newMoto.cilindradas);
			writer.newLine();
			writer.flush();
			System.out.println("Nova instância adicionada em um arquivo!");
		} catch (IOException e) {
			System.out.println("Error");
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.print("Error inserting new entry");
			}
		}
	}
	
}
