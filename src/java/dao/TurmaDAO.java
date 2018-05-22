/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import model.Turma;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gabrieldeoliveira
 */
public class TurmaDAO {
    
    static Turma turma = null;
    static List<Turma> turmas = null;
    static Session session = null;
    static Transaction transaction = null;

    public static List<Turma> obterTurmas() throws ClassNotFoundException, SQLException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Turma> turma = null;
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            turma = session.createQuery(
                "from turma").list();
            if (!transaction.wasCommitted())
                 transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
           session.close();  
           return turma;
        }  
    }
    
    public static List<Turma> obterTurma(int codTurma) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.clear();
        List<Turma> turma = session.createCriteria(Turma.class).list();
        session.close();
        return turma;
    }

    
    public static void gravar(Turma turma) throws ClassNotFoundException, SQLException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.save(turma);
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

    public static void alterar(Turma turma) throws ClassNotFoundException, SQLException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.update(turma);
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

    public static void excluir(Turma turma) throws ClassNotFoundException, SQLException{
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.delete(turma);
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
