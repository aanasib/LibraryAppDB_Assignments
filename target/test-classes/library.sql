
-- US01
select count(id) from users; -- 1855
select count(distinct id) from users;

-- US02
select * from users;

-- US 03
select count(*) from book_borrow
where is_returned=0;

-- US04
select * from books where name = 'AttiaNasib';

-- US05

-- US06
select full_name,b.name,bb.borrowed_date from users u inner join book_borrow bb on u.id = bb.user_id
                                                      inner join books b on bb.book_id = b.id
where full_name='Test Student 5'
order by 3 desc;

-- US07







