-- Selecting best answer from question by question id
select * from answers where is_best and question = 1;

-- Selecting users ordered by rating
select * from users order by rating desc;

-- Selecting all answers from question by id ordered by best answer
select * from answers where question = 1 order by is_best desc;

-- Selecting questions list
select * from questions order by id desc;

-- Selecting answers list
-- FIXME
select * from answers where question = 1 order by likes desc;

-- selecting 1 like
select * from likes where user_id = 1 and 2 = answer_id;

-- setting enabled to like
update likes set enabled = true where answer_id = 2 and user_id = 1;

-- get likes count
select count(*) from likes where answer_id = 1;

-- set likes count
update answers set likes = (select count(*) from likes where answer_id = ?) where id = ?;

-- updating user rating
update users set rating = rating + 10 where id = 1;

-- deleting answer
delete from likes where answer_id = ?;
delete from answers where id = ?;

-- get answer like count
select count(*) from likes where answer_id = ?;

-- deleting quetion
delete from likes where answer_id = ?;
delete from answers where question = 1;
delete from questions where id = 1;

-- deleting like
delete from likes where answer_id = ? and user_id = ?;

-- add like
insert into likes (user_id, answer_id) VALUES (?, ?);