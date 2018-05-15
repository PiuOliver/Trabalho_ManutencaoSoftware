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
import model.Disciplina;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Heleno
 */
public class DisciplinaDao {
    public static List<Disciplina> obterDisciplinas() throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Disciplina> disciplinas = session.createCriteria(Disciplina.class).list();
        session.close();
        return disciplinas;
    }
    
    public static List<Disciplina> obterDisciplinasPorNome(String nome) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Disciplina> disciplinas = session.createQuery("from Disciplina where nome like'%"+nome+"%'").list();
        session.close();
        return disciplinas;
    }
    
    public static List<Disciplina> obterDisciplinasPorCursoENome(int codCurso, String nome) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Disciplina> disciplinas = session.createQuery("from Disciplina where nome like'%"+nome+"%' and codCurso="+codCurso).list();
        session.close();
        return disciplinas;
    }
    
    public static List<Disciplina> obterDisciplinasPorCurso(int codCurso) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Disciplina> disciplinas = session.createQuery("from Disciplina where codCurso="+codCurso).list();
        session.close();
        return disciplinas;
    }
    
    public static Disciplina obterDisciplina(int codDisciplina) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Disciplina disciplina = (Disciplina) session.load(Disciplina.class, codDisciplina);
        session.close();
        return disciplina;
    }
    
    public static void gravarDisciplina(Disciplina disciplina) throws SQLException, ClassNotFoundException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.save(disciplina);
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
    
    public static void editarDisciplina(Disciplina disciplina) throws SQLException, ClassNotFoundException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.update(disciplina);
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
    
    public static void excluirDisciplina(Disciplina disciplina) throws SQLException, ClassNotFoundException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.delete(disciplina);
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
}
