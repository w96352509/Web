package com.web.rest.bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    //書籍資料庫

    public static List<Book> books = new ArrayList<>();

    //多筆查詢
    public static List<Book> getBooks() {
        return books;
    }
    //單筆查詢

    public static Book getBook(Integer id) {
        return books.stream().filter(b -> b.getId() == id)
                .findFirst().get();
    }

    //新增
    public static Boolean createBook(Book book) {
        books.add(book);
        return true;
    }

    //刪除
    public static Boolean deleteBook(Integer id, Book book) {
        //是否庫存中有資料
        Book oBook = getBook(id); //oBook元庫存中
        if (oBook == null) {
            return false;
        }
        books.remove(oBook);
        return true;
    }

    //修改
    public static Boolean updateBook(Integer id, Book book) {
        //是否庫存中有資料
        Book oBook = getBook(id); //oBook元庫存中
        if (oBook == null) {
            return false;
        }
        // 將新book 的資料給 oBook
        oBook.setName(book.getName());
        oBook.setPrice(book.getPrice());
        return true;
    }
}
