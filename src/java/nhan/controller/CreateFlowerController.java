/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhan.util.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "CreateFlowerController", urlPatterns = {"/CreateFlowerController"})
public class CreateFlowerController extends HttpServlet {

    private static final String SUCCESS = "search.jsp";
    private static final String ERROR = "error.jsp";
    private static final String XML_FILE = "/WEB-INF/garden.xml";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("txtId");
            String name = request.getParameter("txtName");
            String description = request.getParameter("txtDescription");
            String txtQuantity = request.getParameter("txtQuantity");
            String txtPrice = request.getParameter("txtPrice");
            String txtSeason = request.getParameter("txtSeason");
            String realPath = getServletContext().getRealPath("/");
            String filePath = realPath + XML_FILE;
            Document document = XMLUtils.parseFileToDom(filePath);
            if (document != null) {
                Element flowerElement = document.createElement("flower");
                flowerElement.setAttribute("id", id);
                flowerElement.setAttribute("isAvailable", "true");
                
                Element nameElement = document.createElement("name");
                nameElement.setTextContent(name);
                Element descriptionElement = document.createElement("description");
                descriptionElement.setTextContent(description);
                Element quantity = document.createElement("quantity");
                quantity.setTextContent(txtQuantity);
                Element price = document.createElement("price");
                price.setTextContent(txtPrice);
                Element season = document.createElement("season");
                season.setAttribute("name", txtSeason);
                flowerElement.appendChild(nameElement);
                flowerElement.appendChild(descriptionElement);
                flowerElement.appendChild(quantity);
                flowerElement.appendChild(price);
                flowerElement.appendChild(season);
                
                NodeList garden = document.getElementsByTagName("garden");
                if (garden != null && garden.getLength() > 0) {
                    garden.item(0).appendChild(flowerElement);
                    XMLUtils.transformDOMToResult(document, filePath);
                    url = SUCCESS;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
