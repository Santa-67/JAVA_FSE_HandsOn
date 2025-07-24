import React, { useState } from "react";
import CourseDetails from "./CourseDetails";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import ThemeContext from "./ThemeContext";

function App() {
  const [theme] = useState('light');
  const [showCourses] = useState(true);
  const [showBooks] = useState(true);
  const [showBlogs] = useState(true);

  const containerStyle = {
    display: "flex",
    justifyContent: "center",
    alignItems: "flex-start",
    marginTop: "60px",
    fontFamily: "Arial"
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div style={containerStyle}>
        <CourseDetails show={showCourses} />
        <BookDetails show={showBooks} />
        <BlogDetails show={showBlogs} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;