import React, { useEffect, useState } from "react";
import './App.css';


function Todolist(){
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/todos")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setTodos(data);
        setLoading(false);
      })
      .catch((error) => {
        setError(error.message);
        setLoading(false);
      });
  }, []);
  
  if (loading) {
    return <div>Loading...</div>;
  }
  
  if (error) {
    return <div>Error: {error}</div>;
  }
  
  return (
     <div className="container">
      <h1>Todo List</h1>
      <div className="todo-grid">
        {todos.map(todo => (
          <div 
            key={todo.id} 
            className={`todo-item ${todo.completed ? 'completed' : ''}`}
          >
            <h3>{todo.id}. {todo.title}</h3>
            <p>Status: 
              <span className={todo.completed ? 'status-done' : 'status-pending'}>
                {todo.completed ? ' Done' : ' Pending'}
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );

}
export default Todolist;