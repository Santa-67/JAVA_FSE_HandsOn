import React from "react";

const offices = [
  {
    name: "DBS",
    rent: 50000,
    address: "Chennai",
    image: "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80"
  },
  {
    name: "Regus",
    rent: 65000,
    address: "Bangalore",
    image: "https://images.unsplash.com/photo-1464983953574-0892a716854b?auto=format&fit=crop&w=400&q=80"
  },
  {
    name: "WeWork",
    rent: 55000,
    address: "Hyderabad",
    image: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=400&q=80"
  }
];

function OfficeSpace() {
  const headingStyle = {
    textAlign: "center",
    fontWeight: "bold",
    fontSize: "2em",
    marginTop: "40px"
  };
  const officeStyle = {
    margin: "30px auto",
    width: "400px",
    textAlign: "center"
  };
  const nameStyle = {
    fontWeight: "bold",
    fontSize: "1.5em",
    marginTop: "20px"
  };
  const rentStyle = rent => ({
    color: rent < 60000 ? "red" : "green",
    fontWeight: "bold",
    fontSize: "1.2em"
  });
  const addressStyle = {
    fontWeight: "bold"
  };

  return (
    <div>
      <div style={headingStyle}>Office Space , at Affordable Range</div>
      {offices.map((office, idx) => (
        <div key={idx} style={officeStyle}>
          <img src={office.image} alt={office.name} width="300" height="200" />
          <div style={nameStyle}>Name: {office.name}</div>
          <div style={rentStyle(office.rent)}>
            Rent: Rs. {office.rent}
          </div>
          <div style={addressStyle}>Address: {office.address}</div>
        </div>
      ))}
    </div>
  );
}

export default OfficeSpace;