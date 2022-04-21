import Header from './components/Header';
import Body from './components/Body'
import Navbar from './components/Navbar'
import '../style/App.css';
import HomePage from "./components/HomePage";
import {useState} from "react";
import InvestPage from "./components/InvestPage";
import Office from "./components/Office";

function App() {
    const components = [<HomePage/>, <InvestPage/>, <Office/>] // Need this to change body contex
    const [componentIndex, setIndex] = useState(0); //use state hook
    function handleClick(page){
        if(page === "matches"){
            setIndex(1)
        }
        else if(page === "home"){
            setIndex(0)
        }
        else if (page === "office") {
            setIndex(2)
        }
    }
  return (
    <div className="App">
      <Header/>
        <Navbar component={components[componentIndex]} onClick={handleClick}/>
        <Body component={components[componentIndex]}/>
    </div>
  );
}

export default App;
