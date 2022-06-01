
package com.emerII.dao;
import com.emerII.modelo.Seminario;
import com.emerII.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDAOimpl extends ConexionDB implements SeminarioDAO{

    @Override
    public void insert(Seminario seminario) throws Exception {
         String sql = "insert into seminarios (titulo,fecha,cupo) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, seminario.getTitulo());
        ps.setDate(2, seminario.getFecha());
        ps.setInt(3, seminario.getCupo());
       
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Seminario seminario) throws Exception {
        String sql = "update seminarios set titulo=?,fecha=?,cupo=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, seminario.getTitulo());
        ps.setDate(2, seminario.getFecha());
        ps.setInt(3, seminario.getCupo());
        ps.setInt(4, seminario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from seminarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate(); }

    @Override
    public Seminario getById(int id) throws Exception {
        Seminario cli = new Seminario();
        String sql = "select * from seminarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            cli.setId(rs.getInt("id"));
            cli.setTitulo(rs.getString("tirulo"));
            cli.setFecha(rs.getDate("fecha"));
            cli.setCupo(rs.getInt("cupo"));
            
        }
        this.desconectar();
        return cli;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
             List<Seminario> lista = null;
        String sql = "select * from seminarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Seminario>();
        while (rs.next()) {            
            Seminario cli = new Seminario();
            cli.setId(rs.getInt("id"));
            cli.setTitulo(rs.getString("titulo"));
            cli.setFecha(rs.getDate("fecha"));
            cli.setCupo(rs.getInt("cupo"));
            lista.add(cli);
        }
        this.desconectar();
        return lista;
    }
    
}
