package br.ufrn.imd.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Motorista;

/**
* Classe para manipulação de informações de motoristas na base de dados.
*
*/
public class MotoristaDao {

    /**
     * Lista todos os motoristas cadastrados.
     * @return
     */
    public List<Motorista> buscarTodosMotoristas() {
        List<Motorista> resultado = new ArrayList<Motorista>();
        Connection con = GerenciadorConexao.getConexao();
        String sql = "select * from motorista";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Motorista motorista = new Motorista();
                motorista.setCpf(rs.getString("cpf"));
                motorista.setEndereco(rs.getString("endereco"));
                motorista.setMatricula(rs.getString("matricula"));
                motorista.setNome(rs.getString("nome"));
                motorista.setRegistroCnh(rs.getString("registro_cnh"));
                motorista.setCategoriaCnh(rs.getString("categoria_cnh"));
                resultado.add(motorista);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultado;
        }


    /**
     * Método para realizar a inserção de um motorista no BD.
     * @param motorista
     */
    public void inserirMotorista(Motorista motorista) {
        Connection con = GerenciadorConexao.getConexao();
        String sql = "insert into motorista values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, motorista.getNome());
            ps.setString(2, motorista.getCpf());
            ps.setString(3, motorista.getMatricula());
            ps.setString(4, motorista.getEndereco());
            ps.setString(5, motorista.getRegistroCnh());
            ps.setString(6, motorista.getCategoriaCnh());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}