SELECT RN, user_no, user_id
FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY user_no DESC) AS RN 
	  FROM users) U
WHERE RN BETWEEN 5 AND 10;

CREATE TABLE boards (
	board_no int PRIMARY KEY AUTO_INCREMENT,
	board_title_header VARCHAR(30),
	board_title VARCHAR(60) NOT NULL,
	user_name VARCHAR(15) NOT NULL,
	board_view_count INT DEFAULT 0,
	board_reg_date DATE DEFAULT SYSDATE(),
	board_del_yn VARCHAR(1) DEFAULT "N",
	board_notice_yn VARCHAR(1) DEFAULT "N",
	board_content VARCHAR(3000) NOT NULL,
	board_image_src VARCHAR(300),
	board_file_src VARCHAR(300)
);

INSERT INTO boards 
(board_title_header, board_title, user_name, board_content, board_image_src, board_file_src) 
VALUES ("[TEST]", "실험입니다", "실험맨", "실험실험 실험입니다", "", "");
