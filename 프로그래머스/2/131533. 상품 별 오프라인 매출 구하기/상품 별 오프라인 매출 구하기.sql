-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(p.PRICE * o.SALES_AMOUNT) SALES
from PRODUCT p
join OFFLINE_SALE o using(PRODUCT_ID)
group by p.PRODUCT_CODE
order by 2 desc, 1;