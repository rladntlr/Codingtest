-- 코드를 작성해주세요
select i.ITEM_ID, i.ITEM_NAME
from ITEM_INFO i
join ITEM_TREE t using(ITEM_ID)
where t.PARENT_ITEM_ID is null
order by ITEM_ID;