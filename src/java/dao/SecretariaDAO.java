/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Professor;
import model.Secretaria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author gabrieldeoliveira
 */
public class SecretariaDAO {

    public static List<Secretaria> obterSecretaria(String kurz, String senha) {
        Transaction tx = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Secretaria> secretaria = null;
        try {
            Transaction transaction = session.beginTransaction();
            tx = session.getTransaction();
            secretaria = session.createQuery("from secretaria where kurz = "+kurz+" AND senha = "+senha).list();
            
            if (!transaction.wasCommitted())
                 transaction.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
           session.close();
           return secretaria;
        }  
        
    }
    
}
