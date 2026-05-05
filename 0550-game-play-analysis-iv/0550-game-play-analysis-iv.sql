# Write your MySQL query statement below
select round(count(distinct a.player_id)/(select count(distinct player_id ) from activity),2) as fraction from activity a
where(a.player_id, a.event_date) in (
    select player_id, date_add(MIN(event_date), INTERval 1 DAY)
    from activity
    group by player_id
);
