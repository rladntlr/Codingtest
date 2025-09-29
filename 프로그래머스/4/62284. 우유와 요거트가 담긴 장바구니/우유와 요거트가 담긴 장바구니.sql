-- EXISTS 사용
SELECT c1.CART_ID
FROM CART_PRODUCTS c1
where c1.NAME = 'Milk'
    AND EXISTS(
    select 1
    from CART_PRODUCTS c2
    where c1.CART_ID = c2.CART_ID
        and c2.name = 'yogurt')
order by c1.CART_ID;