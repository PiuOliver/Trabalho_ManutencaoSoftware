package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Avaliacao;

public class ConsultarNotaFrequenciaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        
        
        try {

            int matricula = Integer.parseInt(request.getParameter("matricula"));
            if (acao.equals("prepararOperacao")) {
                List<Avaliacao> avaliacoes = Avaliacao.obterAvaliacoesPorAluno(matricula);
                request.setAttribute("avaliacoes", avaliacoes);
            } else {
                if (acao.equals("confirmarOperacao")) {
                    String pesqisa = request.getParameter("pesquisa");
                    if (pesqisa.equals("Todas")) {
                        List<Avaliacao> avaliacoes = Avaliacao.obterAvaliacoesPorAluno(matricula);
                        request.setAttribute("avaliacoes", avaliacoes);
                    } else {
                        int ano = Integer.parseInt(request.getParameter("ano"));
                        int semestre = Integer.parseInt(request.getParameter("semestre"));
                        List<Avaliacao> avaliacoes = Avaliacao.obterAvaliacoesPorAnoSemestre(ano, semestre, matricula);
                        request.setAttribute("avaliacoes", avaliacoes);
                    }
                }
            }


            Aluno aluno = Aluno.obterAluno(matricula);
            request.setAttribute("aluno", aluno);

            RequestDispatcher janela = request.getRequestDispatcher("/consultarNotaFrequencia.jsp");
            janela.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
