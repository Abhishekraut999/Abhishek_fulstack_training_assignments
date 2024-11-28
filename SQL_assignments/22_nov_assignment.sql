-- question_1
SELECT E.FirstName, E.LastName
FROM Employees E
JOIN Departments D ON E.DepartmentID = D.DepartmentID
WHERE D.DepartmentName = 'IT';

-- question_2
SELECT FirstName, LastName, HireDate
FROM Employees
WHERE HireDate > '2010-01-01';

-- question_3
SELECT ProjectName, Budget
FROM Projects
WHERE Budget > 80000;

-- question_4
SELECT FirstName, LastName, HireDate
FROM Employees
ORDER BY HireDate DESC;

-- question_5
SELECT ProjectName, Budget
FROM Projects
ORDER BY Budget ASC;

-- question_6
SELECT D.DepartmentName, COUNT(E.EmployeeID) AS NumberOfEmployees
FROM Employees E
JOIN Departments D ON E.DepartmentID = D.DepartmentID
GROUP BY D.DepartmentName;

-- question_7
SELECT FirstName, LastName, BaseSalary
FROM Employees E
JOIN Salaries S ON E.EmployeeID = S.EmployeeID
ORDER BY BaseSalary DESC
LIMIT 3;

-- question_8
SELECT E.FirstName, E.LastName, D.DepartmentName
FROM Employees E
JOIN Departments D ON E.DepartmentID = D.DepartmentID;

-- question_9
SELECT E.FirstName, E.LastName, P.ProjectName, A.HoursWorked
FROM Assignments A
JOIN Employees E ON A.EmployeeID = E.EmployeeID
JOIN Projects P ON A.ProjectID = P.ProjectID;

-- question_10
SELECT E.FirstName, E.LastName
FROM Assignments A
JOIN Employees E ON A.EmployeeID = E.EmployeeID
JOIN Projects P ON A.ProjectID = P.ProjectID
WHERE P.Budget = (SELECT MAX(Budget) FROM Projects);

-- question_11
SELECT FirstName, LastName,
TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) AS Age
FROM Employees;

-- question_12
SELECT E.FirstName, E.LastName, (S.BaseSalary + IFNULL(S.Bonus, 0)) AS TotalSalary
FROM Employees E
JOIN Salaries S ON E.EmployeeID = S.EmployeeID;

-- question_13
SELECT FirstName, LastName, HireDate
FROM Employees
WHERE YEAR(HireDate) = 2015;

-- question_14
SELECT ProjectName, EndDate
FROM Projects
WHERE EndDate < '2023-12-01';

-- question_15
SELECT E.FirstName, E.LastName, S.BaseSalary
FROM Employees E
JOIN Salaries S ON E.EmployeeID = S.EmployeeID
WHERE S.BaseSalary > 70000;

-- question_16
SELECT E.FirstName, E.LastName, COUNT(A.ProjectID) AS NumberOfProjects
FROM Employees E
JOIN Assignments A ON E.EmployeeID = A.EmployeeID
GROUP BY E.EmployeeID;

-- question_17
SELECT DepartmentName
FROM Departments
WHERE Location = 'San Francisco';

-- question_18
SELECT P.ProjectName, SUM(A.HoursWorked) AS TotalHoursWorked
FROM Assignments A
JOIN Projects P ON A.ProjectID = P.ProjectID
GROUP BY P.ProjectName;

-- question_19
SELECT MAX(Bonus) AS HighestBonus
FROM Salaries;

-- question_20
SELECT ProjectName, DATEDIFF(EndDate, StartDate) AS DurationInDays
FROM Projects
WHERE DATEDIFF(EndDate, StartDate) > 365;

-- question_21
SELECT ProjectName, StartDate
FROM Projects
WHERE YEAR(StartDate) = 2023;

-- question_22
SELECT E.FirstName, E.LastName, SUM(A.HoursWorked) AS TotalHoursWorked
FROM Employees E
JOIN Assignments A ON E.EmployeeID = A.EmployeeID
GROUP BY E.EmployeeID;

-- question_23
SELECT D.DepartmentName
FROM Departments D
JOIN Employees E ON D.DepartmentID = E.DepartmentID
GROUP BY D.DepartmentID
ORDER BY COUNT(E.EmployeeID) DESC
LIMIT 1;

-- question_24
SELECT FirstName, LastName, DateOfBirth
FROM Employees
WHERE DateOfBirth < '1985-01-01';
