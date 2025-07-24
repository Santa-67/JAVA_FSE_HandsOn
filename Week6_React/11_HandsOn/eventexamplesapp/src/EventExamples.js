import React, { Component } from "react";

class EventExamples extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 5,
      amount: "",
      currency: ""
    };
  }

  increment = () => {
    this.setState(prevState => ({
      counter: prevState.counter + 1
    }));
  };

  sayHello = msg => {
    alert(msg);
  };

  handleIncrementClick = () => {
    this.increment();
    this.sayHello("Hello! Member1");
  };

  decrement = () => {
    this.setState(prevState => ({
      counter: prevState.counter - 1
    }));
  };

  handleAmountChange = e => {
    this.setState({ amount: e.target.value });
  };

  handleCurrencyChange = e => {
    this.setState({ currency: e.target.value });
  };

  handleSubmit = e => {
    e.preventDefault();
    const { amount, currency } = this.state;
    if (currency.toLowerCase() === "euro") {
      const euroAmount = parseFloat(amount) * 80;
      alert(`Converting to Euro Amount is ${euroAmount}`);
    } else {
      alert(`Please enter 'Euro' as currency to convert.`);
    }
  };

  handlePress = () => {
    alert("I was clicked");
  };

  render() {
    const headingStyle = {
      color: "green",
      fontWeight: "bold",
      fontSize: "2em",
      marginTop: "30px"
    };
    return (
      <div>
        <div>{this.state.counter}</div>
        <button onClick={this.handleIncrementClick}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayHello("welcome")}>Say welcome</button>
        <button onClick={this.handlePress}>Click on me</button>
        <div style={headingStyle}>Currency Convertor!!!</div>
        <form onSubmit={this.handleSubmit}>
          <div>
            Amount:{" "}
            <input
              type="text"
              value={this.state.amount}
              onChange={this.handleAmountChange}
            />
          </div>
          <div>
            Currency:{" "}
            <input
              type="text"
              value={this.state.currency}
              onChange={this.handleCurrencyChange}
            />
          </div>
          <button type="submit">Convert</button>
        </form>
      </div>
    );
  }
}

export default EventExamples;