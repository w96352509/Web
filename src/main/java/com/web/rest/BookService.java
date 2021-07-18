package com.web.rest;

import com.web.rest.bookstore.Book;
import com.web.rest.bookstore.BookDao;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/book")
public class BookService{
//取得book所有資料
    @Path("/")
    @GET //因要取得網址訊息使用GET
    @Produces("text/plain")
    public String getBooks() {
        
        return BookDao.getBooks().toString();
    }
    //取得book單筆資料
    @Path("/{id}")
    @GET //因要取得網址訊息使用GET
    @Produces("text/plain")
    public String getBook(@PathParam("id") Integer id) {
        return BookDao.getBook(id).toString();
    }
    
    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)  //因用post取得表單需要編碼
    @Produces(MediaType.TEXT_PLAIN)
    public Response createBook(@FormParam("id") Integer id, 
                             @FormParam("name") String name,
                             @FormParam("price") Integer price) {
        Book book = new Book(id, name, price);
        if(BookDao.createBook(book)) {
            // 重導指定頁面
            URI location = URI.create("http://localhost:8080/JavaWeb0531/forms/rest_book.jsp");
            return Response.temporaryRedirect(location).build();
        } else {
            return Response.status(500).build();
        }
        //return BookDao.createBook(book).toString();
    }
    
    @Path("/")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBook(@FormParam("id") Integer id, 
                             @FormParam("name") String name,
                             @FormParam("price") Integer price) {
        Book book = new Book(id, name, price);
        return BookDao.updateBook(id, book).toString();
    }
    
    @Path("/")
    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@FormParam("id") Integer id) {
        return BookDao.deleteBook(id).toString();
    }

    
}