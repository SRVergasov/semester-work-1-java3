-- Examples db scripts:

-- Selecting best answer from question by question id
select * from answers where is_best and question = ?;

-- Selecting users ordered by rating
select * from users order by rating desc;

-- Selecting all answers from question by id ordered by best answer
select * from answers where question = ? order by is_best desc;

-- Selecting questions list
select * from questions order by id desc;

-- Selecting answers list
select * from answers where is_best = true
union all
(select * from answers where question = ? except select * from answers where is_best = true order by likes desc);

-- selecting 1 like
select * from likes where user_id = ? and answer_id = ?;

-- setting enabled to like
update likes set enabled = true where answer_id = ? and user_id = ?;

-- get likes count
select count(*) from likes where answer_id = ?;

-- set likes count
update answers set likes = (select count(*) from likes where answer_id = ?) where id = ?;

-- updating user rating
update users set rating = rating + ? where id = ?;

-- deleting answer
delete from likes where answer_id = ?;
delete from answers where id = ?;

-- get answer like count
select count(*) from likes where answer_id = ?;

-- deleting quetion
delete from likes where answer_id = ?;
delete from answers where question = ?;
delete from questions where id = ?;

-- deleting like
delete from likes where answer_id = ? and user_id = ?;

-- add like
insert into likes (user_id, answer_id) VALUES (?, ?);
