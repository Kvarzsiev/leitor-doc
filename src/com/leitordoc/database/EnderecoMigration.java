package com.leitordoc.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.leitordoc.vitals.PostgresConnection;

public class EnderecoMigration {
	
	// Comentar aqui o dia e o horário que a migration for rodada, para mantermos 
	// um registro
	
	public void UpQuery(){
		try {
			PostgresConnection pc = new PostgresConnection();
			Connection c = pc.connect();
			String query = "CREATE TABLE IF NOT EXISTS endereco ("
					+ "	id uuid primary key default gen_random_uuid(),"
					+ "	cep VARCHAR not null,"
					+ "	uf VARCHAR not null,"
					+ "	rua VARCHAR not null,"
					+ "	numero INT not null,"
					+ "	complemento VARCHAR,"
					+ "	bairro VARCHAR not null,"
					+ "	cidade VARCHAR not null,"
					+ "	created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),"
					+ " updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()"
					+ ")";
			Statement st = c.createStatement();
			 st.executeQuery(query);
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void DownQuery(){
		try {
			PostgresConnection pc = new PostgresConnection();
			Connection c = pc.connect();
			String query = "DROP TABLE IF EXISTS public.endereco CASCADE";
			Statement st = c.createStatement();
			st.executeQuery(query);
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
