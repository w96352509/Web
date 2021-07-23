-- 計算每種書籍價值, 佔比
SELECT b."NAME", SUM(b.PRICE * b.AMOUNT) as subtotal, 
SUM(b.PRICE * b.AMOUNT) as percent

FROM BOOK b
GROUP BY b."NAME";

-- 全部書籍總價值 ?
select SUM(b.PRICE * b.AMOUNT) as total from book b


