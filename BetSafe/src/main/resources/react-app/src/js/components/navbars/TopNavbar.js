import React, { useState } from "react";
import Navbar from "@material-tailwind/react/Navbar";
import NavbarContainer from "@material-tailwind/react/NavbarContainer";
import NavbarCollapse from "@material-tailwind/react/NavbarCollapse";
import Nav from "@material-tailwind/react/Nav";
import NavbarInput from "@material-tailwind/react/NavbarInput";
import Icon from "@material-tailwind/react/Icon";
import Sports from "./Sports";
import Offices from "./Offices";
import NavLink from "@material-tailwind/react/NavLink";
import {Link} from "react-router-dom";

const TopNavbar = (props) => {
    const [openNavbar, setOpenNavbar] = useState(true);

    return (
        <Navbar color="#333" navbar className="new-navbar">
            <NavbarContainer>
                <NavbarCollapse open={openNavbar}>
                    <Nav leftSide>
                        <NavLink href="/" ripple="light" >
                            <Icon name="home" size="xxl" />
                            Home
                        </NavLink>
                        <NavLink href="/invest-page" ripple="light">
                            <Icon name="language" size="xxl" />
                            Profit calculator
                        </NavLink>
                        <NavLink href="/fix-match-page" ripple="light">
                            <Icon name="settings" size="xxl" />
                            Fix profitable matches
                        </NavLink>
                        <Sports setFilter={props.setFilter} />
                        <Offices setFilter={props.setFilter} />
                    </Nav>
                    <NavbarInput type="text" placeholder="Search here" />
                    <NavLink href="/register" ripple="light">
                        <Icon name="account_circle" size="xxl" />
                    </NavLink>
                </NavbarCollapse>
            </NavbarContainer>
        </Navbar>
    );
}

export default TopNavbar;