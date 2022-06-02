
import '../style/App.css';
import "@material-tailwind/react/tailwind.css";

import HomePage from "./components/appContents/HomePage";
import TopNavbar from './components/navbars/TopNavbar'
import InvestPage from "./components/appContents/InvestPage";

import {BrowserRouter, Routes, Route, Navigate} from "react-router-dom";
import FixMatchPage from "./components/appContents/FixMatchPage";
import Header from "./components/navbars/Header";
import {useState} from "react";
import Login from "./components/contentTools/Login";
import Registration from "./components/contentTools/Registration";

function App() {

    let [filter, setFilter] = useState(null);
    const [currentUser, setCurrentUser] = useState(window.localStorage.getItem("username"));

    const logOut = function() {
        window.localStorage.removeItem("token");
        window.localStorage.removeItem("username");
        console.log("valami")
        setCurrentUser("");
        //return <Navigate to="/" />
    }

  return (
      <div className="App">
          <Header/>
          <BrowserRouter>
              <TopNavbar setFilter={setFilter} logOut={logOut} currentUser={currentUser} />
              <Routes>
                  <Route exact path="/" element={<HomePage/>}/>
                  <Route exact path="/invest-page" element={<InvestPage filter={filter}/>}/>
                  <Route exact path="/fix-match-page" element={<FixMatchPage filter={filter}/>}/>
                  <Route exact path="/register" element={<Registration/>}/>
                  <Route exact path="/authenticate" element={<Login setCurrentUser={setCurrentUser}/>}/>
              </Routes>
          </BrowserRouter>
      </div>
  );
}

export default App;
