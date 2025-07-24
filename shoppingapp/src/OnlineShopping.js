import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        new Cart("Laptop", 50000),
        new Cart("Smartphone", 20000),
        new Cart("Headphones", 1500),
        new Cart("Shoes", 2500),
        new Cart("Watch", 3000)
      ]
    };
  }

  render() {
    return (
      <div>
        <h2>Online Shopping Cart</h2>
        <ul>
          {this.state.items.map((item, idx) => (
            <li key={idx}>
              {item.itemname} - ₹{item.price}
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default OnlineShopping;