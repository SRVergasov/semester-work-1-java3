create table users (
    id bigserial primary key,
    username varchar not null,
    password varchar not null,
    rating bigint default 0 constraint positive_rating check ( rating >= 0 )
);

create table questions (
    id bigserial primary key,
    title varchar not null,
    description varchar not null,
    user_id bigint references users not null
);

create table answers (
    id bigserial primary key,
    text varchar not null,
    question bigint references questions not null,
    user_id bigint references users,
    likes bigint constraint positive_likes check ( likes >= 0 )
);

alter table questions add column best_answer bigint references answers;
alter table answers add constraint nn_user_id check ( user_id is not null );
alter table answers alter column likes set default 0;
alter table users add constraint uniq_username unique (username);
alter table questions drop column best_answer;
alter table answers add column is_best bool default false;
alter table users add column role varchar constraint users_roles_choice check ( role in ('user', 'admin') ) default 'user';
