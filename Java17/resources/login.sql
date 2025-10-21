-- deltajavad.Logins definition

CREATE TABLE `Logins` (
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- deltajavad.splogins stored procedure

CREATE PROCEDURE deltajavad.splogins()
BEGIN
	SELECT * from Logins;
END