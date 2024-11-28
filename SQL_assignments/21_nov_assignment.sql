-- Question 1
CREATE TABLE countries ( 
    country_id INT PRIMARY KEY, 
    country_name VARCHAR(100), 
    region_id INT 
);

-- Question 2
CREATE TABLE jobs ( 
    JOB_ID VARCHAR(10) PRIMARY KEY, 
    JOB_TITLE VARCHAR(35) NOT NULL, 
    MIN_SALARY DECIMAL(6, 0), 
    MAX_SALARY DECIMAL(6, 0) 
);

CREATE TABLE job_history ( 
    employee_id INT, 
    start_date DATE, 
    end_date DATE, 
    job_id VARCHAR(10), 
    department_id INT, 
    PRIMARY KEY (employee_id, start_date), 
    FOREIGN KEY (job_id) REFERENCES jobs(JOB_ID) 
);

CREATE TABLE departments ( 
    DEPARTMENT_ID DECIMAL(4,0) NOT NULL, 
    DEPARTMENT_NAME VARCHAR(30) NOT NULL, 
    MANAGER_ID DECIMAL(6,0) NOT NULL, 
    LOCATION_ID DECIMAL(4,0), 
    PRIMARY KEY (DEPARTMENT_ID, MANAGER_ID) 
);

CREATE TABLE employees ( 
    employee_id DECIMAL(6,0) NOT NULL, 
    first_name VARCHAR(50) NOT NULL, 
    last_name VARCHAR(50) NOT NULL, 
    email VARCHAR(100) NOT NULL, 
    phone_number VARCHAR(15), 
    hire_date DATE NOT NULL, 
    job_id VARCHAR(10) NOT NULL, 
    salary DECIMAL(8,2), 
    commission DECIMAL(8,2), 
    manager_id DECIMAL(6,0), 
    department_id DECIMAL(4,0) NOT NULL, 
    PRIMARY KEY (employee_id), 
    FOREIGN KEY (department_id, manager_id) REFERENCES departments (DEPARTMENT_ID, MANAGER_ID) 
);
