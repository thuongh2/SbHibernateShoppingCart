package com.example.sbhibernateshoppingcart.dao;

import com.example.sbhibernateshoppingcart.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Product findProduct(String code){
        try{
            String sql = "SELECT e from "+Product.class.getName() +" e Where e.code= :code";

            Session session = this.sessionFactory.getCurrentSession();
            Query<Product> query = session.createQuery(sql, Product.class);
            query.setParameter("code", code);
            return (Product) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    public ProductInfo findProductInfo(String code){
        Product product = this.findProduct(code);
        if(product == null){
            return null;
        }

    }
}
