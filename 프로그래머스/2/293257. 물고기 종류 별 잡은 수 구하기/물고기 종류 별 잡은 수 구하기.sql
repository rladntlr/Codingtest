-- 코드를 작성해주세요
select count(*)FISH_COUNT, b.FISH_NAME
from FISH_INFO a
join FISH_NAME_INFO b using(FISH_TYPE)
group by FISH_NAME
order by 1 desc;