Employee API Tests

Scenario: Create Employee
Given RestFul api url for employee '/employee'
When POST request is sent for create Employee
Then Employee should be created
And Status code should be 200

Scenario: Read one Employee
Given RestFul api url for employee
When GET request is sent with unique employee id
Then Employee record with given id should be fetched
And Status code should be 200

Scenario: Read all Employee
Given RestFul api url for employee
When GET all request is sent for Employee
Then All Employee records should be fetched
And Status code should be 200

Scenario: Update Employee
Given RestFul api url for employee
When PUT request is sent with unique employee id
Then Employee record should be updated
And Status code should be 200

Scenario: Delete Employee
Given RestFul api url for employee
When DELETE request is sent with unique employee id
Then Employee record with given id should be deleted
And Status code should be 200