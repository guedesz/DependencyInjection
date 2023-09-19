package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoArmazenamento implements Armazenamento {

	private String url = "jdbc:sqlite:armazenamento.db";

	@Override
	public void SetCarro(String marca, String ano, String modelo, double preco, int nPortas) {
		// TODO Auto-generated method stub
		
		Carro carro = new Carro(marca, ano, modelo, preco, nPortas);

		Connection connection = null;

		try {
			// Crie a conexão com o banco de dados
			connection = DriverManager.getConnection(this.url);

			// Crie uma instrução SQL de inserção
			String sql = "INSERT INTO carros (marca, ano, modelo, preco, nPortas) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, marca);
			preparedStatement.setString(2, ano);
			preparedStatement.setString(3, modelo);
			preparedStatement.setDouble(4, preco);
			preparedStatement.setInt(5, nPortas);

			// Execute a instrução SQL
			preparedStatement.executeUpdate();

			// Feche a instrução e a conexão
			System.out.println("Novo carro criado com sucesso!");
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void SetMoto(String marca, String ano, String modelo, double preco, int cilindradas) {
		// TODO Auto-generated method stub
		Moto moto = new Moto(marca, ano, modelo, preco, cilindradas);

		Connection connection = null;

		try {
			// Crie a conexão com o banco de dados
			connection = DriverManager.getConnection(this.url);

			// Crie uma instrução SQL de inserção
			String sql = "INSERT INTO motos (marca, ano, modelo, preco, cilindradas) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, marca);
			preparedStatement.setString(2, ano);
			preparedStatement.setString(3, modelo);
			preparedStatement.setDouble(4, preco);
			preparedStatement.setInt(5, cilindradas);

			// Execute a instrução SQL
			preparedStatement.executeUpdate();

			// Feche a instrução e a conexão
			System.out.println("Nova moto criada com sucesso!");
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Veiculo> GetVeiculos() {
		List<Veiculo> veiculos = new ArrayList<>();

		Connection connection = null;

		try {
			// Crie a conexão com o banco de dados
			connection = DriverManager.getConnection(url);

			// Crie a consulta SQL para recuperar os dados
			String sql = "SELECT * FROM motos"; // Substitua pelo nome da sua tabela

			// Execute a consulta
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			// Processar os resultados da consulta
			while (resultSet.next()) {
				String marca = resultSet.getString("marca");
				String ano = resultSet.getString("ano");
				String modelo = resultSet.getString("modelo");
				double preco = resultSet.getDouble("preco");
				int cilindradas = resultSet.getInt("cilindradas");

				Moto moto = new Moto(marca, ano, modelo, preco, cilindradas);
				veiculos.add(moto);
			}

			// Consulta carros
			String carros = "SELECT * FROM carros"; // Substitua pelo nome da sua tabela

			// Execute a consulta
			PreparedStatement preparedStatement2 = connection.prepareStatement(carros);
			ResultSet resultSet2 = preparedStatement2.executeQuery();

			// Processar os resultados da consulta
			while (resultSet2.next()) {
				String marca = resultSet2.getString("marca");
				String ano = resultSet2.getString("ano");
				String modelo = resultSet2.getString("modelo");
				double preco = resultSet2.getDouble("preco");
				int nPortas = resultSet2.getInt("nPortas");

				Carro carro = new Carro(marca, ano, modelo, preco, nPortas);
				veiculos.add(carro);
			}

			// Feche a consulta e a conexão
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.toString());
		}

		return veiculos;

	}
}
