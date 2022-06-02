import {useState} from "react";
import {apiPost} from "../../data/dataHandler";
import {useNavigate} from "react-router-dom";


export default function Login(props) {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();


    const handleUsername = function(event) {
        setUsername(event.target.value)
    }
    const handlePassword = function(event) {
        setPassword(event.target.value)
    }

    const handleSubmit = async e => {
        e.preventDefault();
        await loginUser({
            username,
            password
        });
    }

    function setUpLogin(token) {
        if(token) {
            window.localStorage.setItem("token", token.token);
            window.localStorage.setItem("username", username);
            props.setCurrentUser(username);
            navigate("/");
        }
        else {
            setError("Failed to log in.")
        }
    }

    async function loginUser(loginData) {
        return apiPost("/authenticate",loginData)
            .then(r => {setUpLogin(r)});

    }

    return (
        <div className="register-container">
            <form>
                <div>
                    <label htmlFor={"username"}>Username</label><br/>
                    <input id={"username"}
                           type={"text"}
                           value={username}
                           onChange={handleUsername}
                    />
                </div>
                <div>
                    <label htmlFor={"password"}>Password</label><br/>
                    <input id={"password"}
                           type={"password"}
                           value={password}
                           onChange={handlePassword}
                    />
                </div>
                <button type={"submit"} onClick={handleSubmit}>Log In</button>
                {error? <p className={"error"}>{error}</p>:""}
            </form>
        </div>
    )
}