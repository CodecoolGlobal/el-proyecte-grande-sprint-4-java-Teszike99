import Header from './components/Header';
import Body from './components/Body'
import Navbar from './components/Navbar'


import './App.css';
import {dataHandler} from "./data/DataHandler";
function App() {
    dataHandler.getProfitableMatchPairs().then(r => {
        console.log(r)
    })
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
