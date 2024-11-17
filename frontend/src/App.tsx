import { useEffect, useState } from "react";
import viteLogo from "/vite.svg";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);
  const [greeting, setGreeting] = useState("Hello from Vite!");
  const [picture, setPicture] = useState(viteLogo);
  const [joke, setJoke] = useState("");
  const [quote, setQuote] = useState("");
  const [age, setAge] = useState(undefined as number | undefined);

  useEffect(() => {
    if (count !== 0) {
      fetch("/api/profile/greetings?name=Ola")
        .then((res) => res.json())
        .then((data) => setGreeting(data.greeting));
      fetch("/api/profile/profile-picture")
        .then((res) => res.json())
        .then((data) => setPicture(data.message));
      fetch("/api/profile/joke")
        .then((res) => res.json())
        .then((data) => setJoke(data.value));
      fetch("/api/profile/quote?category=happiness")
        .then((res) => res.json())
        .then((data) => setQuote(data.quote));
      fetch("/api/profile/age?name=Ola")
        .then((res) => res.json())
        .then((data) => setAge(data.age));
    }
  }, [count]);

  return (
    <>
      <div>
        <a href={picture} target="_blank">
          <img src={picture} className="logo" alt="Vite logo" />
        </a>
      </div>
      <div>
        <h1>{greeting}</h1>
        {age && <p>Guessed age: {age}</p>}
      </div>
      {joke && (
        <div className="card">
          <h2>Joke of the day</h2>
          <p>{joke}</p>
        </div>
      )}
      {quote && (
        <div className="card">
          <h2>Quote of the day</h2>
          <p>{quote}</p>
        </div>
      )}
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          update count {count}
        </button>
      </div>
    </>
  );
}

export default App;
