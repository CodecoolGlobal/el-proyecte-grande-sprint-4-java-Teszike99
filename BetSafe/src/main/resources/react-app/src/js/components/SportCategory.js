

const SportCategory = (props) => {
    return (
        <div className="left-nav col-md">
            <a href="#" onClick={(event) => {props.filterFunc(event.currentTarget.innerText)}}>Tennis</a><br></br>
            <a href="#" onClick={(event) => {props.filterFunc(event.currentTarget.innerText)}}>Ping-Pong</a><br></br>
            <a href="#" onClick={(event) => {props.filterFunc(event.currentTarget.innerText)}}>E-sport</a><br></br>
        </div>
    )
}

export default SportCategory;