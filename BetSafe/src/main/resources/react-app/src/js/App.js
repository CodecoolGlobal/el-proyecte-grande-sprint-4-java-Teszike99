
import '../style/App.css';
import "@material-tailwind/react/tailwind.css";

import HomePage from "./components/appContents/HomePage";
import TopNavbar from './components/navbars/TopNavbar'
import InvestPage from "./components/appContents/InvestPage";

import {BrowserRouter, Routes, Route } from "react-router-dom";
import FixMatchPage from "./components/appContents/FixMatchPage";
import LeftNavbar from "./components/navbars/LeftNavbar";
import Header from "./components/navbars/Header";
import {useState} from "react";

function App() {

    let [filter, setFilter] = useState(null);

  return (
      <div className="App">
          <Header/>
          <BrowserRouter>
              <TopNavbar setFilter={setFilter} />
              <Routes>
                  <Route exact path="/" element={<HomePage/>}/>
                  <Route exact path="/invest-page" element={<InvestPage filter={filter}/>}/>
                  <Route exact path="/fix-match-page" element={<FixMatchPage filter={filter}/>}/>
              </Routes>
          </BrowserRouter>
      </div>
  );
}

export default App;
