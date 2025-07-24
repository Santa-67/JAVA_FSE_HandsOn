import React, { Component } from "react";

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  UpdateEntry = () => {
    this.setState(prevState => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  UpdateExit = () => {
    this.setState(prevState => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    const btnStyle = {
      background: "lightgreen",
      border: "1px solid #888",
      borderRadius: "4px",
      padding: "5px 15px",
      fontWeight: "bold",
      marginRight: "10px"
    };
    const boxStyle = {
      display: "inline-block",
      margin: "0 100px",
      marginTop: "100px"
    };
    return (
      <div style={{ textAlign: "center" }}>
        <div style={boxStyle}>
          <button style={btnStyle} onClick={this.UpdateEntry}>Login</button>
          <span style={{ color: "green", fontWeight: "500", marginLeft: "8px" }}>
            {this.state.entrycount} People Entered!!!
          </span>
        </div>
        <div style={boxStyle}>
          <button style={btnStyle} onClick={this.UpdateExit}>Exit</button>
          <span style={{ color: "green", fontWeight: "500", marginLeft: "8px" }}>
            {this.state.exitcount} People Left!!!
          </span>
        </div>
      </div>
    );
  }
}

export default CountPeople;