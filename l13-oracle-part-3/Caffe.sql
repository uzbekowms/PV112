-- View
CREATE VIEW all_employee AS
    SELECT
        *
    FROM
        employee;

SELECT
    *
FROM
    all_employee;

CREATE OR REPLACE VIEW t_full_names_all AS
    SELECT
        c_name
        || ' '
        || c_last_name full_name
    FROM
        t_full_names;

SELECT
    *
FROM
    t_full_names_all;

CREATE OR REPLACE VIEW t_full_names_all ( full_name ) AS
    SELECT
        c_name
        || ' '
        || c_last_name
    FROM
        t_full_names;

DROP VIEW t_full_names_all;

DROP VIEW all_employee;

-- cars brand_id -> brand 

-- bmw_cars

-- Java C# 




-- Declaration

-- Executable

-- Exception-handling
SET SERVEROUTPUT ON;

BEGIN
    dbms_output.put_line('Hello world');
END;
/

DECLARE
    l_message VARCHAR2(255) := 'Hello world';
BEGIN
    dbms_output.put_line(l_message);
END;
/

DECLARE
    l_message VARCHAR2(255) DEFAULT 'Hello world';
BEGIN
    dbms_output.put_line(l_message);
END;
/

DECLARE
    v_result NUMBER;
BEGIN
    v_result := 1 / 0;
EXCEPTION
    WHEN zero_divide THEN
        dbms_output.put_line(sqlerrm);
END;
/


-- NUMBER
-- BOOLEAN
-- Charachter
-- Datetime

-- NATURAL - int number
-- NATURALN - int number not null

-- 

DECLARE
    v_result NUMBER NOT NULL := intial_value;
BEGIN
    v_result := 1 / 0;
EXCEPTION
    WHEN zero_divide THEN
        dbms_output.put_line(sqlerrm);
END;
/

DECLARE
    l_total NUMBER(15, 2);
    l_count NUMBER(10, 0);
BEGIN
    NULL;
END;
/

DECLARE
    l_message VARCHAR2(255) NOT NULL := 'Hello world';
BEGIN
    l_message := '';
END;
/

DECLARE
    l_message VARCHAR2(255) NOT NULL := 'Hello world';
BEGIN
    l_message := 'Hello students';
    dbms_output.put_line(l_message);
END;
/

DECLARE
    l_employee_name      t_full_names.c_name%TYPE;
    l_employee_last_name l_employee_name%TYPE;
BEGIN
    SELECT
        c_name
    INTO l_employee_name
    FROM
        t_full_names
    WHERE
        c_last_name = 'A'
    FETCH FIRST 1 ROW ONLY;

    dbms_output.put_line(l_employee_name);
END;
/
/*


asdfasdfgasf


*/


-- 

DECLARE
    co_salary CONSTANT NUMBER := 45;
BEGIN
    NULL;
END;
/

DECLARE
    co_salary CONSTANT NUMBER := 45;
BEGIN
    co_salary := 50;
END;
/




-- IF THEN
-- IF THEN ELSE
-- IF THEN ELSIF
/*
IF condition THEN
    executable;
END IF;

*/
DECLARE
    co_salary CONSTANT NUMBER := 45;
BEGIN
    IF co_salary < 20 THEN
        dbms_output.put_line('Salary is bigger than 20 grivnya. Ura');
    END IF;
END;
/

DECLARE
    co_salary CONSTANT NUMBER := 10;
BEGIN
    IF co_salary > 20 THEN
        dbms_output.put_line('Salary is bigger than 20 grivnya. Ura');
    ELSE
        dbms_output.put_line('Ne Ura ((');
    END IF;
END;
/

DECLARE
    co_salary CONSTANT NUMBER := 55;
BEGIN
    IF co_salary > 50 THEN
        dbms_output.put_line('We rich');
    ELSIF co_salary > 40 THEN
        dbms_output.put_line('We not that rich');
    ELSIF co_salary > 30 THEN
        dbms_output.put_line('We normal');
    ELSE
        dbms_output.put_line('Ne Ura ((');
    END IF;
END;
/


