package com.web.rest.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    // 書籍資料庫
    public static List<Book> books = new ArrayList<>();
    //資料庫連線物件
    private static Connection conn;

    static {
        try {
            //資料庫驅動(java.sql.Driver)
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //建立conn物件
            String url = "jdbc:derby://localhost:1527/javaweb";
            String user = "app";
            String password = "app";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
    }

    // 多筆查詢
    public static List<Book> getBooks() {
        books.clear(); //先清空避免重複資料
        String sql = "SELECT id , name ,price ,amount , ts FROM Book";  //要抓取的資料
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            //所抓到的每一筆紀錄 , 要注入到 book 物件中存放
            while (rs.next()) {
                Book book = new Book();  //取得Book的物件
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getInt("price"));
                book.setAmount(rs.getInt("amount"));
                //加入到books集合中
            }
        } catch (Exception e) {
        }

        return books;
    }

    // 單筆查詢
    public static Book getBook(Integer id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .get();
    }

    // 新增
    public static Boolean createBook(Book book) {
        boolean flag = books.stream()
                .filter(b -> b.getId() == book.getId())
                .findAny()
                .isPresent(); //有直存在回傳 ture 反之 false
        if (flag == false) {
            books.add(book);
            return true;
        }
        return false;
    }

    // 修改
    public static Boolean updateBook(Integer id, Book book) {
        // 是否庫存中有此筆資料 ?
        Book oBook = getBook(id);
        if (oBook == null) {
            return false;
        }
        // 將 book 的資料給 oBook
        oBook.setName(book.getName());
        oBook.setPrice(book.getPrice());
        oBook.setAmount(book.getAmount());
        return true;
    }

    // 刪除
    public static Boolean deleteBook(Integer id) {
        // 是否庫存中有此筆資料 ?
        Book oBook = getBook(id);
        if (oBook == null) {
            return false;
        }
        books.remove(oBook);
        return true;
    }
}
