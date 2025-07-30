import React from "react";

function IndianPlayers() {
  // Odd/Even Players with index and destructuring
  const teamPlayers = [
    "Sachin1",
    "Dhoni2",
    "Virat3",
    "Rohit4",
    "Yuvaraj5",
    "Raina6"
  ];

  // Odd index: 0,2,4; Even index: 1,3,5
  const oddPlayers = [
    { label: "First", name: teamPlayers[0] },
    { label: "Third", name: teamPlayers[2] },
    { label: "Fifth", name: teamPlayers[4] }
  ];
  const evenPlayers = [
    { label: "Second", name: teamPlayers[1] },
    { label: "Fourth", name: teamPlayers[3] },
    { label: "Sixth", name: teamPlayers[5] }
  ];

  // Merge two arrays
  const T20players = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player"
  ];
  const RanjiTrophyPlayers = [
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player"
  ];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h1>Odd Players</h1>
      <ul>
        {oddPlayers.map((p, i) => (
          <li key={i}>
            {p.label} : {p.name}
          </li>
        ))}
      </ul>
      <hr />
      <h1>Even Players</h1>
      <ul>
        {evenPlayers.map((p, i) => (
          <li key={i}>
            {p.label} : {p.name}
          </li>
        ))}
      </ul>
      <hr />
      <h1>List of Indian Players Merged:</h1>
      <ul>
        {mergedPlayers.map((p, i) => (
          <li key={i}>{p}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;