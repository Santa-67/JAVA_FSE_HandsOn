import React from "react";

function GuestPage({ onLogin }) {
  const flights = [
    { id: 1, from: "Chennai", to: "Delhi", time: "10:00 AM" },
    { id: 2, from: "Mumbai", to: "Bangalore", time: "2:00 PM" },
    { id: 3, from: "Kolkata", to: "Hyderabad", time: "6:00 PM" }
  ];

  return (
    <div>
      <h2>Flight Details</h2>
      <ul>
        {flights.map(flight => (
          <li key={flight.id}>
            {flight.from} to {flight.to} - {flight.time}
          </li>
        ))}
      </ul>
      <button onClick={onLogin}>Login</button>
    </div>
  );
}

export default GuestPage;