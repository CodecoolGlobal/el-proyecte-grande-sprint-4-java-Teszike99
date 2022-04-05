export let dataHandler = {

    getProfitableMatchPairs: async function () {
        console.log("LOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOL")
        const response = await apiGet("/index/profit-matches");
        console.log(response + "LOOOOOOOOOOOOOOOOOOOOOL");
        return response;
    }

};

async function apiGet(url) {
    let response = await fetch(url, {
        method: "GET",
    });
    if (response.status === 200) {
        let data = response.json();
        return data;
    }
}

async function apiPost(url, payload) {
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