INSERT INTO Orders(ORDER_ID,CREATED_AT,UPDATED_AT,ADDRESS,EMAIL,ORDER_STATUS,POSTCODE)
VALUES ('a7fa375985884e0987e66642bfb613ca', '2022-09-06T12:00', NULL,'here','abcde@naver.com', 0, 'ZIP12345'),
       ('86104336078143dc9758fea3a35ff74e', '2022-09-06T12:00', NULL,'here','abcde1@naver.com',0, 'ZIP12345'),
       ('ef412f0b5c0e43ea9e992bdef1123e9f', '2022-09-06T12:00', NULL,'here','abcde1@naver.com',1, 'ZIP12345'),
       ('221bdcc803bf4f7090e4b26c095ae271', '2022-09-06T12:00', NULL,'here','abcde@naver.com', 1, 'ZIP12345'),
       ('221bdcc803bf4f7090e4b26c095ae274', '2022-09-06T12:00', NULL,'here','abcde@naver.com', 0, 'ZIP12345'),
       ('221bdcc803bf4f7090e4b26c095ae272', '2022-09-06T12:00', NULL,'here','abcde@naver.com', 0, 'ZIP12345'),
       ('221bdcc803bf4f7090e4b26c095ae273', '2022-09-06T12:00', NULL,'here','abcde@naver.com', 2, 'ZIP12345'),
       ('82ab5fa3059345ec8e74bbe52f70da45', '2022-09-06T12:00', NULL,'here','abcde@naver.com', 3, 'ZIP12345');

INSERT INTO PRODUCT(PRODUCT_ID, CREATED_AT, UPDATED_AT, CATEGORY, DESCRIPTION, PRICE, PRODUCT_NAME, QUANTITY)
VALUES  ('a7fa375985884e0987e66642bfb613ca','2022-09-06T12:00', '2022-09-08T12:00' , 0,'커피콩1', 300, '커피짱1',3),
        ('86104336078143dc9758fea3a35ff72e','2022-09-07T12:00', '2022-09-08T12:00', 0, '커피콩2', 300, '커피짱2',5),
        ('86104336078143dc9758fea3a35ff73e','2022-09-08T12:00', '2022-09-08T12:00', 0, '커피콩3', 300, '커피짱3',5),
        ('86104336078143dc9758fea3a35ff74e','2022-09-09T12:00', '2022-09-08T12:00', 0, '커피콩4', 300, '커피짱4',5),
        ('86104336078143dc9758fea3a35ff75e','2022-09-10T12:00', '2022-09-08T12:00', 0, '커피콩5', 300, '커피짱5',5),
        ('86104336078143dc9758fea3a35ff76e','2022-09-11T12:00', '2022-09-08T12:00', 0, '커피콩6', 300, '커피짱6',5),
-- ,
        ('ef412f0b5c0e43ea9e992bdef1123e9f','2022-09-12T12:00', '2022-09-08T12:00', 1, '커피컵1', 500, '컵짱1',7),
        ('221bdcc803bf4f7090e4b26c095ae271','2022-09-13T12:00', '2022-09-08T12:00', 1, '커피컵2', 500, '컵짱2',9);


