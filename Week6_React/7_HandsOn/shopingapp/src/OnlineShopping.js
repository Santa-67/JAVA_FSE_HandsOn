import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        new Cart("Laptop", 80000),
        new Cart("TV", 120000),
        new Cart("Washing Machine", 50000),
        new Cart("Mobile", 30000),
        new Cart("Fridge", 70000)
      ]
    };
  }

  render() {
    const headingStyle = {
      color: "green",
      textAlign: "center",
      marginTop: "30px"
    };
    const tableStyle = {
      margin: "auto",
      borderCollapse: "collapse",
      width: "350px"
    };
    const thTdStyle = {
      border: "1px solid grey",
      padding: "8px",
      color: "green",
      textAlign: "center"
    };
    const thStyle = {
      ...thTdStyle,
      fontWeight: "bold",
      fontSize: "18px",
      background: "#f8f8f8"
    };

    return (
      <div>
        <h1 style={headingStyle}>Items Ordered :</h1>
        <table style={tableStyle}>
          <thead>
            <tr>
              <th style={thStyle}>Name</th>
              <th style={thStyle}>Price</th>
            </tr>
          </thead>
          <tbody>
            {this.state.items.map((item, idx) => (
              <tr key={idx}>
                <td style={thTdStyle}>{item.itemname}</td>
                <td style={thTdStyle}>{item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;