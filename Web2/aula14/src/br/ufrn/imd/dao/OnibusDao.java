package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Cobrador;
import br.ufrn.imd.model.Empresa;
import br.ufrn.imd.model.Linha;
import br.ufrn.imd.model.Motorista;
import br.ufrn.imd.model.Onibus;

/**
* Classe para manipulação de informações de onibus na base de dados.
*
*/
public class OnibusDao {

    /**
     * Lista todos os ônibus cadastrados.
     * @return
     */
    public List<Onibus> buscarTodosOnibus() {
        List<Onibus> resultado = new ArrayList<Onibus>();
        Connection con = GerenciadorConexao.getConexao();
        String sql = "select * from onibus";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Onibus onibus = new Onibus();
                onibus.setAno(rs.getInt("ano"));
                onibus.setMarca(rs.getString("marca"));
                onibus.setModelo(rs.getString("modelo"));

                Cobrador cobrador = new Cobrador();
                cobrador.setNome(rs.getString("nome_cobrador"));
                onibus.setCobrador(cobrador);

                Motorista motorista = new Motorista();
                motorista.setNome(rs.getString("nome_motorista"));
                onibus.setMotorista(motorista);

                Empresa empresa = new Empresa();
                empresa.setRazaoSocial(rs.getString("razao_social_empresa"));
                onibus.setEmpresa(empresa);

                Linha linha = new Linha();
                linha.setIdent(rs.getString("ident_linha"));
                onibus.setLinha(linha);

                resultado.add(onibus);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultado;
        }


    /**
     * Método para realizar a inserção de um ônibus no BD.
     * @param onibus
     */
    public void inserirOnibus(Onibus onibus) {
        Connection con = GerenciadorConexao.getConexao();
        String sql = "insert into onibus values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, onibus.getMarca());
            ps.setString(2, onibus.getModelo());
            ps.setInt(3, onibus.getAno());
            ps.setString(4, onibus.getEmpresa().getRazaoSocial());
            ps.setString(5, onibus.getLinha().getIdent());
            ps.setString(6, onibus.getCobrador().getNome());
            ps.setString(7, onibus.getMotorista().getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}