INSERT INTO users (username, password, role, full_name, email) VALUES ('admin', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_ADMIN', "LMS Administrator", "admin@future.lms");
INSERT INTO users (username, password, role, full_name, email) VALUES ('john', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_TUTOR', "John Brown", "john@future.lms");
INSERT INTO users (username, password, role, full_name, email) VALUES ('mary', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_TUTOR', "Mary King", "mary@future.lms");
INSERT INTO users (username, password, role, full_name, email) VALUES ('tom', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_STUDENT', "Tom Leary", "tom@future.lms");
INSERT INTO users (username, password, role, full_name, email) VALUES ('ann', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_STUDENT', "Ann Kelley", "ann@future.lms");
INSERT INTO users (username, password, role, full_name, email) VALUES ('nick', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_STUDENT', "Nick Williams", "nick@future.lms");
INSERT INTO users (username, password, role, full_name, email) VALUES ('bill', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_STUDENT', "Bill Mayers", "bill@future.lms");
INSERT INTO users (username, password, role, full_name, email) VALUES ('olga', '$2a$10$Lb1tSRGaF0NNPCivEMDs8.xkx9BRm5/Dgbkn909o44e0JCIdWTljG', 'ROLE_STUDENT', "Olga Clint", "olga@future.lms");

INSERT INTO courses (title, category, slug, tutor_id) VALUES ('Introduction to Programming with Python', "Computer Science", "intro-to-python", 2);
INSERT INTO courses (title, category, slug, tutor_id) VALUES ('Database Systems', "Computer Science", "database-systems", 2);
INSERT INTO courses (title, category, slug, tutor_id) VALUES ('Consumer Behaviour', "Psychology", "consumer-behaviour", 3);
INSERT INTO courses (title, category, slug, tutor_id) VALUES ('Cognitive Psychology', "Psychology", "cognitive-psychology", 3);

INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (1, 1, "Variables and data types", "https://www.youtube.com/embed/xUhPxj8if0U?si=twSROWu_Qw6s_RYr", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque lectus arcu, rhoncus nec laoreet non, vulputate eget lorem. Duis arcu mauris, laoreet vel justo id, sagittis euismod tellus.");
INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (1, 2, "Selection", "https://www.youtube.com/embed/Zp5MuPOtsSY?si=X6RAaU-C5AzhDAgj", "Donec ut libero sit amet augue tincidunt condimentum. Morbi vehicula enim vitae turpis bibendum, ac semper sapien fermentum.");
INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (1, 3, "Repetition", "https://www.youtube.com/embed/6iF8Xb7Z3wQ?si=hZLisUu58CioOCsj", "Pellentesque dictum vitae nisi eu accumsan. Ut tempor semper mi, in mattis nisl fringilla sit amet.");

INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (2, 1, "Normalization", "https://www.youtube.com/embed/xoTyrdT9SZI?si=2FEVWkHUvqllXuF5", "Praesent id erat iaculis, faucibus neque eu, aliquet lacus. Nullam rhoncus eget ipsum ut molestie.");
INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (2, 2, "SQL", "https://www.youtube.com/embed/Hl4NZB1XR9c?si=9DprCzHPu9sgwtyL", "Cras egestas finibus pretium. Pellentesque scelerisque elementum consequat. Sed elit eros, euismod vitae auctor id, venenatis a nulla.");

INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (3, 1, "What is Consumer Behaviour", "https://www.youtube.com/embed/yv2cp1fmSt0?si=Kekse0FS7C2OJ0_t", "Quisque scelerisque augue tortor, non consequat felis pharetra quis. Donec luctus pretium odio, at varius diam fringilla ut.");
INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (3, 2, "Neuromarketing", "https://www.youtube.com/embed/F_Xlulm8UU4?si=YGwh67j7_32H4Zb2", "Ut ut lorem ut sem tristique tincidunt quis consectetur elit.");

INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (4, 1, "Cognition", "https://www.youtube.com/embed/R-sVnmmw6WY?si=zZcaG0yg7ZDl0qlf", "Nunc augue felis, laoreet eget interdum a, euismod eu sem. Quisque eleifend lorem at pulvinar malesuada.");
INSERT INTO topics (course_id, order_no, title, video_url, content) VALUES (4, 2, "Piaget's Theory", "https://www.youtube.com/embed/IhcgYgx7aAA?si=QEVvuZVqsGnJmJ6p", "Aliquam erat volutpat. Proin blandit, ante ut facilisis finibus, urna diam eleifend est, facilisis suscipit enim diam eget tortor.");
