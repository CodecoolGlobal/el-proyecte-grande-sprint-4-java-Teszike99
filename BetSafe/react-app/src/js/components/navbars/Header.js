import image from "../../../images/bat.png";
import batmanImage from "../../../images/batman.png";


 const Header = () => {
     return (
         <div className="header">
             <img className="image-header" id="batman" src={batmanImage} alt=''/>
             <img className="image-header" id="bat_title" src={image} alt=''/>
             <b className="sub-title">Live your life, free from risk</b>
         </div>

    )
}

export default Header;
