INSERT INTO
users (id, handle, email, first_name, last_name, password)
VALUES (1, 'synaodev', 'synaodev@gmail.com', 'Tyler', 'Cadena', 'tylercadena');

INSERT INTO
users (id, handle, email, first_name, last_name, password)
VALUES (2, 'songbird', 'songbird@gmail.com', 'Adrienne', 'Sparkman', 'password');

INSERT INTO
messages (id, content, user_id)
VALUES (1, 'This is a message!', 1);

INSERT INTO
messages (id, content, parent_id, user_id)
VALUES (2, 'This is a comment!', 1, 2);
