package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String imageUrl = getImageUrlByCategory(category);
        response.setContentType("text/html");
        response.getWriter().println("<html>    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n<head></head><body><h1>Image for Category: " + category + "</h1>");
        response.getWriter().println("<img src='" + imageUrl + "' alt='Image' width='500px' height='300px' /><br>");
        response.getWriter().println("<a href='index.html' style='font-size: 20px;'>Back</a><br>"); // измененный размер кнопки
        response.getWriter().println("</body></html>");
    }

    private String getImageUrlByCategory(String category) {
        switch (category) {
            case "nature":
                return "https://img.razrisyika.ru/kart/32/1200/125972-peyzazhi-prirody-20.jpg";  // Изображение природы
            case "cars":
                return "https://a.d-cd.net/RwAAAgH2keA-1920.jpg";  // Изображение автомобиля
            case "kids":
                return "https://static.zerochan.net/Shounen.Tanteidan.full.726954.jpg";  // Изображение детей
            default:
                return "https://sun9-37.userapi.com/impg/DTu4yE4ABfTLaySzF1OZZw8tJ1qW7pp81Hr7PA/3I6hAIDJdqg.jpg?size=1080x852&quality=96&sign=997e893390458a3fa3b1a63c8bb89512&c_uniq_tag=9WaFk25eiV17mu1EXGAJWKL0lq7akCCBMLPEwcIH8W0&type=album";  // Изображение по умолчанию
        }
    }

}
