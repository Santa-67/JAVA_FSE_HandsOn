import React from "react";

function BookDetails({ show }) {
  // Conditional rendering using logical AND
  const books = [
    { title: "Master React", price: 670 },
    { title: "Deep Dive into Angular 11", price: 800 },
    { title: "Mongo Essentials", price: 450 }
  ];
  return (
    show && (
      <div style={{ flex: 1, marginRight: "40px", borderLeft: "4px solid green", borderRight: "4px solid green", padding: "0 40px" }}>
        <h2>Book Details</h2>
        {books.map((book, idx) => (
          <div key={idx}>
            <h3 style={{ fontWeight: "bold" }}>{book.title}</h3>
            <div>{book.price}</div>
          </div>
        ))}
      </div>
    )
  );
}

export default BookDetails;