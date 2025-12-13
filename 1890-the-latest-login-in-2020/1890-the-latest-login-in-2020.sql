# Write your MySQL query statement below


select distinct user_id, FIRST_VALUE(time_stamp) over (partition by user_id order by time_stamp desc) as last_stamp
from logins where year(time_stamp)='2020';