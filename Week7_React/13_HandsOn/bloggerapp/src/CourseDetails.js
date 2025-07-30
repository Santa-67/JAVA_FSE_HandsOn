import React from "react";

function CourseDetails({ show }) {
  if (!show) return null; // Conditional rendering using if
  const courses = [
    { name: "Angular", date: "4/5/2021" },
    { name: "React", date: "6/3/20201" }
  ];
  return (
    <div style={{ flex: 1, marginRight: "40px" }}>
      <h2>Course Details</h2>
      {courses.map((course, idx) => (
        <div key={idx}>
          <h3 style={{ fontWeight: "bold" }}>{course.name}</h3>
          <div>{course.date}</div>
        </div>
      ))}
    </div>
  );
}

export default CourseDetails;