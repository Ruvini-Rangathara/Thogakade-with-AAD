package lk.ijse.thogakade.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakade.model.CustomerModel;
import lk.ijse.thogakade.to.CustomerTo;

import java.io.IOException;

public class CustomerServlet extends HttpServlet {

    CustomerModel customerModel;

    String id;

    @Override
    public void init() {
        customerModel = new CustomerModel();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerTo customerTo = customerModel.search(req.getParameter("id"));
        System.out.println(customerTo.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerTo customerTo = new CustomerTo();

        customerTo.setId(req.getParameter("id"));
        customerTo.setName(req.getParameter("name"));
        customerTo.setAddress(req.getParameter("address"));
        customerTo.setSalary(Double.parseDouble(req.getParameter("salary")));

        if (customerModel.save(customerTo)){
            System.out.println("Customer saved.");
        }else{
            System.out.println("Customer not saved.");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerTo customerTo = new CustomerTo();

        customerTo.setId(req.getParameter("id"));
        customerTo.setName(req.getParameter("name"));
        customerTo.setAddress(req.getParameter("address"));
        customerTo.setSalary(Double.parseDouble(req.getParameter("salary")));

        if (customerModel.update(customerTo)){
            System.out.println("Customer updated.");
        }else{
            System.out.println("Customer not updated.");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.id = req.getParameter("id");
        CustomerTo customerTo = customerModel.search(this.id);

        if (customerTo != null){
            System.out.println("Customer that you want to delete : "+customerTo.toString());
        }else{
            System.out.println("Customer not found.");
        }

        if(customerModel.delete(customerTo)){
            System.out.println("Customer deleted.");
        }else{
            System.out.println("Something went wrong.");
        }

    }
}
