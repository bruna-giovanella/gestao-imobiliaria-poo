package br.com.univille.poo;

import br.com.univille.poo.DAOs.ClienteDAO;
import br.com.univille.poo.DAOs.ContratoDAO;
import br.com.univille.poo.DAOs.ImovelDAO;

public class App {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
//        Cliente cliente = new Cliente("Bruna", "13256047980", "47999609561", "brugiovanella@gmail.com", "Estrada do Oeste, Pirabeiraba");
//
//        clienteDAO.inserir(cliente);
//
        ImovelDAO imovelDAO = new ImovelDAO();
//        Imovel imovel = new Imovel("Pirabeiraba, Joinville", "Apartamento", 3, 3, "Apartamento grande, novo, lindo");
//
//        imovelDAO.inserir(imovel);


//        Contrato contrato = new Contrato(1L, 1L, BigDecimal.ONE, Date.valueOf("1999-01-01"), Date.valueOf("1999-01-01"));

        ContratoDAO contratoDAO = new ContratoDAO();
//        contratoDAO.inserir(contrato);


        contratoDAO.listarContratosExpirando();

    }
}
