REM   Script: Activity3
REM   In this activity, we will be writing different SELECT statements with WHERE clause.

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';