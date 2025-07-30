import React from "react";

function BlogDetails({ show }) {
  // Conditional rendering using ternary operator
  const blogs = [
    {
      title: "React Learning",
      author: "Stephen Biz",
      content: "Welcome to learning React!"
    },
    {
      title: "Installation",
      author: "Schewzdenier",
      content: "You can install React from npm."
    }
  ];
  return show ? (
    <div style={{ flex: 1, marginLeft: "40px" }}>
      <h2>Blog Details</h2>
      {blogs.map((blog, idx) => (
        <div key={idx}>
          <h3 style={{ fontWeight: "bold" }}>{blog.title}</h3>
          <div style={{ fontWeight: "bold" }}>{blog.author}</div>
          <div>{blog.content}</div>
        </div>
      ))}
    </div>
  ) : null;
}

export default BlogDetails;