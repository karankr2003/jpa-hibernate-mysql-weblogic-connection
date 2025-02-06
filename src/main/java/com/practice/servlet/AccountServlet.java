package com.practice.servlet;

import com.practice.entity.SavingsAccount;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   EntityManagerFactory emf = Persistence.createEntityManagerFactory("SavingsAccountPU");

    public AccountServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EntityManager em = emf.createEntityManager(); 
        
        Query query = em.createQuery("SELECT a FROM SavingsAccount a");
        List<SavingsAccount> accounts = query.getResultList();

        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        em.close();
    }
    
}
