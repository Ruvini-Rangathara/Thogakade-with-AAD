package lk.ijse.thogakade.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.thogakade.model.ItemModel;
import lk.ijse.thogakade.to.ItemTo;

import java.io.IOException;

public class ItemServlet extends HttpServlet {;

    ItemModel itemModel;

    String code;

    @Override
    public void init() throws ServletException {
        itemModel = new ItemModel();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemTo itemTo = itemModel.search(req.getParameter("id"));
        System.out.println(itemTo.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemTo itemTo = new ItemTo();

        itemTo.setCode(req.getParameter("code"));
        itemTo.setDescription(req.getParameter("description"));
        itemTo.setUnitPrice(Double.parseDouble(req.getParameter("unitPrice")));
        itemTo.setQtyOnHand(Integer.parseInt(req.getParameter("qtyOnHand")));

        if (itemModel.save(itemTo)){
            System.out.println("Item saved.");
        }else{
            System.out.println("Item not saved.");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemTo itemTo = new ItemTo();

        itemTo.setCode(req.getParameter("code"));
        itemTo.setDescription(req.getParameter("description"));
        itemTo.setUnitPrice(Double.parseDouble(req.getParameter("unitPrice")));
        itemTo.setQtyOnHand(Integer.parseInt(req.getParameter("qtyOnHand")));

        if (itemModel.update(itemTo)){
            System.out.println("Item updated.");
        }else{
            System.out.println("Item not updated.");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.code = req.getParameter("code");
        ItemTo item = itemModel.search(this.code);

        if (item != null){
            System.out.println("Item that you want to delete : "+item.toString());
        }else{
            System.out.println("Item not found.");
        }

        if(itemModel.delete(item)){
            System.out.println("Item deleted.");
        }else{
            System.out.println("Something went wrong.");
        }

    }
}
