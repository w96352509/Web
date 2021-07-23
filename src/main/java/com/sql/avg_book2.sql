SELECT b."NAME", SUM(b.PRICE * b.AMOUNT) as subtotal,
       SUM(b.AMOUNT) as amount, 
       SUM(b.PRICE * b.AMOUNT) / SUM(b.AMOUNT) as avg_price
FROM BOOK b
GROUP BY b."NAME"


