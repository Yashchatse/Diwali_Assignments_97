DELIMITER $$

CREATE PROCEDURE updateSalary(IN p_empno INT)
BEGIN
    DECLARE total_days INT;
    DECLARE work_days INT;
    DECLARE curr_sal DECIMAL(10,2);
    DECLARE new_sal DECIMAL(10,2);
    DECLARE join_date DATE;

    SELECT sal, hiredate INTO curr_sal, join_date
    FROM emp
    WHERE empno = p_empno;
    SET total_days = DATEDIFF(CURDATE(), join_date) + 1;
    SET work_days = total_days 
                    - (FLOOR(total_days / 7) * 2)           
                    - IF(DAYOFWEEK(join_date) = 1, 1, 0)  
                    - IF(DAYOFWEEK(CURDATE()) = 7, 1, 0); 

    IF work_days >= 300 THEN
        SET new_sal = curr_sal * 1.10; 
    ELSEIF work_days >= 200 THEN
        SET new_sal = curr_sal * 1.05; 
    ELSE
        SET new_sal = curr_sal; 
    END IF;


    UPDATE emp
    SET sal = new_sal
    WHERE empno = p_empno;

END$$

DELIMITER ;
