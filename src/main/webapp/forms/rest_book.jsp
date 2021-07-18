<%@page import="com.web.rest.bookstore.BookDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Rest Book List</legend>
                <table class="pure-table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>id</th>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <c:forEach varStatus="status" var="book" items="${ BookDao.books }">
                        <tbody>
                            <tr>
                                <td><button type="button" onclick="myfunction('${book.id}','${book.name}','${book.price}')"
                                            >選取</button></td> 
                                <td>${book.id}</td>
                                <td>${book.name}</td>
                                <td>${book.price}</td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>
        <script>
            function myfunction(id, name, price) {
                 document.getElementById('updata_id').value = id;
                document.getElementById('updata_name').value = name;
                document.getElementById('updata_price').value = price;
                document.getElementById('delete_id').value = id;
            }
        </script>
        <table>
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaWeb0531/rest/book">
                    <fieldset>
                        <legend>Rest Book POST</legend>
                        <input name="id" type="text" placeholder="id"><p /> 
                        <input name="name" type="text" placeholder="名稱"><p /> 
                        <input name="price" type="text" placeholder="價格"><p />
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">新增</button>

                    </fieldset>
                </form>
            </td>
            <div class="updata">
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaWeb0531/rest/book">
                    <fieldset>
                        <legend>Rest Book PUT</legend>
                        <input name="_method" type="hidden" value="PUT" />
                        <input name="id" type="text" placeholder="id" id="updata_id"><p /> 
                        <input name="name" type="text" placeholder="名稱" id="updata_name"><p /> 
                        <input name="price" type="text" placeholder="價格" id="updata_price"><p />

                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">修改</button>

                    </fieldset>
                </form>
            </td>
            </div>
            <td valign="top">
                <form class="pure-form"
                      method="post" action="/JavaWeb0531/rest/book">
                    <fieldset>
                        <legend>Rest Book Delete</legend>
                        <input name="_method" type="hidden" value="DELETE" />
                        <input name="id" type="text" placeholder="id" id="delete_id"><p /> 
                        <p />
                        <button type="submit" 
                                class="pure-button pure-button-primary">刪除</button>

                    </fieldset>
                </form>    
            </td>
        </table>
    </body>
</html>