package br.com.univille.poo.DAOs;

import br.com.univille.poo.Models.Imovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImovelDAO extends BaseDAO {

    public void inserir(Imovel imovel) {
        String sql = "insert into imovel (endereco, tipo, quartos, banheiros, descricao, disponivel) values (?,?,?,?,?,?)";

        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {


            pre.setString(1, imovel.getEndereco());
            pre.setString(2, imovel.getTipo());
            pre.setInt(3, imovel.getQuartos());
            pre.setInt(4, imovel.getBanheiros());
            pre.setString(5, imovel.getDescricao());
            pre.setBoolean(6, true);

            pre.execute();

        } catch (SQLException e) {

            System.out.println("Erro ao inserir");
            System.out.println("erro: "+e.getMessage());

        }
    }
    public void pegarDisponiveis() {
        String sql = "SELECT * FROM imovel WHERE disponivel = 1";

        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String endereco = rs.getString("endereco");
                String tipo = rs.getString("tipo");
                int quartos = rs.getInt("quartos");
                int banheiros = rs.getInt("banheiros");
                String descricao = rs.getString("descricao");
                boolean disponivel = rs.getBoolean("disponivel");

                System.out.println("ID: " + id);
                System.out.println("Endereço: " + endereco);
                System.out.println("Tipo: " + tipo);
                System.out.println("Quartos: " + quartos);
                System.out.println("Banheiros: " + banheiros);
                System.out.println("Descrição: " + descricao);
                System.out.println("Disponível: " + disponivel);
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar imóveis disponíveis");
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
