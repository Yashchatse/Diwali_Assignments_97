DELIMITER $$

CREATE FUNCTION getWorkingDays(join_date DATE) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total_days INT;
    DECLARE work_days INT;
    SET total_days = DATEDIFF(CURDATE(), join_date) + 1;
   SET work_days = total_days 
                    - (FLOOR(total_days/7) * 2) 
                    - IF(DAYOFWEEK(join_date) = 1,1,0) 
                    - IF(DAYOFWEEK(CURDATE()) = 7,1,0);
    
    RETURN work_days;
END$$

DELIMITER ;
