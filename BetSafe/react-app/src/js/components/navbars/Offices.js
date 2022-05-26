import React from "react";
import Dropdown from "@material-tailwind/react/Dropdown"
import DropdownLink from "@material-tailwind/react/DropdownLink"
import NavLink from "@material-tailwind/react/NavLink";

const OfficesDropdown = (props) => {
    return (
        <NavLink className="new-navbar">
            <Dropdown
                color="dark"
                placement="bottom-start"
                buttonText="Offices"
                buttonType="filled"
                size="lg"
                rounded={false}
                block={false}
                ripple="dark">
                <DropdownLink
                    color="#1f1f1f;"
                    ripple="light"
                    onClick={_event => props.setFilter("BetterBet")}>
                    BetterBet
                </DropdownLink>
                <DropdownLink
                    color="#1f1f1f;"
                    ripple="light"
                    onClick={_event => props.setFilter("Esport")}>
                    Esport
                </DropdownLink>
                <DropdownLink
                    color="#1f1f1f;"
                    ripple="light"
                    onClick={_event => props.setFilter("MegaGame")}>
                    MegaGame
                </DropdownLink>
                <DropdownLink
                    color="#1f1f1f;"
                    ripple="light"
                    onClick={_event => props.setFilter("UniBet")}>
                    UniBet
                </DropdownLink>
            </Dropdown>
        </NavLink>
    )
}

export default OfficesDropdown