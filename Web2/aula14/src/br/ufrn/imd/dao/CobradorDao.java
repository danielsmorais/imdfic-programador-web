package br.ufrn.imd.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Cobrador;

/**
* Classe para manipulação de informações de cobradores na base de dados.
*
*/
public class CobradorDao {

    /**
     * Lista todos os cobradores cadastrados.
     * @return
     */
    public List<Cobrador> buscarTodosCobradores() {
        List<Cobrador> resultado = new ArrayList<Cobrador>();
        Connection con = GerenciadorConexao.getConexao();
        String sql = "select * from cobrador";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cobrador cobrador = new Cobrador();
                cobrador.setCpf(rs.getString("cpf"));
                cobrador.setEndereco(rs.getString("endereco"));
                cobrador.setMatricula(rs.getString("matricula"));
                cobrador.setNome(rs.getString("nome"));
                resultado.add(cobrador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    /**
     * Método para realizar a inserção de um cobrador no BD.
     * @param cobrador
     */
    public void inserirCobrador(Cobrador cobrador) {
        Connection con = GerenciadorConexao.getConexao();
        String sql = "insert into cobrador values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cobrador.getNome());
            ps.setString(2, cobrador.getCpf());
            ps.setString(3, cobrador.getMatricula());
            ps.setString(4, cobrador.getEndereco());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}