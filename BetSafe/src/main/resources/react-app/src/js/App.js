
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

    const [currentUser, setCurrentUser] = useState("");

    const logOut = function() {
        window.localStorage.removeItem("token");
        setCurrentUser("");
        return <Navigate to="/" />;
    }

    const SignInWrapper = ({ children, currentUser }) => {
        return currentUser ? <Navigate to="/" replace /> : children;
    };



  return (
      <div className="App">
          <Header logOut={logOut} currentUser={currentUser} />
          <BrowserRouter>
              <TopNavbar setFilter={setFilter} />
              <Routes>
                  <Route exact path="/" element={<HomePage/>}/>
                  <Route exact path="/invest-page" element={<InvestPage filter={filter}/>}/>
                  <Route exact path="/fix-match-page" element={<FixMatchPage filter={filter}/>}/>
                  <Route exact path="/register" element={<Registration/>}/>
                  <Route exact path="/authenticate" element={<SignInWrapper currentUser={currentUser}>
                      <Login setCurrentUser={setCurrentUser}/>
                  </SignInWrapper>}/>
              </Routes>
          </BrowserRouter>
      </div>
  );
}

export default App;
