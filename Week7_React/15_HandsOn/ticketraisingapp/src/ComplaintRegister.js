import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      complaint: ""
    };
  }

  handleNameChange = e => {
    this.setState({ name: e.target.value });
  };

  handleComplaintChange = e => {
    this.setState({ complaint: e.target.value });
  };

  handleSubmit = e => {
    e.preventDefault();
    const transactionId = Math.floor(Math.random() * 100) + 1;
    alert(
      `Thanks ${this.state.name}\nYour Complaint was Submitted.\nTransaction ID is: ${transactionId}`
    );
    // Optionally reset form
    this.setState({ name: "", complaint: "" });
  };

  render() {
    const headingStyle = {
      color: "red",
      fontWeight: "bold",
      fontSize: "2em",
      textAlign: "center",
      marginTop: "40px"
    };
    return (
      <div>
        <div style={headingStyle}>Register your complaints here!!!</div>
        <form onSubmit={this.handleSubmit} style={{ textAlign: "center", marginTop: "20px" }}>
          <div>
            <label>Name: </label>
            <input
              type="text"
              value={this.state.name}
              onChange={this.handleNameChange}
            />
          </div>
          <div style={{ marginTop: "10px" }}>
            <label>Complaint: </label>
            <textarea
              value={this.state.complaint}
              onChange={this.handleComplaintChange}
              rows={2}
              cols={25}
            />
          </div>
          <div style={{ marginTop: "10px" }}>
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;