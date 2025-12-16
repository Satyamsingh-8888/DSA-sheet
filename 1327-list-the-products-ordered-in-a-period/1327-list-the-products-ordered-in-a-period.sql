# Write your MySQL query statement below
with cte as (select product_id, sum(unit) as unit_feb from orders 
where year(order_date)=2020 and month(order_date)=2
group by product_id)

select p.product_name, c.unit_feb as unit from cte c left join products p 
on c.product_id=p.product_id where c.unit_feb>=100;