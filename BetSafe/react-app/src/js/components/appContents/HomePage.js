import image from "../../../images/bet.png";

const HomePage = () => {
    return (
        <div>
            <div className="home-container">

                <img className="home-image-container" src={image} alt=''/>
                <br/><br/><br/>
                <b>
                    BetSafe is an online betting company that offers online sports betting.
                    On this site you can place sports bets with the least possible risk.
                    You can enter a sum of money after which the site calculates the best options
                    based on match odds and betting offices.
                </b>
            </div>;
        </div>
    )
}

export default HomePage;