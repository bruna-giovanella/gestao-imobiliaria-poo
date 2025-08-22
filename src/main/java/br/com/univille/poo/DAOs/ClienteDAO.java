package br.com.univille.poo.DAOs;

import br.com.univille.poo.Models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends BaseDAO {

    public void inserir(Cliente cliente) {
        String sql = "insert into cliente (nome, cpf, telefone, email, endereco) values (?,?,?,?,?)";

        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {

            pre.setString(1, cliente.getNome());
            pre.setString(2, cliente.getCpf());
            pre.setString(3, cliente.getTelefone());
            pre.setString(4, cliente.getEmail());
            pre.setString(5, cliente.getEndereco());

            pre.execute();

        } catch (SQLException e) {

            System.out.println("Erro ao inserir");
            System.out.println("erro: "+e.getMessage());

        }
    }

    public void listarClientesComMaisContratos() {
        String sql = "SELECT\n" +
                "            cliente.id,\n" +
                "            cliente.nome,\n" +
                "            COUNT(contrato.id) AS total_contratos\n" +
                "        FROM cliente\n" +
                "        INNER JOIN contrato ON cliente.id = contrato.id_cliente\n" +
                "        GROUP BY cliente.id, cliente.nome\n" +
                "        ORDER BY total_contratos DESC";

        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                int idCliente = rs.getInt("id");
                String nome = rs.getString("nome");
                int totalContratos = rs.getInt("total_contratos");

                System.out.println("ID do Cliente: " + idCliente);
                System.out.println("Nome: " + nome);
                System.out.println("Total de Contratos: " + totalContratos);
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes com mais contratos");
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
