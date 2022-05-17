import {useState} from "react";

async function loginUser(loginData) {
    return fetch('/authenticate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
        .then(data => data.json())
}

export default function Login(props) {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleUsername = function(event) {
        setUsername(event.target.value)
    }
    const handlePassword = function(event) {
        setPassword(event.target.value)
    }

    const handleSubmit = async e => {
        e.preventDefault();
        const token = await loginUser({
            username,
            password
        });
        if (token.jwt) {
            props.setCurrentUser(username);
            window.localStorage.setItem("authToken", token.jwt);
        } else {
            setError("Failed to log in.")
            console.log("ooooo")
        }
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