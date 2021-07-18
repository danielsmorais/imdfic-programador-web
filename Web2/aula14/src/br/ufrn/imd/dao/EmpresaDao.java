package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Empresa;

/**
* Classe para manipulação de informações das empresas na base de dados.
*
*/
public class EmpresaDao {

    /**

     * Lista todas as empresas cadastradas.
     * @return
     */
    public List<Empresa> buscarTodasEmpresas() {
        List<Empresa> resultado = new ArrayList<Empresa>();
        Connection con = GerenciadorConexao.getConexao();
        String sql = "select * from empresa";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setRazaoSocial(rs.getString("razao_social"));
                resultado.add(empresa);
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        return resultado;
        }


    /**
     * Método para realizar a inserção de uma empresa no BD.
     * @param empresa
     */
    public void inserirEmpresa(Empresa empresa) {
        Connection con = GerenciadorConexao.getConexao();
        String sql = "insert into empresa values (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empresa.getRazaoSocial());
            ps.setString(2, empresa.getCnpj());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}