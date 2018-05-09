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

    public static List<Turma> obterTurmas() throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        List<Turma> turma = session.createQuery(
                "from turma").list();
        return turma;
    }
    
    public static List<Turma> obterTurma(int codTurma) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        List<Turma> turma = session.createCriteria(Turma.class).list();
        
        return turma;
    }

    
    public static void gravar(Turma turma) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(turma);
        transaction.commit();
    }

    public static void alterar(Turma turma) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(turma);
        transaction.commit();
    }

    public static void excluir(Turma turma) throws ClassNotFoundException, SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(turma);
        transaction.commit(); 
    }

    
}
