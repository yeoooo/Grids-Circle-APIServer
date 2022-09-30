-- INSERT INTO Orders(ORDER_ID,CREATED_AT,UPDATED_AT,ADDRESS,EMAIL,ORDER_STATUS,POSTCODE)
-- VALUES (unhex(replace(UUID(),'-','')), '2022-09-18T16:00', '2022-09-18T12:00','here','abcde@naver.com', 0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', '2022-09-07T12:00','here','abcde1@naver.com',0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', '2022-09-08T12:00','here','abcde1@naver.com',1, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', '2022-09-09T12:00','here','abcde@naver.com', 1, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-05T12:00', '2022-09-06T12:00','here','abcde@naver.com', 0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', '2022-09-11T12:00','here','abcde@naver.com', 0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', '2022-09-13T12:00','here','abcde@naver.com', 2, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', '2022-09-13T12:00','here','abcde@naver.com', 3, 'ZIP12345');

---

INSERT INTO PRODUCT(PRODUCT_ID, CREATED_AT, UPDATED_AT, CATEGORY, DESCRIPTION, PRICE, PRODUCT_NAME, QUANTITY)
VALUES (unhex(replace(UUID(),'-','')), '2022-09-07T12:00', '2022-09-08T12:00', 0, '이 콩은 두 번째로 맛있습니다.', 300, '커피짱2', 6),
       (unhex(replace(UUID(),'-','')), '2022-09-08T12:00', '2022-09-08T12:00', 0, '이 콩은 고양이가 먹다 뱉었습니다.', 300, '커피짱3', 7),
        (unhex(replace(UUID(),'-','')),'2022-09-09T12:00', '2022-09-08T12:00', 0, '이 콩은 고양이가 갖고 놀기 좋아했습니다.', 300, '커피짱4',500),
--         (unhex(replace(UUID(),'-','')),'2022-09-10T12:00', '2022-09-08T12:00', 0, '커피콩5', 300, '커피짱5',500),
        (unhex(replace(UUID(),'-','')),'2022-09-11T12:00', '2022-09-08T12:00', 0, '커피콩6', 300, '커피짱6',500),
        (unhex(replace(UUID(),'-','')),'2022-09-12T12:00', '2022-09-08T12:00', 1, '고양이가 이 컵은 깨지 않았으면 좋겠습니다.', 500, '컵짱1',700),
        (unhex(replace(UUID(),'-','')),'2022-09-13T12:00', '2022-09-08T12:00', 1, '깨지는 소리가 특별한 이 컵. 더이상 컵의 기능을 한정짓지 마세요.', 500, '컵짱2',900);

---

-- INSERT INTO Order_Item(ORDER_ITEM_ID, CREATED_AT, UPDATED_AT, COUNT, ORDER_PRICE, ORDER_ID, PRODUCT_ID)
-- VALUES (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 5,'abcde@naver.com', 0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 3,'abcde1@naver.com',0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 3,'abcde1@naver.com',1, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 1,'abcde@naver.com', 1, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 2,'abcde@naver.com', 0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 3,'abcde@naver.com', 0, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 2,'abcde@naver.com', 2, 'ZIP12345'),
--        (unhex(replace(UUID(),'-','')), '2022-09-06T12:00', NULL, 2,'abcde@naver.com', 3, 'ZIP12345');


