select b."NAME", b.PRICE , b.AMOUNT , (b.PRICE*b.AMOUNT) as subtotal
from book b
order by b.PRICE desc  --asc(預設:小到大) desc大到小
