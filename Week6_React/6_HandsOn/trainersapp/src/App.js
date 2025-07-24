import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainersList from "./Trainerlist";
import TrainerDetail from "./TrainerDetails";
import trainersMock from "./TrainerMock";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <nav style={{ margin: "10px" }}>
          <Link to="/" style={{ marginRight: "10px" }}>Home</Link>
          <Link to="/trainers">Trainers</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={trainersMock} />} />
          <Route path="/trainer/:id" element={<TrainerDetail />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
