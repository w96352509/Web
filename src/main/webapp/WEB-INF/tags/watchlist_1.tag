<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="symbols" required="true" rtexprvalue="true"%>
<table class="pure-table">
    <thead>
        <tr>
            <th>#</th>
            <th>商品代號</th>
            <th>商品</th>
            <th>買價</th>
            <th>賣價</th>
            <th>漲幅</th>
            <th>漲跌</th>
            <th>成交量</th>
            <th>開盤</th>
            <th>最高</th>
            <th>最低</th>
            <th>價差</th>
            <th>昨收</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach varStatus="status" var="symbol" items="${fn:split(symbols, ',')}">
            <jsp:useBean class="com.web.tag.utils.MyStock1" id="myStock" />
            <jsp:setProperty name="myStock" property="symbol" value="${ symbol }" />

            <tr ${ status.index % 2 == 0 ? "class=\"pure-table-odd\"" : "" } >
                <td>${ status.index }</td>
                <td>${ symbol }</td>
                <td>${myStock.name }</td>
                <td>${myStock.bid}</td>
                <td>${myStock.ask}</td>
                <td style="color: ${myStock.color}">${myStock.change}%</td>
                <td>${(myStock.bid-myStock.open)/myStock.open/100}</td>
                <td>${myStock.volume.intValue()}</td>
                <td>${myStock.open}</td>
                <td>${myStock.hight}</td>
                <td>${myStock.low}</td>
                <td>${(myStock.open - myStock.colse).floatValue()}</td>
                <td>${myStock.colse}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>