/*

CASE selector
WHEN selector_value_1 then
    some code;
WHEN selector_value_2 THEN
    some code;
ELSE 
    code;
END CASE;

*/


DECLARE
    c_grade CHAR(1);
BEGIN
    c_grade := 'F';
    CASE c_grade
        WHEN 'A' THEN
            dbms_output.put_line('Ura');
        WHEN 'B' THEN
            dbms_output.put_line('yahoo');
        WHEN 'C' THEN
            dbms_output.put_line('eh');
        ELSE
            RAISE case_not_found;
    END CASE;

END;
/


-- GOTO
BEGIN
    GOTO second_flag;
    << first_flag >> dbms_output.put_line('First flag');
    GOTO the_end;
    << second_flag >> dbms_output.put_line('Second flag');
    GOTO first_flag;
    << the_end >> dbms_output.put_line('End');
END;
/

/*

<<label>> LOOP
    code;
    EXIT == break
END LOOP label;



*/

DECLARE
    l_counter NUMBER := 0;
BEGIN
    LOOP
        l_counter := l_counter + 1;
        IF l_counter > 3 THEN
            EXIT;
        END IF;
        dbms_output.put_line('In loop ' || l_counter);
    END LOOP;

    dbms_output.put_line('Out loop ' || l_counter);
END;
/

DECLARE
    l_counter NUMBER := 0;
BEGIN
    LOOP
        l_counter := l_counter + 1;
        EXIT WHEN l_counter > 3;
        dbms_output.put_line('In loop ' || l_counter);
    END LOOP;

    dbms_output.put_line('Out loop ' || l_counter);
END;
/

DECLARE
    l_i NUMBER := 0;
    l_j NUMBER := 0;
BEGIN
    << outer_loop >> LOOP
        l_i := l_i + 1;
        EXIT outer_loop WHEN l_i > 2;
        dbms_output.put_line('Outer loop ' || l_i);
        l_j := 0;
        << inner_loop >> LOOP
            l_j := l_j + 1;
            EXIT inner_loop WHEN l_j > 3;
            dbms_output.put_line('Inner loop ' || l_j);
        END LOOP inner_loop;

    END LOOP outer_loop;
END;
/

BEGIN
    FOR l_counter IN 1..5 LOOP
        dbms_output.put_line(l_counter);
    END LOOP;
END;
/

DECLARE
    l_step PLS_INTEGER := 2;
BEGIN
    FOR l_counter IN 1..5 LOOP
        dbms_output.put_line(l_counter * l_step);
    END LOOP;
END;
/

BEGIN
    FOR l_counter IN 1..5 LOOP
        dbms_output.put_line(l_counter);
    END LOOP;
    dbms_output.put_line(l_counter);
END;
/

<< outer >> DECLARE
    l_counter PLS_INTEGER := 10;
BEGIN
    FOR l_counter IN 1..5 LOOP
        dbms_output.put_line('Local: ' || l_counter);
        outer.l_counter := l_counter;
    END LOOP;

    dbms_output.put_line(l_counter);
END;
/

BEGIN
    FOR l_counter IN REVERSE 1..5 LOOP
        dbms_output.put_line(l_counter);
    END LOOP;
END;
/


/*
VARCHAR - ANSI
VARCHAR2 - ORACLE

WHILE condition
LOOP
    code;
END LOOP;

CONTINUE;

CONTINUE WHEN condtiotion;


*/

DECLARE
    r_employee t_full_names%rowtype;
BEGIN
    SELECT
        *
    INTO r_employee
    FROM
        t_full_names
    FETCH FIRST 1 ROW ONLY;

    dbms_output.put_line(r_employee.c_name
                         || ' '
                         || r_employee.c_last_name);
END;
/

DECLARE
    r_employee t_full_names%rowtype;
BEGIN
    SELECT
        *
    INTO r_employee
    FROM
        t_full_names
    WHERE
        c_last_name = 'Something';

    dbms_output.put_line(r_employee.c_name
                         || ' '
                         || r_employee.c_last_name);
EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('Employee with last name "Something" does not exists');
END;
/

DECLARE
    r_employee t_full_names%rowtype;
    exception_name EXCEPTION;
    PRAGMA exception_init ( exception_name, -20001 );
