package dao;

import java.sql.SQLException;
import java.util.List;
import model.Avaliacao;
import model.AvaliacaoId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AvaliacaoDao {

    public static void gravarAvaliacao(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.save(avaliacao);
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

    public static void editarAvaliacao(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.update(avaliacao);
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

    public static void excluirAvaliacao(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            session.delete(avaliacao);
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

    public static List<Avaliacao> obterAvaliacoesPorAluno(int matricula) throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Avaliacao> avaliacoes = session.createQuery("from Avaliacao where matriculaAluno=" + matricula).list();
        session.close();
        return avaliacoes;
    }

    public static List<Avaliacao> obterAvaliacoesPorTurma(int codTurma) throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Avaliacao> avaliacoes = session.createQuery("from Avaliacao where codTurma=" + codTurma).list();
        session.close();
        return avaliacoes;
    }

    public static Avaliacao obterAvaliacao(AvaliacaoId avaliacaoId) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Avaliacao avaliacao = (Avaliacao) session.load(Avaliacao.class, avaliacaoId);
        session.close();
        return avaliacao;
    }
}
