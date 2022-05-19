import React from "react";

const SportDropdown = (props) => {
    return (

        <a className="false false px-5 py-4 flex gap-1 items-center text-2xl uppercase font-medium leading text-white rounded-lg">
            <div><a
                className="false false flex gap-1 items-center text-xs uppercase font-medium leading text-white rounded-lg">
                <div>
                    <div className="dropdown">
                        <button className="false flex items-center justify-center gap-1 rounded-lg font-bold outline-none capitalize tracking-wider focus:outline-none transition-all duration-300 rounded py-3 pl-8 pr-6 text-2xl leading-relaxed text-white dropbtn"
                                type="button" aria-expanded="false">Sports<span
                            className="material-icons text-lg leading-none align-middle">arrow_drop_down</span></button>
                        <div className="dropdown-content">
                            <a onClick={_event => props.setFilter("tennis")}>Tennis</a>
                            <a onClick={_event => props.setFilter("E-sport")}>E-sport</a>
                            <a onClick={_event => props.setFilter("Ping-Pong")}>Ping-Pong</a>
                        </div>
                    </div>
                </div>
            </a></div>
        </a>

    )
}

export default SportDropdown