BEGIN
    raise_application_error(-20001, 'No');
    RAISE exception_name;
EXCEPTION
    WHEN exception_name THEN
        --RAISE;
        dbms_output.put_line(sqlerrm);
END;
/

DECLARE
    TYPE r_employee_contact_t IS RECORD (
            employee_name      t_full_names.c_name%TYPE,
            employee_last_name t_full_names.c_name%TYPE
    );
    r_employee_contact r_employee_contact_t;
BEGIN
    NULL;
    INSERT INTO t_full_names VALUES r_employee_contact;

    UPDATE t_full_names
    SET
        row = r_employee_contact
    WHERE
        id = r_employee_contact.id;

END;
/

DECLARE
    CURSOR c_employees IS
    SELECT
        *
    FROM
        t_full_names;

    r_employee t_full_names%rowtype;
BEGIN
    OPEN c_employees;
    LOOP
        FETCH c_employees INTO r_employee;
        EXIT WHEN c_employees%notfound;
        dbms_output.put_line(c_employees%rowcount
                             || ' '
                             || r_employee.c_name);
    END LOOP;

END;
/

/*
%ISOPEN
%FOUND
INVALID_CURSOR
%NOTFOUND





*/

DECLARE
    CURSOR c_employees IS
    SELECT
        *
    FROM
        t_full_names;

    r_employee t_full_names%rowtype;
BEGIN
    FOR record IN c_employees LOOP
        dbms_output.put_line(c_employees%rowcount
                             || ' '
                             || record.c_name);
    END LOOP;
END;
/

BEGIN
    FOR record IN (
        SELECT
            *
        FROM
            t_full_names
    ) LOOP
        dbms_output.put_line(record.c_name);
    END LOOP;
END;
/

DECLARE
    r_employee t_full_names%rowtype;
    CURSOR c_employee (
        employee_name VARCHAR
    ) IS
    SELECT
        *
    FROM
        t_full_names
    WHERE
        c_last_name = employee_name;

BEGIN
    FOR record IN c_employee('A') LOOP
        dbms_output.put_line(record.c_name);
    END LOOP;
END;
/

CREATE OR REPLACE PROCEDURE procedure_name (
    in_employee_id NUMBER
) IS
    --Declare
BEGIN
    --execution
    NULL;
END;
/


-- IN, OUT, INOUT
CREATE OR REPLACE PROCEDURE print_employee (
    employee_name IN VARCHAR,
    r_employee    OUT t_full_names%rowtype
) IS
BEGIN
    SELECT
        *
    INTO r_employee
    FROM
        t_full_names
    WHERE
        c_last_name = employee_name
    FETCH FIRST 1 ROW ONLY;

END;
/

DECLARE
    r_employee t_full_names%rowtype;
BEGIN
    print_employee('A', r_employee);
    dbms_output.put_line(r_employee.c_name);
END;
/

EXECUTE print_employee('A');
EXEC print_employee('A');

DROP PROCEDURE print_employee;



CREATE OR REPLACE TRIGGER trigger_name
[BEFORE | AFTER] event ON t_full_names
[FOR EACH ROW]
[FOLLOWS PRECEDES trigger_name]
[ENABLE| DISABLE]
[WHEN NEW.user_age > 1000]
DECLARE
    --
BEGIN
    --
end;
/

create table audits(
table_name VARCHAR(255),
transaction_name VARCHAR(10),
by_user VARCHAR(255),
transaction_date DATE
);
/

CREATE OR REPLACE TRIGGER employees_audit AFTER
    UPDATE OR DELETE ON t_full_names
    FOR EACH ROW
DECLARE
    l_transaction VARCHAR(10);
BEGIN
    l_transaction :=
        CASE
            WHEN updating THEN
                'UPDATE'
            WHEN deleting THEN
                'DELETE'
        END;
    INSERT INTO audits (
        table_name,
        transaction_name,
        by_user,
        transaction_date
    ) VALUES (
        't_full_names',
        l_transaction,
        user,
        sysdate
    );
END;
/

delete from t_full_names where c_last_name = 'A';


