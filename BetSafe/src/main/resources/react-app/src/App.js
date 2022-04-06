import Header from './components/Header';
import Body from './components/Body'
import Navbar from './components/Navbar'
import './App.css';

function App() {

    const title = "Header lol"

  return (
    <div className="App">
      <Header title={title}/>
      <Navbar />
      <Body />
    </div>
  );
}

export default App;
