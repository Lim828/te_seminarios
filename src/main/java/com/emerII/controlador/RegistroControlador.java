
package com.emerII.controlador;

import com.emerII.dao.RegistroDAO;
import com.emerII.dao.RegistroDAOimpl;
import com.emerII.modelo.Registro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "RegistroControlador", urlPatterns = {"/RegistroControlador"})
public class RegistroControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            RegistroDAO dao = new RegistroDAOimpl();
            Registro cli = new Registro();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("registro", cli);
                    request.getRequestDispatcher("frmregistro.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli = dao.getById(id);
                    request.setAttribute("registro", cli);
                    request.getRequestDispatcher("frmregistro.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("RegistroControlador");
                    break;
                case "view":
                    List<Registro> lista = dao.getAll();
                    request.setAttribute("registros", lista);
                    request.getRequestDispatcher("registros.jsp").forward(request, response);
                    break;                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           int id = Integer.parseInt(request.getParameter("id"));

        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int id_seminario = Integer.parseInt(request.getParameter("id_seminario"));
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));
         
        Registro cli = new Registro();
        cli.setId(id);
        cli.setNombres(nombres);
        cli.setApellidos(apellidos);
        cli.setId_seminario(id_seminario);
        cli.setConfirmado(confirmado);
        
       
        RegistroDAO dao = new RegistroDAOimpl();
        
            if (id == 0) {
            try {
                // Nuevo
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: "  + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
        
        response.sendRedirect("RegistroControlador");
    }

}
