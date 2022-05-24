export async function apiGet(url) {
        let response = await fetch(url, {
            method: "GET",
        });
        if (response.status === 200) {
            let data = response.json();
            return data;
        }
}

export async function apiPost(url, payload) {
    let response = await fetch(url, {
        method: "POST",
        headers: {"Content-type": "application/json"},
        body: JSON.stringify(payload)
    });
    if (response.status === 200) {
        let data = response.json();
        return data;

    }
}

export async function apiGetWithJwt(url, jwt) {
    let response = await fetch(url, {
        method: "GET",
        headers: {"Content-type": "application/json", "Authorization": "Bearer " +jwt},
    });
    if (response.status === 200) {
        let data = response.json();
        return data;
    }
}