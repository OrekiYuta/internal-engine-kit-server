INSERT INTO IEK_LOCATOR (id, bizz, title, website, account, hex_secret, remark, is_active, created_at, updated_at)
VALUES (1, '931a9f0e-b48f-4920-ad22-4c7b39de42f2', 'Apple', 'https://www.apple.com/', 'EthanJohnson',
        'ypV20EDvCloiejBL',
        'Remark Apple', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, '2dd8b0ea-acdb-4078-890c-9a5726336e07', 'Microsoft', 'https://www.microsoft.com/', 'OliviaSmith',
        'OPxTUxT4PLEa5ow0',
        'Remark Microsoft', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, '6439bd99-b835-4bde-989e-65a16adc1b6f', 'Amazon', 'https://www.amazon.com/', 'LiamWilliams',
        '7067YnjYyHxZOxam',
        'Remark Amazon', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (4, '17c1f27e-2d3a-4cc9-8815-fa38f6cf5045', 'Google', 'https://www.google.com/', 'AvaBrown', 'la7Ad2F9m8E34YsL',
        'Remark Google', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (5, '7cf26887-0b2d-4f0c-9380-37b10aea4cbb', 'Alphabet (Google parent company)', 'https://abc.xyz/', 'Noah Jones',
        'Wd7kxpHoj3p0OCxs',
        'Remark Alphabet', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (6, 'c33ba2cd-c8dd-4820-b4a3-fbab7d730ad3', 'Tesla', 'https://www.tesla.com/', 'EmmaDavis', '0BnqsW0BmweYameV',
        'Remark Tesla', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (7, 'a73394e0-2318-40c0-9b0d-728ea3c5ecc9', 'Samsung', 'https://www.samsung.com/', 'MasonMiller',
        'BGnK33uMFAIPTgDM',
        'Remark Samsung', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (8, '6d6a3b13-8c6b-42a2-a8e4-8d26b4cb397e', 'Facebook (now Meta)', 'https://www.facebook.com/', 'LucasMartinez',
        'yb4NB4HGdVYEE4Pp',
        'Remark Facebook', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (9, '0cb70c65-8ec6-48ea-9470-1360380b9eff', 'Red Hat', 'https://www.redhat.com/', 'SophiaWilson',
        'LxvHC6QK5rWBYxKp',
        'Remark Red Hat', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);



INSERT INTO IEK_GENERATOR (id, bizz, topic, attribute, source, expect, remark, is_active, created_at, updated_at)
VALUES (1, 'c818cd66-60ab-46cc-b535-d07ada8e0a9c', 'Topic 1', 'Attribute 1', 'Source 1', 'Expect 1', 'Remark 1', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'f70f647e-f45a-40f7-b6dd-56d46f23eb43', 'Topic 2', 'Attribute 2', 'Source 2', 'Expect 2', 'Remark 2', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, '8929eeea-bd73-41b0-a86d-7a935e24a9a9', 'Topic 3', 'Attribute 3', 'Source 3', 'Expect 3', 'Remark 3', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (4, '7d6b154c-1d38-46ac-b91e-a071797bd43e', 'Topic 4', 'Attribute 4', 'Source 4', 'Expect 4', 'Remark 4', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (5, '335b2292-a88b-469c-8252-468f12b27cdc', 'Topic 5', 'Attribute 5', 'Source 5', 'Expect 5', 'Remark 5', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (6, '77768cf8-16d6-4c2a-b73c-36d9e3576fbb', 'test_datapatch', 'G_DATA_PATCH',
        '{"statement":"CREATE TABLE IEK_GENERATOR ( id INTEGER PRIMARY KEY, bizz VARCHAR(36) NOT NULL, topic VARCHAR(20) NOT NULL, attribute VARCHAR(20) NOT NULL, source LONGTEXT, expect LONGTEXT, remark VARCHAR(255), is_active CHAR(1) NOT NULL CHECK (is_active IN (''Y'', ''N'')), created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP );","count":"3"}',
        '{"sqlStatement":["INSERT INTO IEK_GENERATOR (id, bizz, topic, attribute, source, expect, remark, is_active, created_at, updated_at) VALUES (18, ''Voluptatem nihil ut quis reprehender'', ''Sit saepe laudantium'', ''Est corrupti in volu'', ''Aut voluptatem et aut tempore velit molestias reiciendis et commodi vitae rerum consequatur assumenda aut molestias temporibus similique occaecati tenetur ipsam minima ducimus nostrum sunt est fugiat incidunt et omnis a ullam sunt aut rerum adipisci nihil'', ''Illo iusto officiis deleniti ea dignissimos alias veniam hic sapiente facere molestias nobis pariatur magnam id rerum nihil mollitia modi repellat maxime aut repellendus nostrum consequatur optio similique debitis qui veritatis repellat sint perferendis a'', ''Mollitia corporis soluta beatae ad eveniet magnam non in aliquam nesciunt quaerat debitis et quisquam molestias iure tempora nihil qui eum sit neque qui qui accusantium ex temporibus aut alias corporis consectetur et voluptatem at unde iure velit illo qua'', ''Y'', ''2023-04-21 10:53:02'', ''2023-03-29 10:14:58'');","INSERT INTO IEK_GENERATOR (id, bizz, topic, attribute, source, expect, remark, is_active, created_at, updated_at) VALUES (1896, ''In ad accusantium laboriosam nesciun'', ''Sunt non autem conse'', ''Sint soluta ab ut de'', ''Fugit consequatur et sed quibusdam eius modi quae sed id consequatur illo est omnis ut voluptatem non occaecati dolor at aspernatur repudiandae aspernatur recusandae doloremque vero a incidunt aut iure excepturi tempora placeat ea voluptatem delectus qui '', ''At ab nihil labore dolor hic et odio consequatur temporibus delectus asperiores ut harum quae modi fugiat et mollitia autem ut a eos nisi rerum nihil repudiandae nobis et saepe animi harum vitae id nisi vel eveniet laboriosam et quos amet natus soluta qui'', ''Ipsa aut voluptate soluta eos sed sint est aperiam eum ea asperiores voluptas laudantium adipisci voluptas minus cupiditate id recusandae molestias consequatur autem fugit tenetur et molestiae quae praesentium et et natus asperiores ea est in repellat rep'', ''N'', ''2022-09-23 14:52:58'', ''2023-04-15 19:12:41'');","INSERT INTO IEK_GENERATOR (id, bizz, topic, attribute, source, expect, remark, is_active, created_at, updated_at) VALUES (205646120, ''Voluptatem odio hic totam ad maiores'', ''Et maxime aut et odi'', ''Ea voluptate deserun'', ''Et enim aliquam facere sapiente tempora voluptas omnis quia numquam tempora rerum occaecati consectetur magni ratione repellendus sunt veniam velit nam et omnis voluptas placeat enim odio laborum sequi et earum error harum unde quos ipsum illum quae quasi'', ''Eaque exercitationem est quis quibusdam unde adipisci sit aut nemo ipsum impedit et dolorum consequuntur et ea ipsa rem accusantium quisquam quia dolores explicabo similique voluptas voluptas non repellendus doloremque est eos soluta eaque officiis autem '', ''Magni illo aut reprehenderit voluptate nulla amet perferendis quis ad aut maxime in rem molestiae at error amet ut voluptatibus qui sit nesciunt numquam officia officia omnis optio culpa eligendi sint assumenda cumque dignissimos sunt consequatur reiciend'', ''N'', ''2023-03-19 15:00:06'', ''2023-02-10 19:26:10'');"],"jsonStatement":[{"id":"3471","bizz":"Deleniti ratione ea deleniti maiores","topic":"Qui quasi aliquid ut","attribute":"Et corporis doloremq","source":"Voluptate optio laudantium et architecto qui quod tenetur omnis et dolorum et est hic perspiciatis dignissimos quod nihil odio odio cum quia cumque quisquam facilis velit ducimus voluptas vero quia et quos aspernatur ab esse omnis fuga sapiente harum aspe","expect":"Voluptatem rem ratione dolor non quia sed doloribus ab velit recusandae cupiditate aspernatur recusandae quia nihil iste sed cumque animi omnis iure distinctio et voluptas veniam laboriosam numquam vel est et facilis minima atque autem sit dolore quia nes","remark":"Qui dolorem et sed unde asperiores tempora temporibus rem nam eius corporis inventore reiciendis molestiae omnis et et voluptatem similique accusamus porro vel consequatur quia commodi asperiores nemo qui deserunt qui iste rerum veniam quia nisi voluptate","is_active":"Y","created_at":"2023-02-02 22:19:06","updated_at":"2023-06-15 08:42:17"},{"id":"302","bizz":"Placeat sit sint pariatur qui sunt v","topic":"Aut qui dolor omnis ","attribute":"Sequi amet sed minus","source":"Dolore et hic aliquam culpa est nisi nobis est laborum sunt dolore et modi id et sit veritatis libero corrupti ipsam ipsum laborum reiciendis aperiam omnis qui ad quia sed dolorem debitis voluptatem sapiente consequuntur consequatur et ut mollitia ex tene","expect":"Aut ad atque asperiores recusandae ullam quo veniam laborum ut atque beatae impedit blanditiis repellendus quisquam sed maiores quasi cumque molestias officia et aspernatur optio nesciunt fugiat repudiandae sed culpa molestiae vel eum ut qui dignissimos u","remark":"Enim ducimus et recusandae voluptatum odio autem enim tenetur aut nihil et quo molestias aut maiores quia porro voluptatum vel quia perspiciatis molestias ipsam fuga sit libero ea et exercitationem beatae placeat et quia tempore asperiores quo quia laudan","is_active":"N","created_at":"2023-01-15 21:46:02","updated_at":"2022-11-12 03:24:48"},{"id":"5152764","bizz":"Molestias error mollitia quo et volu","topic":"Esse pariatur est et","attribute":"Nostrum et enim dolo","source":"Veniam tempore unde numquam aliquid ut delectus excepturi reiciendis magnam quo molestias id est ut nihil ut aut et sit reprehenderit dolores quae est impedit labore illum saepe eum tempore id laborum modi consequuntur atque nihil quidem quaerat est illum","expect":"Error quod autem quaerat autem accusantium facilis pariatur numquam culpa similique autem totam fuga id ullam molestias sed esse similique reiciendis perferendis et quod dolorem illum voluptas sunt quibusdam accusantium voluptas consequuntur aperiam debit","remark":"Qui sit amet molestiae quod quis itaque excepturi ipsa nobis nisi vero nostrum eius id deserunt praesentium quis quia autem quis rerum saepe perferendis nostrum enim omnis et pariatur enim voluptatem repellat temporibus incidunt labore autem neque officia","is_active":"Y","created_at":"2023-05-25 16:24:35","updated_at":"2023-02-22 00:24:31"}]}',
        NULL, 'Y', '1690021070272', '1690021070272');

INSERT INTO IEK_CONVERTER (id, bizz, topic, attribute, source, expect, remark, is_active, created_at, updated_at)
VALUES (1, 'f03ac203-e898-4efb-b384-6aac1bfe673e', 'Topic 1', 'Attribute 1', 'Source 1', 'Expect 1', 'Remark 1', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, '4e7c833d-60a6-44f1-bc51-91de286ed99d', 'Topic 2', 'Attribute 2', 'Source 2', 'Expect 2', 'Remark 2', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, '99b14870-8857-414d-b5cf-3de88967b238', 'Topic 3', 'Attribute 3', 'Source 3', 'Expect 3', 'Remark 3', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (4, 'dcdc8ac7-e30e-4a6e-aeb3-1b383f129e18', 'Topic 4', 'Attribute 4', 'Source 4', 'Expect 4', 'Remark 4', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (5, '1d4da87a-eead-48ed-a056-2b672c545c2b', 'Topic 5', 'Attribute 5', 'Source 5', 'Expect 5', 'Remark 5', 'Y',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

