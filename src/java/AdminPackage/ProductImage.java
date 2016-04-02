/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

//import com.beans.Book;
import HibernateEntity.Product;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdalla
 */
@WebServlet(name = "ProductImage", urlPatterns = {"/productImage"})
public class ProductImage extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


// ex:: <img src="../productImage?imageName=${book.getBFrontImg()}"  /> 
// in book class:: static public final String uplodedImgFolderDestntion = "C:/Book_Shop/images/";
//-----------------------------------------------------------------------------------------------
        response.setContentType("image/jpeg");
        String imageName = request.getParameter("imageName");
        int thumbWidth = 350;
        int thumbHeight = 460;
//        String pathToWeb = "C:/Book_Shop/images/";//getServletContext().getRealPath("/");
        File f = new File(Product.uplodedImgFolderDestntion + "/" + imageName);
        System.out.println(f.getAbsolutePath());
        Image image = ImageIO.read(f);

        BufferedImage thumb = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = thumb.createGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, thumbWidth, thumbHeight);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

        OutputStream out = response.getOutputStream();
        ImageIO.write(thumb, "jpg", out);
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
