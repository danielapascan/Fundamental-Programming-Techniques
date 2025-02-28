package BusinessLogic;
import DataAccess.ProductDAO;
import Model.Products;

import javax.swing.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductBLL {
    private ProductDAO productDAO;

    public ProductBLL() {
        productDAO = new ProductDAO();
    }

    public Products findProductById(int id) {
        Products st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return st;
    }

    public void deleteById(int id) {
        int st = productDAO.deleteById(id);
        if (st == 0) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
    }
    public void insertProduct(Products c) {
        int cr=productDAO.insert(c);
        if (cr == 0) {
            throw new NoSuchElementException("The product cannot be inserted!");
        }
    }

    public void updateProduct(Products c) {
        int cr=productDAO.update(c);
        if (cr == 0) {
            throw new NoSuchElementException("The product cannot be updated!");
        }
    }
    public ArrayList<Products> findallProducts() {
        ArrayList<Products> products= new ArrayList<>();
        products= productDAO.findAll();
        if (products == null) {
            throw new NoSuchElementException("The tabel was not found!");
        }
        return products;
    }
    public JTable makeTableProducts()
    {
        JTable t = new JTable();
        ArrayList<Products> products= new ArrayList<>();
        products= productDAO.findAll();
        t=productDAO.makeTable(products);
        return t;
    }
}
