export default async function apiGet(url) {
        let response = await fetch(url, {
            method: "GET",
        });
        if (response.status === 200) {
            let data = response.json();
            return data;
        }
}