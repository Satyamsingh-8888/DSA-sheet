# Write your MySQL query statement below
select distinct u.name , case when r.distance is not null then sum(distance) over (partition by r.user_id order by r.user_id)
else 0 end as travelled_distance
from users u
left join rides r  on u.id=r.user_id order by travelled_distance desc, u.name;