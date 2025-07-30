import React, { Component } from "react";

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      password: "",
      errors: {}
    };
  }

  handleChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };

  validate = () => {
    const errors = {};
    if (this.state.name.length < 5) {
      errors.name = "Name should have at least 5 characters";
    }
    if (!this.state.email.includes("@") || !this.state.email.includes(".")) {
      errors.email = "Email should contain @ and .";
    }
    if (this.state.password.length < 8) {
      errors.password = "Password should have at least 8 characters";
    }
    return errors;
  };

  handleSubmit = e => {
    e.preventDefault();
    const errors = this.validate();
    if (Object.keys(errors).length > 0) {
      this.setState({ errors });
    } else {
      alert("Registration Successful!");
      this.setState({
        name: "",
        email: "",
        password: "",
        errors: {}
      });
    }
  };

  render() {
    return (
      <div style={{ margin: "40px auto", width: "350px" }}>
        <h2>Register</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            Name:{" "}
            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
            />
            <div style={{ color: "red" }}>{this.state.errors.name}</div>
          </div>
          <div>
            Email:{" "}
            <input
              type="text"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
            <div style={{ color: "red" }}>{this.state.errors.email}</div>
          </div>
          <div>
            Password:{" "}
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
            <div style={{ color: "red" }}>{this.state.errors.password}</div>
          </div>
          <button type="submit" style={{ marginTop: "10px" }}>Register</button>
        </form>
      </div>
    );
  }
}

export default Register;