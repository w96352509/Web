select b."NAME" , b.AMOUNT,
sum(b.PRICE*b.AMOUNT/b.AMOUNT) as 平均成本,
sum(b.PRICE*b.AMOUNT) as subtotal
from book b
group by b."NAME" ,b.PRICE ,b.AMOUNT

