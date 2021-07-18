package br.ufrn.imd.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Linha;

/**
* Classe para manipulação de informações de linhas na base de dados.
*
*/
public class LinhaDao {

    /**
     * Lista todas as linhas cadastradas.
     * @return
     */
    public List<Linha> buscarTodasLinhas() {
        List<Linha> resultado = new ArrayList<Linha>();
        Connection con = GerenciadorConexao.getConexao();
        String sql = "select * from linha";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Linha linha = new Linha();
                linha.setIdent(rs.getString("ident"));
                linha.setOrigem(rs.getString("origem"));
                linha.setDestino(rs.getString("destino"));
                linha.setHoraSaida(rs.getString("hora_saida"));
                linha.setHoraChegada(rs.getString("hora_chegada"));
                resultado.add(linha);
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultado;
        }


    /**
     * Método para realizar a inserção de uma linha no BD.
     * @param linha
     */
    public void inserirLinha(Linha linha) {
        Connection con = GerenciadorConexao.getConexao();
        String sql = "insert into linha values (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, linha.getIdent());
            ps.setString(2, linha.getOrigem());
            ps.setString(3, linha.getDestino());
            ps.setString(4, linha.getHoraSaida());
            ps.setString(5, linha.getHoraChegada());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}