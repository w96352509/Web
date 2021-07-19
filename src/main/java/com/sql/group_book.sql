select b."NAME", sum(b.PRICE*b.AMOUNT) as subtotal
from book b
group by b."NAME"

