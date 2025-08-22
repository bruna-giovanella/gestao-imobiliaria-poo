package br.com.univille.poo.DAOs;

import br.com.univille.poo.Models.Contrato;

import java.math.BigDecimal;
import java.sql.*;

public class ContratoDAO extends BaseDAO {

    public void inserir(Contrato contrato) {
        String sql = "insert into contrato(id_imovel, id_cliente, valor_aluguel, data_inicio,data_fim, ativo) values (?,?,?,?,?,?)";

        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {

            pre.setLong(1, contrato.getImovelId());
            pre.setLong(2, contrato.getClienteId());
            pre.setBigDecimal(3, contrato.getValorAluguel());
            pre.setDate(4, contrato.getDataInicio());
            pre.setDate(5, contrato.getDataFim());
            pre.setBoolean(6, true);

            pre.execute();

        } catch (SQLException e) {

            System.out.println("Erro ao inserir");
            System.out.println("erro: "+e.getMessage());

        }
    }
    public void pegarContratosAtivos() {
        String sql = "SELECT * FROM contrato WHERE ativo = 1";

        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int idImovel = rs.getInt("id_imovel");
                int idCliente = rs.getInt("id_cliente");
                BigDecimal valorAluguel = rs.getBigDecimal("valor_aluguel");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataFim = rs.getDate("data_fim");

                System.out.println("ID do Contrato: " + id);
                System.out.println("ID do Imóvel: " + idImovel);
                System.out.println("ID do Cliente: " + idCliente);
                System.out.println("Valor do Aluguel: R$ " + valorAluguel);
                System.out.println("Data de Início: " + dataInicio);
                System.out.println("Data de Fim: " + dataFim);
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar contratos ativos");
            System.out.println("Erro: " + e.getMessage());
        }
    }
    public void listarContratosExpirando() {
        String sql = "SELECT \n" +
                "            contrato.id,\n" +
                "            contrato.id_cliente,\n" +
                "            contrato.id_imovel,\n" +
                "            contrato.valor_aluguel,\n" +
                "            contrato.data_inicio,\n" +
                "            contrato.data_fim\n" +
                "        FROM contrato\n" +
                "        WHERE data_fim BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY)";

        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                int idContrato = rs.getInt("id");
                int idCliente = rs.getInt("id_cliente");
                int idImovel = rs.getInt("id_imovel");
                BigDecimal valor = rs.getBigDecimal("valor_aluguel");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataFim = rs.getDate("data_fim");

                System.out.println("ID do Contrato: " + idContrato);
                System.out.println("ID do Cliente: " + idCliente);
                System.out.println("ID do Imóvel: " + idImovel);
                System.out.println("Valor do Aluguel: R$ " + valor);
                System.out.println("Início: " + dataInicio);
                System.out.println("Fim: " + dataFim);
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar contratos expirando");
            System.out.println("Erro: " + e.getMessage());
        }
    }


}
