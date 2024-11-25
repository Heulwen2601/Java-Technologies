package org.example.lab05.DAO;

import org.example.lab05.HibernateUtils;
import org.example.lab05.Models.Product;
import org.hibernate.Session;
import java.util.List;

public class ProductDAO implements Reposity<Product, Integer> {

    @Override
    public Integer add(Product item) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            Integer productID = (Integer) session.save(item);
            session.getTransaction().commit();
            return productID;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("FROM Product", Product.class).list();
            session.getTransaction().commit();
            return productList;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Product get(Integer id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Product product = session.find(Product.class,id);
            session.getTransaction().commit();
            return product;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(Product item) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(Product item) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeById(Integer id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            Product product = session.find(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
