import Sports from "./Sports";
import Offices from "./Offices";
import User from "./User"
import Registration from "../contentTools/Registration";

const TopNavbar = (props) => {

    return (


        <nav className="flex flex-wrap items-center justify-between py-2.5 px-3 mb-3 undefined false new-navbar">
            <div className="container max-w-full px-4 mx-auto flex flex-wrap items-center justify-between undefined">
                <div className="lg:flex flex-grow items-center block undefined">
                    <ul className="flex lg:items-center flex-col lg:flex-row list-none mr-auto undefined">
                        <a href="/" className="false false px-5 py-4 flex gap-1 items-center text-xl uppercase font-medium leading text-white rounded-lg nav-direct"><span
                        className="material-icons undefined undefined leading-none ">home</span>Home</a><a
                        href="/invest-page"
                        className="false false px-5 py-4 flex gap-1 items-center text-xl uppercase font-medium leading text-white rounded-lg nav-direct"><span
                        className="material-icons undefined undefined leading-none ">language</span>Profit calculator</a><a
                        href="/fix-match-page"
                        className="false false px-5 py-4 flex gap-1 items-center text-xl uppercase font-medium leading text-white rounded-lg nav-direct"><span
                        className="material-icons undefined undefined leading-none ">settings</span>Fix profitable
                        matches</a>
                        <Offices setFilter={props.setFilter} />
                        <Sports setFilter={props.setFilter} />
                    </ul>
                    <User logOut={props.logOut} currentUser={props.currentUser}/>
                    <div
                        className="relative flex items-center text-xl bg-white bg-opacity-20 py-1 px-3 rounded-lg">
                        <span className="material-icons text-white text-2xl mr-2">search</span><input type="text"
                                                                                                     placeholder="Search here"
                                                                                                     className="bg-transparent border-none text-xl leading-snug text-white w-full font-normal placeholder-white placeholder-opacity-50 focus:outline-none focus:ring-0"></input>
                    </div>
                </div>
            </div>
        </nav>
    );
}

export default TopNavbar;