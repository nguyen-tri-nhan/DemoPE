/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import nhan.dto.Flower;
import nhan.handler.FlowerHandler;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {
    private static final String XML_FILE = "/WEB-INF/garden.xml";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            FlowerHandler flowerHandler = new FlowerHandler();
            
            String realPath = getServletContext().getRealPath("/");
            String filePath = realPath + XML_FILE;
            String txtFrom = request.getParameter("txtFrom");
            String txtTo = request.getParameter("txtTo");
            
            
            SAXParserFactory saxpf = SAXParserFactory.newInstance();
            SAXParser saxParser = saxpf.newSAXParser();
            
            saxParser.parse(filePath, flowerHandler);
            
            float from = Float.parseFloat(txtFrom);
            float to = Float.parseFloat(txtTo);
            
            List<Flower> flowers = searchFlowersPriceToPrice(flowerHandler.getFlowers(), from, to);
            
            request.setAttribute("FLOWERS", flowers);
     
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }
    }
    
    private List<Flower> searchFlowersPriceToPrice(List<Flower> list, float from, float to) {
        
        return list.stream()
                .filter(flower -> flower.getPrice() >= from && flower.getPrice() <= to)
                .collect(Collectors.toList());
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
