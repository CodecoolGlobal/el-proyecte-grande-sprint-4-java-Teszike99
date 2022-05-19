import {useState} from "react";

async function registerUser(user) {
    return fetch('/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(response => response.json());
}

export default function Registration() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const [message, setMessage] = useState("");

    const handleUsername = function(event) {
        setUsername(event.target.value)
    }
    const handlePassword = function(event) {
        setPassword(event.target.value)
    }

    const handleSubmit = async e => {
        e.preventDefault();
        const response = await registerUser({
            username,
            password
        });
        if(response.status === 500) {
            setMessage("Username is exist");
        }
        else {
            setMessage("Successful registration");

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
                <button type={"submit"} onClick={handleSubmit}>Register</button>
                {error? <p className={"error"}>{error}</p>:""}
                {message? <p className={"message"}>{message}</p>:""}
            </form>

        </div>
    )
}