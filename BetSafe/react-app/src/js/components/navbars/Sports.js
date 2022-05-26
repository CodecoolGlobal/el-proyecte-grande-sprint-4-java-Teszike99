import React from "react";
import Dropdown from "@material-tailwind/react/Dropdown"
import DropdownLink from "@material-tailwind/react/DropdownLink"
import NavLink from "@material-tailwind/react/NavLink";

const SportDropdown = (props) => {
    return (
        <NavLink className="new-navbar">
        <Dropdown
            color="dark"
            placement="bottom-start"
            buttonText="Sports"
            buttonType="filled"
            size="lg"
            rounded={false}
            block={false}
            ripple="dark"
        >
            <DropdownLink
                color="#1f1f1f;"
                ripple="light"
                onClick={_event => props.setFilter("tennis")}
            >
                Tennis
            </DropdownLink>
            <DropdownLink
                color="#1f1f1f;"
                ripple="light"
                onClick={_event => props.setFilter("E-sport")}>
                E-Sport
            </DropdownLink>
            <DropdownLink
                color="#1f1f1f;"
                ripple="light"
                onClick={_event => props.setFilter("Ping-Pong")}
            >
                Ping-Pong
            </DropdownLink>
        </Dropdown>
        </NavLink>
    )
}

export default SportDropdown