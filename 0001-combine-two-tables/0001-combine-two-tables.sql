# Write your MySQL query statement below
select p.firstname, p.lastname, ad.city, ad.state from person p 
left join address ad on p.personid=ad.personid;