-- 코드를 입력하세요
with cohort as(
    select u.user_id
    from user_info as u
    where u.joined >= '2021-01-01' and u.joined < '2022-01-01'
),
tot as(
    select count(*) as total_users from cohort
),
sales as(
    select
        year(s.sales_date) as year,
        month(s.sales_date) as month,
        count(DISTINCT s.user_id) as PURCHASED_USERS
    from ONLINE_SALE as s
    inner join cohort as c
    on s.user_id = c.user_id
    group by year, month
)
select
    s.year, 
    s.month, 
    s.PURCHASED_USERS,
    round(s.PURCHASED_USERS / t.total_users, 1) as PUCHASED_RATIO
from sales as s
cross join tot as t
order by s.year, s.month;
    