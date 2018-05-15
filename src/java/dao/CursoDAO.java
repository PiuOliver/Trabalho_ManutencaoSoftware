/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Heleno
 */
public class CursoDAO {
    public static void gravarCurso(Curso curso) throws SQLException, ClassNotFoundException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.save(curso);
            if (!transaction.wasCommitted())
                 transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
           session.close();
        }  
    }
    
    public static void editarCurso(Curso curso) throws SQLException, ClassNotFoundException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.update(curso);
            if (!transaction.wasCommitted())
                 transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
           session.close();
        }  
    }
    
    public static void excluirCurso(Curso curso) throws SQLException, ClassNotFoundException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.delete(curso);
            if (!transaction.wasCommitted())
                 transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
           session.close();
        }  
    }
    
    public static List<Curso> obterCursos() throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Curso> cursos = session.createCriteria(Curso.class).list();
        session.close();
        return cursos;
    }
    
    public static Curso obterCurso(int codCurso) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Curso curso = (Curso) session.load(Curso.class, codCurso);
        session.close();
        return curso;
    }
}
