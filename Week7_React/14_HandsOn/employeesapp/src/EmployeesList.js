import React from "react";
import EmployeeCard from "./EmployeeCard";

function EmployeesList({ employees }) {
  return (
    <div>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;