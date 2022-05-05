import {useEffect, useState} from "react";

export default function Profile() {
    const [secret, setSecret] = useState();


    async function fetchProfile(token) {
        return fetch('/user', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }
        })
            .then(data=>data.json()).then(data=>setSecret(data))

    }

    useEffect(async () => {
        const authToken = window.localStorage.getItem("authToken");
        if (authToken) {
            await fetchProfile(authToken);
        }
    }, [])

    return (
        <div>
            {secret?
                <div>
                    <p>Username: {secret.username}</p>
                    <p>Role: {secret.role}</p>

                </div>
                :
                ""}
        </div>
    )
}