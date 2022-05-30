import React from "react";


const User = (props) => {
    return (

            <div><a
                className="false false flex gap-1 items-center text-xs uppercase font-medium leading text-white rounded-lg">
                <div>
                    <div className="dropdown">
                        <button className="false false px-5 py-4 flex gap-1 items-center text-2xl uppercase font-medium leading text-white rounded-lg nav-direct"><span
                            className="material-icons undefined undefined leading-none">account_circle</span></button>
                        <div className="dropdown-content">
                            {window.localStorage.getItem("username") ?
                                <a>
                                    {window.localStorage.getItem("username")}
                                </a>
                                :
                                <p>
                                    <a href="/authenticate">Login</a>
                                </p>}
                            {window.localStorage.getItem("username") ?
                                <p><a onClick={() => {
                                    props.logOut();
                                }}>Log out</a></p>
                                :
                                <p>
                                    <a href="/register">Register</a>
                                </p>
                            }
                        </div>
                    </div>
                </div>
            </a></div>
    )
}

export default User;

