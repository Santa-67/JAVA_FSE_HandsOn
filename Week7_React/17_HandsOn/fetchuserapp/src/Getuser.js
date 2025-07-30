import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      person: null,
      loading: true
    };
  }

  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }

  render() {
    const { person, loading } = this.state;
    if (loading) {
      return <div>Loading...</div>;
    }
    return (
      <div style={{ textAlign: "center", marginTop: "40px" }}>
        <h2>User Details</h2>
        <div>
          <strong>Title:</strong> {person.name.title}
        </div>
        <div>
          <strong>First Name:</strong> {person.name.first}
        </div>
        <img src={person.picture.large} alt="User" style={{ marginTop: "20px", borderRadius: "10px" }} />
      </div>
    );
  }
}

export default Getuser;