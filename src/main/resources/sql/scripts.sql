-- Selecting best answer from question by question id
select * from answers where is_best and question = 1;

-- Selecting users ordered by rating
select * from users order by rating desc;

-- Selecting all answers from question by id ordered by best answer
select * from answers where question = 1 order by is_best desc;
