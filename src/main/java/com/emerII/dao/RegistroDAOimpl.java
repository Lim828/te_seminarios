
package com.emerII.dao;
import com.emerII.modelo.Registro;
import com.emerII.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAOimpl extends ConexionDB implements RegistroDAO{

    @Override
    public void insert(Registro registro) throws Exception {
        String sql = "insert into participantes (apellidos,nombres,id_seminario,confirmado) values (?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, registro.getNombres());
        ps.setString(2, registro.getApellidos());
        ps.setInt(3, registro.getId_seminario());
        ps.setInt(4, registro.getConfirmado());
        
        
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Registro registro) throws Exception {
        String sql = "update participantes set apellidos=?,nombres=?,id_seminario=?,confirmado=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, registro.getNombres());
        ps.setString(2, registro.getApellidos());
        ps.setInt(3, registro.getId_seminario());
        ps.setInt(4, registro.getConfirmado());
        ps.setInt(5, registro.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from participantes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Registro getById(int id) throws Exception {
        Registro cli = new Registro();
        String sql = "select * from participantes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            cli.setId(rs.getInt("id"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setId_seminario(rs.getInt("id_seminario"));
            cli.setConfirmado(rs.getInt("confirmado"));
        }
        this.desconectar();
        return cli;
    }

    @Override
    public List<Registro> getAll() throws Exception {
          List<Registro> lista = null;
        String sql = "select * from participantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Registro>();
        while (rs.next()) {            
            Registro cli = new Registro();
            cli.setId(rs.getInt("id"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setId_seminario(rs.getInt("id_seminario"));
            cli.setConfirmado(rs.getInt("confirmado"));
            lista.add(cli);
        }
        this.desconectar();
        return lista;
    }
    
}
