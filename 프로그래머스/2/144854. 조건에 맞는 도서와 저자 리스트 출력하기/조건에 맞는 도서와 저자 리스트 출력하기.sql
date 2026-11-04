-- 코드를 입력하세요 
SELECT b.BOOK_ID, a.AUTHOR_NAME, date_format(b.PUBLISHED_DATE, '%Y-%m-%d')
from book b
join author a using(author_id)
where CATEGORY = '경제'
order by PUBLISHED_DATE;