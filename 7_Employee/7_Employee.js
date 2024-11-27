class Employee {
    constructor(name, id, skill, doj, department) {
        this.name = name;
        this.id = id;
        this.skill = skill;
        this.doj = new Date(doj);  
        this.department = department;
    }

    getExperience() {
        const today = new Date();
        const years = today.getFullYear() - this.doj.getFullYear();
        const months = today.getMonth() - this.doj.getMonth();
        return months < 0 ? years - 1 : years;
    }

    getDetails() {
        return `
            <h3>Employee Details</h3>
            <p><strong>Name:</strong> ${this.name}</p>
            <p><strong>ID:</strong> ${this.id}</p>
            <p><strong>Skill:</strong> ${this.skill}</p>
            <p><strong>Date of Joining (DOJ):</strong> ${this.doj.toDateString()}</p>
            <p><strong>Department:</strong> ${this.department}</p>
            <p><strong>Experience:</strong> ${this.getExperience()} years</p>
        `;
    }
}

class EmployeeManagementSystem {
    constructor() {
        this.employees = [];
    }

    addEmployee(name, id, skill, doj, department) {
        const employee = new Employee(name, id, skill, doj, department);
        this.employees.push(employee);
        this.displayEmployees();
    }

    removeEmployee(id) {
        this.employees = this.employees.filter(employee => employee.id !== id);
        this.displayEmployees();
    }

    searchEmployee(id) {
        const employee = this.employees.find(emp => emp.id === id);
        const detailsDiv = document.getElementById('employee-details');
        detailsDiv.innerHTML = employee ? employee.getDetails() : `<p>No employee found with ID ${id}</p>`;
    }

    displayEmployees() {
        const employeeList = document.getElementById('employee-list').getElementsByTagName('tbody')[0];
        employeeList.innerHTML = '';  

        this.employees.forEach(employee => {
            const row = employeeList.insertRow();
            row.innerHTML = `
                <td>${employee.name}</td>
                <td>${employee.id}</td>
                <td>${employee.skill}</td>
                <td>${employee.doj.toDateString()}</td>
                <td>${employee.department}</td>
                <td>${employee.getExperience()} years</td>
            `;
        });
    }
}

const ems = new EmployeeManagementSystem();

function addEmployee() {
    const name = document.getElementById('name').value;
    const id = document.getElementById('id').value;
    const skill = document.getElementById('skill').value;
    const doj = document.getElementById('doj').value;
    const department = document.getElementById('department').value;

    if (name && id && skill && doj && department) {
        ems.addEmployee(name, Number(id), skill, doj, department);
        clearInputs();
    } else {
        alert("Please fill all fields.");
    }
}

function removeEmployee() {
    const id = document.getElementById('remove-id').value;
    if (id) {
        ems.removeEmployee(Number(id));  
        document.getElementById('remove-id').value = '';  
    } else {
        alert("Please enter an ID.");
    }
}

function searchEmployee() {
    const id = document.getElementById('search-id').value;
    if (id) {
        ems.searchEmployee(Number(id)); 
    } else {
        alert("Please enter an ID to search.");
    }
}

function clearInputs() {
    document.getElementById('name').value = '';
    document.getElementById('id').value = '';
    document.getElementById('skill').value = '';
    document.getElementById('doj').value = '';
    document.getElementById('department').value = '';
}
